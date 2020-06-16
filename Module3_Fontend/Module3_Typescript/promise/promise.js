var XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;
const fetch = require("node-fetch");

var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const wait5Secs = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(5);
    }, 5000);
});
wait5Secs.then((data) => console.log(data)).catch((err) => console.error(err));
function httpGet(url) {
    return new Promise(function (resolve, reject) {
        const request = new XMLHttpRequest();
        request.onload = function () {
            if (this.status === 200) {
                // Success
                resolve(this.response);
            }
            else {
                // Something went wrong (404 etc.)
                reject(new Error(this.statusText));
            }
        };
        request.onerror = function () {
            reject(new Error("XMLHttpRequest Error: " + this.statusText));
        };
        request.open("GET", url);
        request.send();
    });
}
httpGet("https://api.github.com/search/repositories?q=angular").then(function (value) {
    console.log("Contents: " + value);
}, function (reason) {
    console.error("Something went wrong", reason);
});
// parseJSON
function parseResponse(value) {
    try {
        return JSON.parse(value);
    }
    catch (_) {
        return value;
    }
}
httpGet("https://api.github.com/search/repositories?q=angular")
    .then(parseResponse)
    .then((data) => console.log(data))
    .catch(function (reason) {
    console.error("Something went wrong", reason);
});
// promise chỉ resolve hoặc reject duy nhất 1 lần
const promise = new Promise((resolve, reject) => {
    resolve("done");
    reject(new Error("…")); // ignored
    setTimeout(() => resolve("…")); // ignored
});
promise.then((data) => console.log(data));
/**
 * Async/Await
 */
function f() {
    return __awaiter(this, void 0, void 0, function* () {
        return 1;
    });
}
function fp() {
    return Promise.resolve(1);
}
f().then((data) => console.log("async fn", data));
(() => __awaiter(this, void 0, void 0, function* () {
    const data = yield fp();
    console.log("async/await", data);
}))();
function fns() {
    return __awaiter(this, void 0, void 0, function* () {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => resolve("done!"), 1000);
        });
        // wait till the promise resolves (*)
        const result = yield promise;
        console.log(result); // "done!"
    });
}
fns();
// handle error
function getUser(username) {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const response = yield fetch(`https://api.github.com/search/users?q=${username}`);
            return yield response.json();
        }
        catch (e) {
            throw e;
        }
    });
}
getUser("bob")
    .then((res) => console.log(res))
    .catch((err) => console.warn(err));
// do not combine sync operations with async/await
(() => {
    let x = 0;
    function r5() {
        return __awaiter(this, void 0, void 0, function* () {
            x += 1;
            console.log(x);
            return 5;
        });
    }
    (() => __awaiter(this, void 0, void 0, function* () {
        x += yield r5();
        console.log(x);
    }))();
})();
// fixed version
(() => {
    let x = 0;
    function r5() {
        return __awaiter(this, void 0, void 0, function* () {
            x += 1;
            console.log(x);
            return 5;
        });
    }
    (() => __awaiter(this, void 0, void 0, function* () {
        const y = yield r5();
        x += y;
        console.log(x);
    }))();
})();
// Too Sequential
function fetchAllBook() {
    return __awaiter(this, void 0, void 0, function* () {
        yield new Promise((resolve) => {
            console.log("Waiting 2s...");
            setTimeout(() => resolve(), 2000);
        });
        console.log("fetchAllBook");
        return [
            {
                id: "book-id-1",
                authorId: "author-id-1",
            },
            {
                id: "book-id-2",
                authorId: "author-id-2",
            },
            {
                id: "book-id-3",
                authorId: "author-id-3",
            },
        ];
    });
}
function fetchAuthorById(authorId) {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("fetchAuthorById");
        return {
            authorId,
        };
    });
}
function getBooksAndAuthor(authorId) {
    return __awaiter(this, void 0, void 0, function* () {
        const books = yield fetchAllBook();
        const author = yield fetchAuthorById(authorId);
        return {
            author,
            books: books.filter((book) => book.authorId === authorId),
        };
    });
}
getBooksAndAuthor("author-id-2");
// Too Sequential fixed
function getBooksAndAuthorFixed(authorId) {
    return __awaiter(this, void 0, void 0, function* () {
        const bookPromise = fetchAllBook();
        const authorPromise = fetchAuthorById(authorId);
        const books = yield bookPromise;
        const author = yield authorPromise;
        return {
            author,
            books: books.filter((book) => book.authorId === authorId),
        };
    });
}
getBooksAndAuthorFixed("author-id-2");

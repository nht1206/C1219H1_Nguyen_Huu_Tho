var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function fetchRepo() {
    return __awaiter(this, void 0, void 0, function* () {
        let res = yield fetch('https://api.github.com/search/repositories?q=angular');
        res = (yield res.json());
        return res.items;
    });
}
function createItem(text) {
    const item = document.createElement('li');
    item.textContent = text;
    return item;
}
const container = document.querySelector('.app .list');
function main() {
    return __awaiter(this, void 0, void 0, function* () {
        // step 1: fetch repo
        const res = yield fetchRepo();
        // step 2: lặp qua mảng các item trả về
        // step 3: call hàm createItem sau đó truyền vào name của từng item ở mỗi vòng lặp
        // step 4: call hàm container.appendChild(item mà hàm createItem trả về)
        res.forEach((item) => {
            const li = createItem(item.name);
            container.appendChild(li);
        });
    });
}
main();

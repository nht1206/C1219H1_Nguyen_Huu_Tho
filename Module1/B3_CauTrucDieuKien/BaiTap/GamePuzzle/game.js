var Images = {
    imgsDB:
        [
            [
                "funny-cat1_part1.jpg",
                "funny-cat1_part2.jpg",
                "funny-cat1_part3.jpg",
                "funny-cat1_part4.jpg",
                "funny-cat1_part5.jpg"
            ],
            [
                "monkey_part1.jpg",
                "monkey_part2.jpg",
                "monkey_part3.jpg",
                "monkey_part4.jpg",
                "monkey_part5.jpg"
            ],
            [
                "panda_swap_part1.jpg",
                "panda_swap_part2.jpg",
                "panda_swap_part3.jpg",
                "panda_swap_part4.jpg",
                "panda_swap_part5.jpg"
            ]
        ],
    imgpos: [0, 0, 0, 0, 0]
}

function placeImg(imgPos, imgPart) {
    Images.imgpos[imgPos - 1] = imgPart;
    document.getElementById("img" + imgPos.toString()).src = "./images/" + Images.imgsDB[imgPart][imgPos - 1];
}

function getRamdomImg() {
    for (let i = 1; i <= 5; i++) {
        let randomNumber = Math.floor(Math.random() * 3);
        placeImg(i, randomNumber);
    }
}
function isCorrect() {
    for (let i = 1; i <= 5; i++)
    {
        if (Images.imgpos[i] !== Images.imgpos[i - 1]) {
            return true;
        }
    }
    return true;
}
function setCssToCorrectImg() {
    if(isCorrect()){

    } else {

    }
}
var main = function ()
{
    getRamdomImg();
    setCssToCorrectImg();
}
document.onload = main();
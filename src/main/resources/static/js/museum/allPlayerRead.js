// 이미지 처리
displayAjax();

function displayAjax(){
    let playerNumber = $('.player-num').val();

    $.ajax({
        url : '/museumFile/imgList',
        type : 'get',
        data : {playerNumber : playerNumber},
        success : function (files){
            let text = '';

            files.forEach(file => {
                let fileName = file.playerFileUploadPath + '/' + file.playerFileUuid + '_' + file.playerFileName;
                text += `<img class="img-list" src="/museumFile/display?fileName=${fileName}"/>`;
            });
            $('.file-wrap').html(text);
        }
    })
}




const expandButton = document.getElementById("expandButton");
const contentBox = document.querySelector(".contentBox");
const playerContent = document.getElementById("playerContent");

let isExpanded = false;

expandButton.addEventListener("click", () => {
    if (!isExpanded) {
        contentBox.style.maxHeight = "none";
        expandButton.textContent = "확대하기 ▲";
        isExpanded = true;
    } else {
        contentBox.style.maxHeight = "210px";
        expandButton.textContent = "축소하기 ▽";
        isExpanded = false;
    }
});

// 맨위로
// const linkTopButton = document.querySelector(".link_top");
//
// linkTopButton.addEventListener("click", () => {
//     window.scrollTo({ top: 0, behavior: "smooth" });
// });

// 뉴스
let $styleBox = $(".news-box");
let $styleImg = $(".news-content");
let currentIdx2 = 0;
let styleWidth = 33.33; // Adjusted for 3 items
let styleCnt = $styleImg.length;

checkEnd();

$(".news-section .next").on("click", function () {
    console.log("next!!");
    currentIdx2++;
    updateCarousel();
});

$(".news-section .prev").on("click", function () {
    console.log("prev!!");
    currentIdx2--;
    updateCarousel();
});

function updateCarousel() {
    let translateXValue = -currentIdx2 * styleWidth;
    $styleBox.css("transform", "translateX(" + translateXValue + "%)");
    $styleBox.css("transition", "0.5s ease");
    checkEnd();
}

function checkEnd() {
    if (currentIdx2 <= 0) {
        $(".news-section .prev").css("display", "none");
    } else {
        $(".news-section .prev").css("display", "block");
    }

    if (currentIdx2 >= styleCnt - 3) {
        $(".news-section .next").css("display", "none");
    } else {
        $(".news-section .next").css("display", "block");
    }
}

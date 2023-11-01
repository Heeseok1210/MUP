$(document).ready(function () {
    const memeItems = $(".Utube-content");
    let currentIndex = 0;

    function showItem(index) {
        memeItems.hide();
        memeItems.eq(index).show();
    }

    // 초기 상태에서 첫 번째 iframe만 표시
    showItem(currentIndex);

    // 이전 버튼 클릭 시
    $(".prev").on("click", function () {
        currentIndex = (currentIndex - 1 + memeItems.length) % memeItems.length;
        showItem(currentIndex);
    });

    // 다음 버튼 클릭 시
    $(".next").on("click", function () {
        currentIndex = (currentIndex + 1) % memeItems.length;
        showItem(currentIndex);
    });
});

// 레전드선수
let $styleBox = $(".legend-box");
let $styleImg = $(".legend-content");
let currentIdx2 = 0;
let styleWidth = 360;
let styleCnt = $styleImg.length;

checkEnd();

$(".third-banner .right").on("click", function () {
    console.log("next!!");
    currentIdx2++;
    $styleBox.css("left", -(currentIdx2 * styleWidth));
    $styleBox.css("transition", "0.5s ease");
    checkEnd();
});

$(".third-banner .left").on("click", function () {
    console.log("prev!!");
    currentIdx2--;
    $styleBox.css("left", -(currentIdx2 * styleWidth));
    $styleBox.css("transition", "0.5s ease");
    checkEnd();
});

function checkEnd() {
    if (currentIdx2 <= 0) {
        $(".third-banner .left").css("display", "none");
    } else {
        $(".third-banner .left").css("display", "block");
    }

    if (currentIdx2 >= styleCnt - 3) {
        $(".third-banner .right").css("display", "none");
    } else {
        $(".third-banner .right").css("display", "block");
    }
}

// 맨위아래로
const linkTopButton = document.querySelector(".link_top");
const linkBottomButton = document.querySelector(".link_down");

linkTopButton.addEventListener("click", () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
});

linkBottomButton.addEventListener("click", () => {
    const documentHeight = document.documentElement.scrollHeight;
    const windowHeight = window.innerHeight;
    window.scrollTo({ top: documentHeight - windowHeight, behavior: "smooth" });
});

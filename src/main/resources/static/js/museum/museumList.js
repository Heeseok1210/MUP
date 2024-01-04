$(document).ready(function () {
    const memeItems = $(".ListLi");
    const numItems = memeItems.length;
    let currentIndex = 0;

    function showItems(startIndex) {
        memeItems.hide();
        for (let i = startIndex; i < startIndex + 2; i++) {
            memeItems.eq(i % numItems).show();
        }
    }

    // 초기 상태에서 랜덤한 2개의 아이템 표시
    currentIndex = Math.floor(Math.random() * numItems);
    showItems(currentIndex);

    // 다음 버튼 클릭 시 랜덤한 2개의 아이템 표시
    $(".next").on("click", function () {
        currentIndex = Math.floor(Math.random() * numItems);
        showItems(currentIndex);
    });

    // 이전 버튼 클릭 시 랜덤한 2개의 아이템 표시
    $(".prev").on("click", function () {
        currentIndex = Math.floor(Math.random() * numItems);
        showItems(currentIndex);
    });
});

// 레전드 선수
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

// 더보기
$('.infoBtn').on('click', function (){
    window.location.href = '/museum/legendList';
})

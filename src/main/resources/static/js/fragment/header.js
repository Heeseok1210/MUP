// 모달창
var modalBtn = document.getElementById("button0");

// 버튼을 클릭했을 때 모달 열기
modalBtn.addEventListener("click", function () {
    noticeModal.style.display = "block";
});

// 닫기 버튼 가져오기
var modalCloseBtn = document.getElementsByClassName("close")[0];

// 닫기 버튼을 클릭했을 때 모달 닫기
modalCloseBtn.addEventListener("click", function () {
    noticeModal.style.display = "none";
});

// 드롭다운 박스 설정
$('.header-icon').click(function() {
    $(this).find('.dropdown-content-header').toggle();
//   헤더 제외 다른 부분 어둡게 하는 코드 추가 필요
});

$(document).click(function(e) {
    var target = e.target;
    if (!$(target).is('.header-icon') && !$(target).parents().is('.header-icon')) {
        $('.dropdown-content-header').hide();
    }
});
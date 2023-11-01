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

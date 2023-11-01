// 드롭다운 박스
$(document).ready(function () {
    $(".dropdown").click(function () {
        $(this).find(".dropdown-menu").toggle();
    });

    $(document).click(function (e) {
        var target = e.target;
        if (!$(target).is(".dropdown") && !$(target).parents().is(".dropdown")) {
            $(".dropdown-menu").hide();
        }
    });
});

$(".dropdown-menu li").on("click", function () {
    let $input = $(".dropdown-btn");
    let text = $(this).text();
    $input.html(
        text +
        `
  <span class="material-symbols-rounded">
  expand_more
  </span>
  `
    );
});

// 아이디 중복검사
$(document).ready(function () {
    // 중복 검사 버튼 클릭 시 이벤트 처리
    $(".double-check").click(function () {
        var userId = $(".id-box").val(); // 입력된 사용자 아이디

        // Ajax 요청
        $.ajax({
            url: "/users/checkId",
            type: "GET",
            data: { userId: userId },
            success: function (result) {
                // 중복 여부에 따라 처리
                if (result == 0) {
                    $(".id-err-text2").css("display", "inline-block");
                    $(".id-err-text").css("display", "none");
                } else {
                    $(".id-err-text").css("display", "inline-block");
                    $(".id-err-text2").css("display", "none");
                }
            },
            error: function () {
                console.log("오류 발생");
            },
        });
    });
});

// 비밀번호 일치
let pw1;
let pw2;

// 비밀번호 정규식 (특수문자, 8글자 이상)
let regex;

$(".password-box").on("change", function () {
    pw1 = $(this).val();
    regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    console.log(pw1);
    if (regex.test(pw1)) {
        $(".pw-err-text").css("display", "none");
    } else {
        $(".pw-err-text").css("display", "inline-block");
    }
});

$(".repassword-box").on("change", function () {
    pw2 = $(this).val();
    console.log(pw2);
    if (pw1 == pw2) {
        $(".pw-err-text2").css("display", "inline-block");
        $(".pw-err-text1").css("display", "none");
    } else {
        $(".pw-err-text1").css("display", "inline-block");
        $(".pw-err-text2").css("display", "none");
    }
});

// 닉네임 중복검사
$(".nickname-box").on("blur", function () {
    var userNickname = $(".nickname-box").val();

    $.ajax({
        url: "/users/checkNickname",
        type: "GET",
        data: { userNickname: userNickname },
        success: function (result) {
            // 중복 여부에 따라 처리
            if (result == 0) {
                $(".nickName-err-text2").css("display", "inline-block");
                $(".nickName-err-text").css("display", "none");
            } else {
                $(".nickName-err-text").css("display", "inline-block");
                $(".nickName-err-text2").css("display", "none");
            }
        },
        error: function () {
            console.log("오류 발생");
        },
    });
});

// 이메일 주소 연결
let emailReal;
let email2;
let result;

$(".email-box").on("change", function () {
    let email = $(this).val();
    console.log(email);

    email2 = email;
});

$(".dropdown-menu li").on("click", function () {
    let text = $(this).text();
    if (text == "직접입력") {
        $(".realEmail").val(email2);
        console.log($(".realEmail").val());
        return;
    } else {
        emailReal = email2 + text;
        $(".realEmail").val(emailReal);
    }

    console.log($(".realEmail").val());
});

// 썸네일 미리보기
let $input = $("#post-image");
let $imgList = $(".img-list");
// console.log($input);

// file change이벤트로 미리보기 갱신하기
$input.on("change", function () {
    let files = this.files;
    //   console.log(files);

    // 길이 체크함수 (files, 원하는 길이)
    let newFiles = checkLength(files, 5);

    appendImg(newFiles);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
$imgList.on("click", function (e) {
    let name = $(e.target).data("name");
    removeImg(name);
    appendImg($input[0].files);
});

//미리보기 삭제 함수
function removeImg(name) {
    let dt = new DataTransfer();

    let files = $input[0].files;

    for (let i = 0; i < files.length; i++) {
        if (files[i].name !== name) {
            dt.items.add(files[i]);
        }
    }
    $input[0].files = dt.files;
}

//파일 길이 체크 함수(체크할 files객체, 제한할 길이)
function checkLength(files, num) {
    if (files.length > num) {
        alert(`파일은 최대 ${num}개까지만 첨부 가능합니다.`);
        // 최대 수를 넘으면 비어있는 files객체 반환
        return new DataTransfer().files;
    }
    return files;
}

// 이미지 미리보기 처리 함수
function appendImg(files) {
    for (let i = 0; i < 5; i++) {
        if (i < files.length) {
            let src = URL.createObjectURL(files[i]);

            $imgList
                .eq(i)
                .css("background-image", `url(${src})`)
                .css("background-size", "contain")
                .data("name", `${files[i].name}`);

            $imgList.eq(i).addClass("x-box");
        } else {
            $imgList
                .eq(i)
                .css(
                    "background",
                    "url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzNiIgaGVpZ2h0PSIzNiI+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48ZyBzdHJva2U9IiNCNUI1QjUiIHN0cm9rZS13aWR0aD0iMS41IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0IDQpIj48cmVjdCB3aWR0aD0iMjgiIGhlaWdodD0iMjgiIHJ4PSIzLjUiLz48Y2lyY2xlIGN4PSI4LjU1NiIgY3k9IjguNTU2IiByPSIyLjMzMyIvPjxwYXRoIGQ9Ik0yOCAxOC42NjdsLTcuNzc3LTcuNzc4TDMuMTExIDI4Ii8+PC9nPjxwYXRoIGQ9Ik0wIDBoMzZ2MzZIMHoiLz48L2c+PC9zdmc+) no-repeat 50% #f2f2f2"
                )
                .data("name", null);
            $imgList.eq(i).removeClass("x-box");
        }
    }
}

// 카테고리
function showUserInformation(button) {
    // 스쿼드 제작 화면 숨기기
    document.getElementById("mySquadMaker").style.display = "none";
    // 사용자 정보 화면 보이기
    document.getElementById("userInformation").style.display = "block";

    // 사용자 정보 버튼에 "active" 클래스 추가
    button.classList.add("active");

    // 스쿼드 버튼에서 "active" 클래스 제거
    document.getElementById("button1").classList.remove("active");
}

function showSquadMaker(button) {
    // 사용자 정보 화면 숨기기
    document.getElementById("userInformation").style.display = "none";
    // 스쿼드 제작 화면 보이기
    document.getElementById("mySquadMaker").style.display = "block";

    // 스쿼드 버튼에 "active" 클래스 추가
    button.classList.add("active");

    // 사용자 정보 버튼에서 "active" 클래스 제거
    document.getElementById("button0").classList.remove("active");
}

// 초기에 사용자 정보 화면 보이기 및 버튼 색 설정
showUserInformation(document.getElementById("button0"));

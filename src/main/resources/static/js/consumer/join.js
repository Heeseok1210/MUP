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
        var consumerId = $(".id-box").val(); // 입력된 사용자 아이디

        // Ajax 요청
        $.ajax({
            url: "/users/checkId",
            type: "GET",
            data: { consumerId: consumerId },
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
    var consumerNickname = $(".nickname-box").val();

    $.ajax({
        url: "/users/checkNickname",
        type: "GET",
        data: { consumerNickname: consumerNickname },
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

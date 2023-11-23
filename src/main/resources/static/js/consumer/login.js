$(document).ready(function(){
    $('.login-btn').click(function (){
        var consumerId = $(".login-box").val();
        var consumerPassword = $(".password-box").val();

        $.ajax({
            url : "/consumers/loginFail",
            type: "GET",
            data: {
                consumerId : consumerId,
                consumerPassword : consumerPassword
            },
            success : function(result){
                if(result == 0){
                    alert("로그인 또는 비밀번호가 일치하지 않습니다");
                    // $('id-pw-no').css("display", "inline-block");
                }
            },
            error: function(){
                console.log("로그인 오류!!");
            }
        });
    });
});
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
const linkTopButton = document.querySelector(".link_top");

linkTopButton.addEventListener("click", () => {
    window.scrollTo({ top: 0, behavior: "smooth" });
});

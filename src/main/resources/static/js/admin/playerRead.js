// 이미지 처리
displayAjax();

function displayAjax(){
    let playerNumber = $('.player-num').val();

    $.ajax({
        url : '/adminFile/imgList',
        type : 'get',
        data : {playerNumber : playerNumber},
        success : function (files){
            let text = '';

            files.forEach(file => {
                let fileName = file.playerFileUploadPath + '/' + file.playerFileUuid + '_' + file.playerFileName;
                text += `<img class="img-list" src="/adminFile/display?fileName=${fileName}"/>`;
            });
            $('.file-wrap').html(text);
        }
    })
}

// 뒤로가기
$('.before').on('click', function(){
    window.location.href = '/admin/list';
})
// 삭제하기
$('.delete').on('click', function (){
    let playerNumber = $('.player-num').val();
    window.location.href = '/admin/remove?playerNumber=' + playerNumber;

    // 참고
    // let obj = document.createElement('input');
    // obj.setAttribute('type', 'hidden');
    // obj.setAttribute('name', 'playerNumber');
    // obj.setAttribute('value', playerNumber);
    //
    // let f = document.createElement('form');
    // f.appendChild(obj);
    // f.setAttribute('method', 'post');
    // f.setAttribute('action', '/admin/remove')
    // document.body.appendChild(f);
    // f.submit();
})

// 수정하기
$('.modify').on('click', function(){
    let playerNumber = $('.player-num').val();
    window.location.href = '/admin/modify?playerNumber=' + playerNumber;
})


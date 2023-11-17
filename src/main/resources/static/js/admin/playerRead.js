
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


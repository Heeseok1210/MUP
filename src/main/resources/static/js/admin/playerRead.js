
// 뒤로가기
$('.before').on('click', function(){
    window.location.href = '/admin/list';
})
// 삭제하기
$('.delete').on('click', function (){
    let playerNumber = $('.player-num').val();
    window.location.href = '/admin/remove?playerNumber=' + playerNumber;
})

// 수정하기
$('.modify').on('click', function(){
    let playerNumber = $('.player-num').val();
    window.location.href = '/admin/modify?playerNumber=' + playerNumber;
})
$(document).ready(function () {
    var positionSelect = $("#positionNumber");

    if (positionSelect.length > 0) {
        var positions = ["", "GK", "DF", "MF", "FW"];
        for (var i = 0; i < positions.length; i++) {
            var option = $("<option>");
            option.val(positions[i]);
            option.text(positions[i] === "" ? "포지션 선택" : positions[i]);
            positionSelect.append(option);
        }

        positionSelect.trigger("change");

        positionSelect.on("change", function () {
            var selectedValue = positionSelect.val();

            if (selectedValue !== null) {
                var obj = {
                    positionName: selectedValue,
                    keyword: $('.select-title').val()
                };

                searchModule(1, obj, showSearchResult, paging);
            }
        });
    }

    searchModule(1, { positionName: "", keyword: "" }, showSearchResult, paging);
});



let obj = {};
$('.search').on('click', function (){
    obj = {
        positionName: $("#positionNumber").find("option:selected").text(),
        keyword : $('.select-title').val()
    };
    searchModule(1, obj, showSearchResult, paging);
    console.log("obj = " + obj.keyword);
});

$("#positionNumber").on('change', function (){
    obj = {
        positionName: $("#positionNumber").find("option:selected").text(),
        keyword : $('.select-title').val()
    };
    searchModule(1, obj, showSearchResult, paging);
    console.log("obj = " + obj.keyword + obj.positionName);
})

//검색 모듈 (비동기)
function searchModule(page, obj, callback, paging){
    $.ajax({
        url : `/museumR/legendPlayerList/${page}`,
        type : 'get',
        data : obj,
        dataType : 'json',
        success : function (result){
            if (callback){
                callback(result);
                paging(result);
            }
        },
        error : function (a,b,c){
            console.error(c);
        }
    });
}

//검색 결과 화면에 뿌리는 함수
function showSearchResult(result){
    console.log(result);
    let playerList = result.playerList;


    $('.list-ul').html('');

    for (let i=0; i<playerList.length; i++) {
        let positionColorClass = '';
        switch (playerList[i].positionName){
            case 'FW':
                positionColorClass = 'red';
                break;
            case 'MF':
                positionColorClass = 'green';
                break;
            case 'DF':
                positionColorClass = 'blue';
                break;
            case 'GK':
                positionColorClass = 'yellow';
                break;
            default:
                positionColorClass = '';
        }
        $('.list-ul').append(`
            <li class="list-li">
               <a href="/museum/read?playerNumber=${playerList[i].playerNumber}">
                    <div class="img-list">
                           <div unless="${playerList[i].playerFileName == null}" class="main-img-player" style="${'background-image: url(/upload/' + playerList[i].playerFileUploadPath + '/th_' + playerList[i].playerFileUuid + '_' + playerList[i].playerFileName + ')'}"></div>
                       </div>
               </a>
                     <div class="player-title-box">
                        <p class="player-title">${playerList[i].playerName}</p>
                        <p class="player-position ${positionColorClass}">${playerList[i].positionName}</p>
                     </div>
            </li>
        `);
    }
}

//페이징 처리
function paging(result){
    let pageInfo = result.page;
    let text = '';

    text += `
    ${pageInfo.prev ?
        '<a href="javascript:void(0)" class="prev" onclick="searchModule(' + (pageInfo.startPage-1) + ',obj,showSearchResult,paging)"><li>&laquo;</li></a>'
        :''}
  `;

    for(let i=pageInfo.startPage; i<=pageInfo.endPage; i++){
        text +=`
      <a href="javascript:void(0)" onclick="searchModule(${i},obj,showSearchResult,paging)">
      ${pageInfo.criteria.page == i ?
            '<li class="active">' + i + '</li>'
            :
            '<li>' + i +'</li>'
        }
      </a>
    `;
    }

    text += `
    ${pageInfo.next ?
        '<a href="javascript:void(0)" class="next" onclick="searchModule(' + (pageInfo.endPage+1) + ',obj,showSearchResult,paging)"><li>&raquo;</li></a>'
        :''}
  `;

    $('.pagination > ul').html(text);
}




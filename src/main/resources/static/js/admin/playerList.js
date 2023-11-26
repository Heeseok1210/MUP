$(document).ready(function () {
    var positionSelect = $("#positionNumber");

    if (positionSelect.length > 0) {
        var positions = ["GK", "DF", "MF", "FW"];
        for (var i = 0; i < positions.length; i++) {
            var option = $("<option>");
            option.val(i + 1);
            option.text(positions[i]);
            positionSelect.append(option);
        }

        positionSelect.on("change", function () {
            var selectedValue = positionSelect.val();

            // 선택된 값에 해당하는 텍스트 가져오기
            var selectedText = positionSelect.find("option:selected").text();

            console.log("Selected position value: " + selectedValue);
            console.log("Selected position text: " + selectedText);
        });
    }
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
        url : `/adminR/allPlayerList/${page}`,
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


    $('.listUl').html('');
    for (let i=0; i<playerList.length; i++) {
        $('.listUl').append(`
            <li class="list-li">
               <a href="/admin/read?playerNumber=${playerList[i].playerNumber}">
                    <div class="img-list">
                       <div if="${playerList[i].playerFileName == null}" class="main-img"  style="background-color: indianred"></div>
                           <div unless="${playerList[i].playerFileName == null}" class="main-img" style="${'background-image: url(/upload/' + playerList[i].playerFileUploadPath + '/th_' + playerList[i].playerFileUuid + '_' + playerList[i].playerFileName + ')'}"></div>
                       </div>
               </a>
                     <div class="player-title-box">
                        <p class="player-title">${playerList[i].playerName}</p>
                        <p class="player-position">${playerList[i].positionName}</p>
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
        '<a href="javascript:void(0)" class="prev" onclick="searchModule(' + (pageInfo.startPage-1) + ',obj,showSearchResult,paging)"><li>&lt;</li></a>'
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
        '<a href="javascript:void(0)" class="next" onclick="searchModule(' + (pageInfo.endPage+1) + ',obj,showSearchResult,paging)"><li>&gt;</li></a>'
        :''}
  `;

    $('.pagination > ul').html(text);
}




let obj = {};

// 검색 버튼 클릭 이벤트
$('.searchBtn').on('click', function (){
    obj = {
        keyword : $('.search_input').val()
    };
    searchModule(1, obj, showSearchResult, paging);
    console.log("obj = " + obj.keyword);
});




// 검색 모듈(비동기)
function searchModule(page, obj, callback, paging){
    $.ajax({
        url : `/museumR/playerSearchList/${page}`,
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

// 검색 결과 화면에 뿌리는 함수
function showSearchResult(result) {
    console.log(result);

    let playerList = result.playerList;
    let count = 1; // 초기값을 1로 설정

    $('.playerListA').html('');

    if (playerList.length === 0) {
        $('.playerListA').append(`
            <tr>
                <td colspan="5" class="no-results">등록된 선수가 없습니다.</td>
            </tr>
        `);
    } else {
        for (let i = 0; i < playerList.length; i++) {
            let positionColorClass = '';
            switch (playerList[i].positionName) {
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

            $('.playerListA').append(`
                <tr class="player_info">
                    <td scope="row" class="main_list_number">
                        <div class="wrap_num">${count}</div>
                    </td>
                    <td scope="row" class="main_list_name">
                        <span class="playerProfile">
                            <a class="wrap_name" href="/museum/read?playerNumber=${playerList[i].playerNumber}">${playerList[i].playerName}</a>
                            <img src="${'/upload/' + playerList[i].playerFileUploadPath + '/th_' + playerList[i].playerFileUuid + '_' + playerList[i].playerFileName}" alt="" class="playerImg" />
                        </span>
                    </td>
                    <td scope="row" class="main_list_backNumber">
                        <div class="wrap_backNumber">${playerList[i].playerBacknumber}</div>
                    </td>
                    <td scope="row" class="main_list_position">
                        <div class="wrap_position">
                            [ <span class="position_info ${positionColorClass}">${playerList[i].positionName}</span> ]
                        </div>
                    </td>
                    <td scope="row" class="main_list_look">
                        <div class="wrap_look">${playerList[i].playerViewCnt}</div>
                    </td>
                </tr>
            `);

            // count 증가
            count++;
        }
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
      ${pageInfo.criteriaAct.page == i ?
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
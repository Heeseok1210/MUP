document.addEventListener("DOMContentLoaded", function () {
    // squad-selector 요소를 찾습니다.
    var squadSelector = document.querySelector(".squad-selector");

    // squad-selector를 클릭할 때마다 토글 함수를 호출합니다.
    squadSelector.addEventListener("click", function () {
        // squad-selector에 active 클래스를 추가/제거합니다.
        squadSelector.classList.toggle("active");
    });

    $(document).ready(function () {
        // a 태그를 클릭했을 때의 이벤트 처리
        $(".squad-list-type a").on("click", function (event) {
            // 이벤트의 기본 동작을 막습니다.
            event.preventDefault();

            // 선택한 a 태그의 data-value 값을 가져옵니다.
            var formationValue = $(this).data("value");

            // 선택한 포메이션에 해당하는 HTML 코드로 교체합니다.
            changeFormation(formationValue);
            updateFormationName(formationValue);
        });

        // 포메이션 변경 함수
        function changeFormation(formationValue) {
            // 선택한 포메이션에 해당하는 HTML 코드로 교체
            var newFormationHTML = getFormationHTML(formationValue);
            $(".squadMaker-View").html(newFormationHTML);
        }

        function updateFormationName(formationValue) {
            // 포메이션 이름을 업데이트
            var formationName = getFormationName(formationValue);
            $(".squadMaker-selector-current-value").text(formationName);
        }

        // 포메이션에 해당하는 HTML 코드를 반환하는 함수
        function getFormationHTML(formationValue) {
            // 3back
            if (formationValue === "f343") {
                return `
      <div class="squadMaker-View">
      <div class="squadMaker-field f343">
        <!-- 골키퍼 -->
        <div class="player1 gk" id="player1">
          <span class="empty1 gkPart" id="empty1">
            <span style="display: none;" class="positionNameP">GK</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">GK</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 수비수 -->
        <div class="player2 rcb" id="player2">
          <span class="empty1 rcbPart" id="empty1">
          <span style="display: none;" class="positionNameP">LCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player3 lcb" id="player3">
          <span class="empty3 lcbPart" id="empty3">
          <span style="display: none;" class="positionNameP">LCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player4 cb" id="player4">
          <span class="empty4 cbPart" id="empty4">
          <span style="display: none;" class="positionNameP">CB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">CB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 미드 필더 -->
        <div class="player5 rcm" id="player5">
          <span class="empty5 rcmPart" id="empty5">
          <span style="display: none;" class="positionNameP">RCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player6 lcm" id="player6">
          <span class="empty6 lcmPart" id="empty6">
          <span style="display: none;" class="positionNameP">LCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player7 rm" id="player7">
          <span class="empty7 rmPart" id="empty7">
          <span style="display: none;" class="positionNameP">RM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player8 lm" id="player8">
          <span class="empty8 lmPart" id="empty8">
          <span style="display: none;" class="positionNameP">LM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 공격수 -->
        <div class="player9 rf" id="player9">
          <span class="empty9 rfPart" id="empty9">
          <span style="display: none;" class="positionNameP">RF</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RF</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player10 lf" id="player10">
          <span class="empty10 lfPart" id="empty10">
          <span style="display: none;" class="positionNameP">LF</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LF</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player11 st" id="player11">
          <span class="empty11 stPart" id="empty11">
          <span style="display: none;" class="positionNameP">ST</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">ST</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>
      </div>
    </div>
      `;
            } else if (formationValue == "f3412") {
                return `
      <div class="squadMaker-View">
      <div class="squadMaker-field f3412">
        <!-- 골키퍼 -->
        <div class="player1 gk" id="player1">
          <span class="empty1 gkPart" id="empty1">
          <span style="display: none;" class="positionNameP">GK</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">GK</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 수비수 -->
        <div class="player2 rcb" id="player2">
          <span class="empty2 rcbPart" id="empty2">
          <span style="display: none;" class="positionNameP">RCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player3 lcb" id="player3">
          <span class="empty3 lcbPart" id="empty3">
          <span style="display: none;" class="positionNameP">LCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player4 cb" id="player4">
          <span class="empty4 cbPart" id="empty4">
          <span style="display: none;" class="positionNameP">CB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">CB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 미드 필더 -->
        <div class="player5 rcm" id="player5">
          <span class="empty5 rcmPart" id="empty5">
          <span style="display: none;" class="positionNameP">RCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player6 lcm" id="player6">
          <span class="empty6 lcmPart" id="empty6">
          <span style="display: none;" class="positionNameP">LCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player7 rm" id="player7">
          <span class="empty7 rmPart" id="empty7">
          <span style="display: none;" class="positionNameP">RM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player8 lm" id="player8">
          <span class="empty8 lmPart" id="empty8">
          <span style="display: none;" class="positionNameP">LM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player9 cam" id="player9">
          <span class="empty9 camPart" id="empty9">
          <span style="display: none;" class="positionNameP">CAM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">CAM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 공격수 -->
        <div class="player10 rs" id="player10">
          <span class="empty10 rsPart" id="empty10">
          <span style="display: none;" class="positionNameP">RS</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RS</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player11 ls" id="player11">
          <span class="empty11 lsPart" id="empty11">
          <span style="display: none;" class="positionNameP">LS</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LS</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>
      </div>
    </div>
      `;
            } else if (formationValue == "f442") {
                return `
      <div class="squadMaker-View">
      <div class="squadMaker-field f442">
        <!-- 골키퍼 -->
        <div class="player1 gk" id="player1">
          <span class="empty1 gkPart" id="empty1">
          <span style="display: none;" class="positionNameP">GK</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">GK</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 수비수 -->
        <div class="player2 rcb" id="player2">
          <span class="empty2 rcbPart" id="empty2">
          <span style="display: none;" class="positionNameP">RCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player3 lcb" id="player3">
          <span class="empty3 lcbPart" id="empty3">
          <span style="display: none;" class="positionNameP">LCB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player4 rb" id="player4">
          <span class="empty4 rcPart" id="empty4">
          <span style="display: none;" class="positionNameP">RB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player5 lb" id="player5">
          <span class="empty5 lbPart" id="empty5">
          <span style="display: none;" class="positionNameP">RB</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LB</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 미드 필더 -->
        <div class="player6 rcm" id="player6">
          <span class="empty6 rcmPart" id="empty6">
          <span style="display: none;" class="positionNameP">RCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player7 lcm" id="player7">
          <span class="empty7 lcmPart" id="empty7">
          <span style="display: none;" class="positionNameP">LCM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LCM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player8 rm" id="player8">
          <span class="empty8 rmPart" id="empty8">
          <span style="display: none;" class="positionNameP">RM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">RM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player9 lm" id="player9">
          <span class="empty9 lmPart" id="empty9">
          <span style="display: none;" class="positionNameP">LM</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">LM</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <!-- 공격수 -->
        <div class="player10 cf" id="player10">
          <span class="empty10 cfPart" id="empty10">
          <span style="display: none;" class="positionNameP">CF</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">CF</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>

        <div class="player11 st" id="player11">
          <span class="empty11 stPart" id="empty11">
          <span style="display: none;" class="positionNameP">ST</span>
            <span class="info">
              <span class="back"></span>
              <span class="position">ST</span>
            </span>
            <span class="animate">
              <em></em>
              <em></em>
            </span>
          </span>
        </div>
      </div>
    </div>
      `;
            } else if (formationValue == "f3232") {
                return `
        <div class="squadMaker-View">
        <div class="squadMaker-field f3232">
          <!-- 골키퍼 -->
          <div class="player gk">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">GK</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <!-- 수비수 -->
          <div class="player rcb">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">RCB</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player lcb">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">LCB</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player cb">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">CB</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <!-- 미드 필더 -->

          <div class="player rdm">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">RDM</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player ldm">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">LDM</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player cm">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">CM</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player rm">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">RM</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player lm">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">LM</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <!-- 공격수 -->
          <div class="player cf">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">CF</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>

          <div class="player st">
            <span class="empty">
              <span class="info">
                <span class="back"></span>
                <span class="position">ST</span>
              </span>
              <span class="animate">
                <em></em>
                <em></em>
              </span>
            </span>
          </div>
        </div>
      </div>
        `;
            }

            return formations[formationValue] || "";
        }
        // 포메이션 값으로부터 이름을 얻어오는 함수
        function getFormationName(formationValue) {
            // 각 포메이션에 대한 이름을 정의
            var formationNames = {
                f343: "3-4-3",
                f3412: "3-4-1-2",
                f3232: "3-2-3-2",
                f442: "4-4-2",
                f4222: "4-2-2-2",
                // 다른 포메이션에 대한 이름도 추가 가능
            };

            // 현재 선택된 포메이션에 해당하는 이름을 반환
            return formationNames[formationValue] || "";
        }
    });
});

var playerId; // 전역 변수로 playerId를 선언

// 플레이어 클릭 시 모달 열기
$(document).on("click", "[class^='player']", function () {
    var playerHtml = $(this).html();
    playerId = $(this).attr("id");

    console.log("playerId = " + playerId);

    $("#findModal").css("display", "block");
});

// 모달 닫기 버튼 클릭 시
$(document).on("click", ".closeMo", function () {
    $("#findModal").css("display", "none");
});

$(document).on("click", ".searchPlayer_Img", function () {
    $("#findModal").css("display", "block");
});

// 모달 창에서 searchPlayer_Img을 클릭했을 때
$(document).on("click", ".searchPlayer_Img", function () {
    // 클릭한 이미지의 부모 요소를 찾습니다.
    var closestParent = $(this).closest(".searchPlayerBox");

    // 클릭한 선수 정보를 추출합니다.

    var positionNameClass = closestParent.find(".positionName").attr("class");
    var positionNameText = closestParent.find(".positionName").text();
    var playerNumber = closestParent.find(".playerNumber").text();
    var positionName = closestParent.find(".positionName").text();
    var fameName = closestParent.find(".fameName").text();
    var playerOverall = closestParent.find(".playerOverall").text();
    var playerName = closestParent.find(".playerName").text();
    var playerFileSrc = closestParent.find(".searchPlayer_imgBox").attr("src");

    // 클릭한 선수의 HTML을 가져옵니다.
    var playerHtml = closestParent.html();


    console.log("positionName = " + positionNameClass);
    console.log("playerHtml = " + playerHtml);
    console.log("playerId = " + playerId);

    // 업데이트할 HTML을 생성합니다.
    var updatePlayer = `
        <span class="info">
            <span style="display: none;" class="playerNumber">${playerNumber}</span>
            <span class="playerFileIn">
                <img class="searchPlayer_imgBox" src="${playerFileSrc}" alt="임시썸네일">
            </span>
            <div class="playerInfoIn">
                <span class="playerOverallIn">${playerOverall}</span>
                <span class="positionNameIn">${positionName}</span>
            </div>
            <span class="playerNameIn">${playerName}</span>
        </span>`;

    // 클릭한 플레이어의 ID를 가져와서 해당 ID를 가진 요소에 업데이트된 내용을 추가합니다.
    $("#" + playerId).html(updatePlayer);

    // 모달을 닫습니다.
    $("#findModal").css("display", "none");
});

$(document).ready(function () {
    // ... 기존의 자바스크립트 코드 ...

    // 이 클릭 이벤트 리스너 추가
    $(".save-button").on("click", function () {
        // 선수 번호를 저장할 배열 생성
        var playerList = [];

        // 각 선수 요소를 순환하면서 선수 번호 추출
        $(".squadMaker-View .playerNumber").each(function () {
            var playerNumber = $(this).text();
            // 선수 번호를 배열에 추가
            playerList.push(playerNumber);
        });
            console.log("playerList = " + playerList);
    });
});



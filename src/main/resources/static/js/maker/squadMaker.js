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

        <div class="player rcm">
          <span class="empty">
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

        <div class="player lcm">
          <span class="empty">
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
        <div class="player rf">
          <span class="empty">
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

        <div class="player lf">
          <span class="empty">
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
            } else if (formationValue == "f3412") {
                return `
      <div class="squadMaker-View">
      <div class="squadMaker-field f3412">
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
        <div class="player rcm">
          <span class="empty">
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

        <div class="player lcm">
          <span class="empty">
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

        <div class="player cam">
          <span class="empty">
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
        <div class="player rs">
          <span class="empty">
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

        <div class="player ls">
          <span class="empty">
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

        <div class="player rb">
          <span class="empty">
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

        <div class="player lb">
          <span class="empty">
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
        <div class="player rcm">
          <span class="empty">
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

        <div class="player lcm">
          <span class="empty">
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

// 플레이어 클릭 시 모달 열기
$(document).on("click", ".player", function () {
    // 모달 열기
    $("#findModal").css("display", "block");
});

// 모달 닫기 버튼 클릭 시
$(".closeMo").click(function () {
    $("#findModal").css("display", "none");
});

// 서브플레이어 클릭 시 모달 열기
$(document).on("click", ".subplayer", function () {
    // 모달 열기
    $("#findModal").css("display", "block");
});
// 모달 닫기 버튼 클릭 시
$(".closeMo").click(function () {
    $("#findModal").css("display", "none");
});

$(document).ready(function () {
    var sliderDefaultOption = {
        range: true,
        min: 70,
        max: 100,
        values: [70, 100],
        change: function (event, ui) {
            var target = $(this).slider();
            target.find(".min_num").text(ui.values[0]);
            target.find(".max_num").text(ui.values[1]);
            target.closest(".range_slider").find(".min_val").val(ui.values[0]);
            target.closest(".range_slider").find(".max_val").val(ui.values[1]);
        },
        slide: function (event, ui) {
            var target = $(this).slider();
            target.find(".min_num").text(ui.values[0]);
            target.find(".max_num").text(ui.values[1]);
            target.closest(".range_slider").find(".min_val").val(ui.values[0]);
            target.closest(".range_slider").find(".max_val").val(ui.values[1]);
        },
        create: function (event, ui) {
            var that = this;
            var target = $(this).slider();

            target
                .eq(0)
                .append(
                    "<span class='half_num'>" +
                    Math.floor(
                        ($(this).slider("option", "min") +
                            $(this).slider("option", "max")) /
                        2
                    ) +
                    "</span>"
                );
            target
                .find(".ui-slider-handle")
                .eq(0)
                .append(
                    "<span class='min_num'>" + $(this).slider("values", 0) + "</span>"
                );
            target
                .find(".ui-slider-handle")
                .eq(1)
                .append(
                    "<span class='max_num'>" + $(this).slider("values", 1) + "</span>"
                );
            target
                .closest(".range_slider")
                .find(".min_val")
                .val($(this).slider("values", 0));
            target
                .closest(".range_slider")
                .find(".max_val")
                .val($(this).slider("values", 1));

            target
                .closest(".range_slider")
                .find(".min_val")
                .on("change", function () {
                    if ($(this).val() > $(that).slider("values", 1)) {
                        $(that).slider("values", 0, $(that).slider("values", 1));
                        return;
                    }
                    $(that).slider("values", 0, $(this).val());
                });

            target
                .closest(".range_slider")
                .find(".max_val")
                .on("change", function () {
                    if ($(this).val() < $(that).slider("values", 0)) {
                        $(that).slider("values", 1, $(that).slider("values", 0));
                        return;
                    }
                    $(that).slider("values", 1, $(this).val());
                });
        },
    };

    $("#slider1 .wrap_slider").slider(sliderDefaultOption);
});


$(document).on("click", ".searchPlayer_Img", function () {
    // 클릭한 요소에서 플레이어 정보를 가져옵니다.
    var playerOverall = $(this).find(".playerOverall").text();
    var positionName = $(this).find(".positionName").text();
    var playerName = $(this).find(".playerName").text();

    // 클릭한 요소에서 이미지의 src를 가져옵니다.
    var playerImgSrc = $(this).find(".searchPlayer_imgBox").attr("src");

    // 클릭한 요소의 부모인 .player 요소를 찾습니다.
    var playerContainer = $(this).closest(".player");

    // .player 요소 내의 업데이트가 필요한 부분의 코드를 추가합니다.
    playerContainer.html(`
    <span class="empty">
      <span class="info">
        <span class="playerFile">
          <div class="img-list">
            <img class="searchPlayer_imgBox" alt="플레이어 섬네일" src="${playerImgSrc}">
          </div>
          <div class="playerInfo">
            <span class="playerOverall">${playerOverall}</span>
            <span class="positionName">${positionName}</span>
          </div>
          <span class="playerName">${playerName}</span>
        </span>
      </span>
    </span>
  `);

    // 모달 열기
    $("#findModal").css("display", "block");
});

document.addEventListener("DOMContentLoaded", function () {
    var positionSelcet = document.getElementById("positionNumber");
    var positions = ["GK", "DF", "MF", "FW"];
    for (var i = 0; i < positions.length; i++) {
        var option = document.createElement("option");
        option.value = i + 1;
        option.textContent = positions[i];
        positionSelcet.appendChild(option);
    }
});

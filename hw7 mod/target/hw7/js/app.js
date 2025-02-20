window.notify = function (message) {
    $.notify(message, {
        position: "right bottom",
        className: "success"
    });
}

window.super_puper_ajax = function (map, func) {
    $.ajax({
        type: "POST",
        url: "",
        dataType: "json",
        data: map,
        success: function (response) {
            func(response);
            if (response["redirect"]) {
                location.href = response["redirect"];
            }
        }
    });
}

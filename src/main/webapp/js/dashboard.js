$("#dash").load(function () {
    $.ajax({
        url: "Dashboard",
        type: 'POST',
        data: {
            accion: "VIEW"
        },
        success: function (result) {
            var d = result;

            $("#ing").val(parseFloat(d).toFixed(2));
            $("#gas").val(parseFloat(d).toFixed(2));
            $("#cos").val(parseFloat(d).toFixed(2));
        }
    });
});
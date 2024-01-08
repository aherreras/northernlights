function message(titulo, msg) {
    $("#message").html(msg);

    $("#message_dlg").dialog({
        title: titulo,
        modal: true,
        width: 400,
        buttons: {
            "Cerrar": function () {
                $(this).dialog("close");
            }
        }
    });
}

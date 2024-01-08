$(function() {
    $("table.parainfo thead").addClass("ui-widget ui-state-default");
    $("table.parainfo tfoot").addClass("ui-widget ui-state-default");
    $("table.parainfo caption").addClass("ui-widget-header");
    $("table.parainfo caption").addClass("ui-corner-top");

    $("table.parainfo .crud .ins span").addClass("ui-icon ui-icon-plusthick");
    $("table.parainfo .crud .upd span").addClass("ui-icon ui-icon-check");
    $("table.parainfo .crud .del span").addClass("ui-icon ui-icon-trash");

    $("table.parainfo .crud").mouseover(function() {
        $(this).addClass("ui-state-hover");
    }).mouseout(function() {
        $(this).removeClass("ui-state-hover");
    });
});


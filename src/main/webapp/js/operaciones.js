$(function () {
    actServicio();
    actTipOpe();

    $("#idprecio").keyup(function (event) {
        var precio = $(this).val();

        if (precio.length > 0) {
            calculaSubTotal();
        }
    });

    $("#idprecio").focusout(function (e) {
        var precio = $(this).val();
        if (!precio) {
            $(this).val("0.00");
        } else {
            $(this).val(parseFloat($("#idprecio").val()).toFixed(2));
        }
        calculaSubTotal();
    });

    $("#iddescuento").focusout(function (e) {
        var desc = $(this).val();
        if (!desc) {
            $(this).val("0.00");
        } else {
            $(this).val(parseFloat($("#iddescuento").val()).toFixed(2));
        }
    });

    $("#idcantidad").keypress(function (e) {
        // sino digita digito muestra mensaje
        if (e.which !== 8 && e.which !== 0 && (e.which < 48 || e.which > 57)) {
            $("#isInt").html("(entero!)").show().fadeOut("slow");
            return false;
        }
    });

    $("#idcantidad").focusout(function (e) {
        var cantidad = $(this).val();
        if (!cantidad) {
            $(this).val("1");
        }
        calculaSubTotal();
    });
})

function obtPrecio() {
    $.ajax({
        url: "Operaciones",
        type: 'POST',
        data: {
            accion: "GET_PRECIO",
            servicio: $("#idservicio option:selected").val()
        },
        success: function (result) {
            var d = result;

            $("#idprecio").val(parseFloat(d).toFixed(2));
            calculaSubTotal();
        }
    });
}

function actServicio() {
    $.ajax({
        url: "Operaciones",
        type: 'POST',
        data: {
            accion: "GET_SRV",
            categoria: $("#idcategoria option:selected").val()
        },
        success: function (result) {
            var myArray = [];
            var datArray = [];
            var opt = "";
            myArray = result.split("|");

            for (var i = 0; i < myArray.length; i++) {
                datArray = myArray[i].split(",");
                opt += "<option value='" + datArray[0] + "'>" + datArray[1] + "</option>";
            }

            $("#idservicio").html(opt);

            obtPrecio();
        }
    });
}

function actTipOpe() {
    var tope = $("#idtipooper option:selected").val();
    var vta = document.getElementById('datVenta');
    var hid = document.getElementById('datHidden');

    if (tope === '1') {
        vta.removeAttribute("hidden");
        hid.setAttribute("hidden", "hidden");
        $("#srvRadio").prop("checked", true);
    } else if (tope === '2' || tope === '3' || tope === '4' || tope === '5' || tope === '6') {
        vta.setAttribute("hidden", "hidden");
        hid.setAttribute("hidden", "hidden");
    } else if (tope === '7') {
        vta.setAttribute("hidden", "hidden");
        hid.removeAttribute("hidden");
    } else if (tope === '8' || tope === '9') {
        vta.setAttribute("hidden", "hidden");
        hid.setAttribute("hidden", "hidden");
    }

}

function calculaSubTotal() {
    var precio = parseFloat($("#idprecio").val()).toFixed(2);
    var cantidad = $("#idcantidad").val();
    var subtotal = parseFloat(precio * cantidad).toFixed(2);

    $("#idsubtotal").val(parseFloat(subtotal).toFixed(2));
}

function lstSrv() {
    $.ajax({
        url: "Operaciones",
        type: 'POST',
        data: {
            accion: "GET_SRV",
            servicio: $("#idcategoria option:selected").val()
        },
        success: function (result) {
            var d = result;

            $("#idservicio").val(parseFloat(d).toFixed(2));
        }
    });
}

function operacionIns() {
    var ide = [];
    var ids = [];
    var srv = [];
    var prc = [];
    var cnt = [];
    var st = [];
    var des = [];
    var tt = [];

    $("#tbventa2 #ide").each(function () {
        ide.push($(this).text());
    });

    $("#tbventa2 #ids").each(function () {
        ids.push($(this).text());
    });

    $("#tbventa2 #srv").each(function () {
        srv.push($(this).text());
    });

    $("#tbventa2 #prc").each(function () {
        prc.push($(this).text());
    });

    $("#tbventa2 #cnt").each(function () {
        cnt.push($(this).text());
    });

    $("#tbventa2 #st").each(function () {
        st.push($(this).text());
    });

    $("#tbventa2 #des").each(function () {
        des.push($(this).text());
    });

    $("#tbventa2 #tt").each(function () {
        tt.push($(this).text());
    });

    $.ajax({
        url: "Operaciones",
        type: 'POST',
        data: {
            accion: "ADD",
            tipooper: $("#idtipooper option:selected").val(),
            metpago: $("#idmetpago option:selected").val(),
            cliente: $("#idcliente option:selected").val(),
            proveedor: $("#idproveedor option:selected").val(),
            ide: ide.toString(),
            ids: ids.toString(),
            srv: srv.toString(),
            prc: prc.toString(),
            cnt: cnt.toString(),
            st: st.toString(),
            des: des.toString(),
            tt: tt.toString(),
//            servicio: $("#idservicio option:selected").val(),
//            producto: $("#idproducto option:selected").val(),
//            descripcion: $("#idservicio option:selected").text(),
//            precio: $("#idprecio").val(),
//            cantidad: $("#idcantidad").val(),
//            subtotal: $("#idsubtotal").val(),
//            descuento: $("#iddescuento").val(),
//            total: $("#idtotal").val(),
            caja: $("#idcaja option:selected").val(),
            usuario: $("#idusuario option:selected").val(),
            montoope: $("#idmontoope").val(),
            pagado: $("#idpagado").val(),
            vuelto: $("#idvuelto").val(),
            cobrado: $("#idcobrado").val(),
            saldo: $("#idsaldo").val(),
            fecha: $("#iddate").val()
        },
        success: function (result) {
            $('#fin_operacion').modal('toggle');

            $("#message-header").empty();
            $("#message-header").append("<h5 class='modal-title' id='message-center-label'>Operación Exitosa</h5>" +
                    "<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>");
            $("#message-body").empty();
            $("#message-body").append("Operación registrada correctamente.");
            $("#message-footer").empty();
            $("#message-footer").append("<button type='button' class='btn btn-primary' data-bs-dismiss='modal'>Continuar</button>");
            $('#modal-message').modal('toggle');
            $("#tbventa2 tbody").empty();
            $("#ttotal").val("0.00");
        }
    });
}

function operacionAdd() {
    var id = $("#idservicio option:selected").val();
    var servicio = $.trim($("#idservicio option:selected").text());
    var precio = parseFloat($("#idprecio").val()).toFixed(2);
    var cantidad = $("#idcantidad").val();
//    var subtotal = parseFloat(precio * cantidad).toFixed(2);
    var subtotal = parseFloat($("#idsubtotal").val()).toFixed(2);
    var descuento = parseFloat($("#iddescuento").val()).toFixed(2);
    var total = parseFloat(subtotal - descuento).toFixed(2);

    $("#tbventa tbody").append("<tr>" +
            "<td style='text-align: left'>" + "<input type='text' name='est' style='width:60px' class='transforma' value='" + precio + "' readonly='readonly'/>" + "</td>" +
            "<td hidden='true'>" + "<input type='text' name='ids' style='width:40px' class='transforma' value='" + id + "' readonly='readonly'/>" + "</td>" +
            "<td style='text-align: left'>" + "<div contenteditable>" + "<input type='text' name='srv' style='width:350px' class='transforma' value='" + servicio + "'/>" + "</td>" +
            "<td style='text-align: left'>" + "<input type='text' name='prc' style='width:60px' class='transforma' value='" + precio + "' readonly='readonly'/>" + "</td>" +
            "<td style='text-align: left'>" + "<input type='text' name='cnt' style='width:40px' class='transforma' value='" + cantidad + "' readonly='readonly'/>" + "</td>" +
            "<td style='text-align: left'>" + "<input type='text' name='st' style='width:70px' class='transforma' value='" + subtotal + "' readonly='readonly'/>" + "</td>" +
            "<td style='text-align: left'>" + "<input type='text' name='des' style='width:80px' class='transforma' value='" + descuento + "' readonly='readonly'/>" + "</td>" +
            "<td style='text-align: left'>" + "<input type='text' name='tt' style='width:80px' class='transforma' value='" + total + "' readonly='readonly'/>" + "</td>" +
            "<th style='text-align: center'>" + "<input type='checkbox' name='chk_del'/>" + "</th>" +
            "</tr>");

    $(".transforma").addClass("ui-widget ui-widget-content ui-corner-all");

    var ttotal = 0;
    $("input[name='tt']").each(function () {
        ttotal += eval($(this).val());
    });
    $("#ttotal").val(parseFloat(ttotal).toFixed(2));
    $("#idmontoope").val(parseFloat(ttotal).toFixed(2));

    var tope = $("#idtipooper option:selected").val();

    if (tope === "2") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    } else if (tope === "4" || tope === "7") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val("0.00");
    } else {
        $("#idcobrado").val(parseFloat(ttotal).toFixed(2));
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    }
}

function operacionAdd2() {
    var ide = $("#idestilista option:selected").val();
    var estilista = $.trim($("#idestilista option:selected").text());
    var id = $("#idservicio option:selected").val();
    var servicio = $.trim($("#idservicio option:selected").text());
    var precio = parseFloat($("#idprecio").val()).toFixed(2);
    var cantidad = $("#idcantidad").val();
    var subtotal = parseFloat($("#idsubtotal").val()).toFixed(2);
    var descuento = parseFloat($("#iddescuento").val()).toFixed(2);
    var total = parseFloat(subtotal - descuento).toFixed(2);

    $("#tbventa2 tbody").append("<tr>" +
            "<td hidden='true' id='ide'>" + ide + "</td>" +
            "<td id='est' contenteditable='true'>" + estilista + "</td>" +
            "<td hidden='true' id='ids'>" + id + "</td>" +
            "<td id='srv' contenteditable='true'>" + servicio + "</td>" +
            "<td id='prc'>" + precio + "</td>" +
            "<td id='cnt'>" + cantidad + "</td>" +
            "<td id='st'>" + subtotal + "</td>" +
            "<td id='des'>" + descuento + "</td>" +
            "<td id='tt'>" + total + "</td>" +
            "<th style='text-align: center'>" + "<input type='checkbox' name='chk_del'/>" + "</th>" +
            "</tr>");

    $(".transforma").addClass("ui-widget ui-widget-content ui-corner-all");

    var ttotal = 0;

    $('#tbventa2 #tt').each(function () {
        var tt = parseFloat($(this).text()).toFixed(2);
        ttotal += eval(tt);
    });

    $("#ttotal").val(parseFloat(ttotal).toFixed(2));
    $("#idmontoope").val(parseFloat(ttotal).toFixed(2));

    var tope = $("#idtipooper option:selected").val();

    if (tope === "2" || tope === "7") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    } else if (tope === "4") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val("0.00");
    } else {
        $("#idcobrado").val(parseFloat(ttotal).toFixed(2));
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    }
}

function operacionAdd3() {
    var ide = $("#idestilista2 option:selected").val();
    var estilista = $.trim($("#idestilista2 option:selected").text());
    var monto = parseFloat($("#idmonto").val()).toFixed(2);
    var detalle = $("#iddetalle").val();

    $("#tbventa2 tbody").append("<tr>" +
            "<td hidden='true' id='ide'>" + ide + "</td>" +
            "<td id='est' contenteditable='true'>" + estilista + "</td>" +
            "<td hidden='true' id='ids'>" + 99 + "</td>" +
            "<td id='srv' contenteditable='true'>" + detalle + "</td>" +
            "<td id='prc'>" + monto + "</td>" +
            "<td id='cnt'>" + 1 + "</td>" +
            "<td id='st'>" + monto + "</td>" +
            "<td id='des'>" + "0.00" + "</td>" +
            "<td id='tt'>" + monto + "</td>" +
            "<th style='text-align: center'>" + "<input type='checkbox' name='chk_del'/>" + "</th>" +
            "</tr>");

    $(".transforma").addClass("ui-widget ui-widget-content ui-corner-all");

    var ttotal = 0;

    $('#tbventa2 #tt').each(function () {
        var tt = parseFloat($(this).text()).toFixed(2);
        ttotal += eval(tt);
    });

    $("#ttotal").val(parseFloat(ttotal).toFixed(2));
    $("#idmontoope").val(parseFloat(ttotal).toFixed(2));

    var tope = $("#idtipooper option:selected").val();

    if (tope === "2" || tope === "7") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    } else if (tope === "4") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val("0.00");
    } else {
        $("#idcobrado").val(parseFloat(ttotal).toFixed(2));
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    }
}

function operacionDel() {
    var ids = [];

    $("input[name='chk_del']:checked").each(function () {
        ids.push($(this).val());
    });

    if (ids.length === 0) {
        mensaje("Advertencia", "Seleccione fila(s) a Retirar");
    } else {
        $(function () {
            $("#message-header").empty();
            $("#message-header").append("<h5 class='modal-title' id='message-center-label'>Eliminar registro</h5>" +
                    "<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>");
            $("#message-body").empty();
            $("#message-body").append("¿Desea eliminar registro(s)?");
            $("#message-footer").empty();
            $("#message-footer").append("<button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>No</button>" +
                    "<button type='button' class='btn btn-primary' onclick='operacionDel2();'>Si</button>");
            $('#modal-message').modal('toggle');
        });
    }
}

function operacionDel2() {
    $($("input[name='chk_del']:checked").parent("th")).parent("tr").remove();

    var ttotal = 0;

    $('#tbventa2 #tt').each(function () {
        var tt = parseFloat($(this).text()).toFixed(2);
        ttotal += eval(tt);
    });

    $("#ttotal").val(parseFloat(ttotal).toFixed(2));
    $("#idmontoope").val(parseFloat(ttotal).toFixed(2));

    var tope = $("#idtipooper option:selected").val();

    if (tope === "2") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    } else if (tope === "4" || tope === "7") {
        $("#idcobrado").val("0.00");
        $("#idpagado").val("0.00");
    } else {
        $("#idcobrado").val(parseFloat(ttotal).toFixed(2));
        $("#idpagado").val(parseFloat(ttotal).toFixed(2));
    }

    $('#modal-message').modal('toggle');
}

function add2() {
    $("#tbl_detalle").attr("data-bs-toggle", "collapse");
}

function obtDetalle(ele) {
    var row = $(ele).closest('tr');
    var id = row.find('td:first').text();
    var tid = row.find('td:nth-child(2)').text();

    $.ajax({
        url: "Operaciones",
        type: 'GET',
        data: {
            accion: "DET",
            id: id.toString(),
            tid: tid.toString()
        },
        success: function (result) {
            var myArray = result.split(";");
            $("#tbOperacion").empty();
            $("#tbOperacion").append(myArray[0]);

            $("#tbDetalle tbody").empty();
            $("#tbDetalle tbody").append(myArray[1]);

            $("#ttotal").val(parseFloat(myArray[2]).toFixed(2));
        }
    });
}

function actOperacion(ele) {
    var row = $(ele).closest('tr');
    var id = row.find('td:first').text();
    var tid = row.find('td:nth-child(2)').text();

    $.ajax({
        url: "Operaciones",
        type: 'GET',
        data: {
            accion: "DET",
            id: id.toString(),
            tid: tid.toString()
        },
        success: function (result) {
            var myArray = result.split(";");
            $("#tbOperacion").empty();
            $("#tbOperacion").append(myArray[0]);

            $("#tbDetalle tbody").empty();
            $("#tbDetalle tbody").append(myArray[1]);

            $("#ttotal").val(parseFloat(myArray[2]).toFixed(2));
        }
    });
}
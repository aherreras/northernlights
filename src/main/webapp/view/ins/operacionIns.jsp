<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Operación</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <link href="jq/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="parainfo/message.css" rel="stylesheet" type="text/css"/>
        <style>
            .brand-gradient {
                background: #f2d43a;
                /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #f2d43a, #ffffff);
                /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #f2d43a, #ffffff);
                /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                -webkit-background-clip: text;
                background-clip: text;
                color: transparent;
            }

            .vr {
                color: white;
            }

            .card-custom {
                background-color: #FFAE00;
            }

            .input-group-text {
                width: 160px;
                align-content: flex-end;
            }

            .body-bg {
                background-color: #BCBABC;
            }
        </style>
    </head>
    <body class="bg-light">
        <%@include file="../../WEB-INF/jspf/menuglobal.jspf" %>

        <!-- Operaciones data -->
        <div class="container">
            <div class="row justify-content-center">
                <!-- Menù lateral -->
                <div class="col-md-2">
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Operaciones</div>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST_ADD" class="list-group-item list-group-item-action">Agregar Operación</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST" class="list-group-item list-group-item-action">Ver Operaciones</a>
                    </div>
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Enlaces</div>
                        <a href="#" class="list-group-item list-group-item-action">Clientes</a>
                        <a href="#" class="list-group-item list-group-item-action">Proveedores</a>
                        <a href="#" class="list-group-item list-group-item-action">Catálogo</a>
                    </div>
                </div>

                <!-- Menù lateral -->
                <div class="col-md-4">
                    <div class="card shadow-sm border-0 mb-3">
                        <div class="card-header text-bg-dark text-center">Datos Operación</div>
                        <form>
                            <div class="container">
                                <div class="row mt-3">
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idtipooper" onchange="actTipOpe()">
                                                <c:forEach var="p" items="${list2}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idtipooper">Seleccionar un tipo de operación</label>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <div class="form-check">
                                                        <input type="radio" class="form-check-input" value="Servicio" name="venta" id="srvRadio">
                                                        <label for="srvRadio" class="form-check-label">Servicio</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-check">
                                                    <input type="radio" class="form-check-input" value="Producto" name="venta" id="prdRadio">
                                                    <label for="prdRadio" class="form-check-label">Producto</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Datos Venta (default) -->
                                    <div class="col-md-12">
                                        <div class="row" id="datVenta">
                                            <div class="col-md-12">
                                                <div class="mb-3 form-floating">
                                                    <select class="form-select form-select-sm" id="idestilista">
                                                        <c:forEach var="p" items="${lstUser}">
                                                            <option value="${p[0]}">${p[1]}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <label for="idestilista">Seleccione un(a) Estilista</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="mb-3 form-floating">
                                                    <select class="form-select form-select-sm" id="idcategoria" onchange="actServicio()">
                                                        <c:forEach var="p" items="${listCat}">
                                                            <option value="${p[0]}">${p[1]}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <label for="idcategoria">Seleccione una Categoría</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="mb-3 form-floating">
                                                    <select class="form-select form-select-sm" id="idservicio" onchange="obtPrecio();">
                                                    </select>
                                                    <label for="idservicio">Seleccione un Servicio</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="idprecio" value="0.00" required>
                                                    <label for="idprecio">Precio</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="idcantidad" value="1" required>
                                                    <label for="idcantidad">Cantidad</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="idsubtotal" value="0.00" readonly disabled required>
                                                    <label for="idsubtotal">Sub Total</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="iddescuento" value="0.00">
                                                    <label for="iddescuento">Descuento</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="d-grid mb-3">
                                                    <button
                                                        onclick="operacionAdd2();"
                                                        type="button"
                                                        class="btn btn-sm btn-success">
                                                        Agregar Servicio
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Datos Venta (default) -->

                                    <!-- Hidden Data -->
                                    <div class="col-md-12">
                                        <div class="row" id="datHidden">
                                            <div class="col-md-12">
                                                <div class="mb-3 form-floating">
                                                    <select class="form-select form-select-sm" id="idestilista2">
                                                        <c:forEach var="p" items="${lstUser}">
                                                            <option value="${p[0]}">${p[1]}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <label for="idestilista2">Seleccione un(a) Usuario(a)</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="idmonto" value="0.00" required>
                                                    <label for="idmonto">Monto</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="mb-3 form-floating">
                                                    <input type="text" class="form-control" id="iddetalle" value="" required>
                                                    <label for="iddetalle">Detalle</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="d-grid mb-3">
                                                    <button
                                                        onclick="operacionAdd3();"
                                                        type="button"
                                                        class="btn btn-sm btn-warning">
                                                        Agregar Gasto
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Hidden Data -->

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Menù lateral -->

                <div class="col-md-6">
                    <div class="card shadow-sm border-0 mb-3">
                        <div class="card-header text-bg-dark text-center">Detalle Operación</div>
                        <form>
                            <div class="container">
                                <div class="row text-center mt-3">
                                    <div class="gx-3">
                                        <table id="tbventa2" class="table table-striped table-bordered table-sm align-middle">
                                            <thead>
                                                <tr>
                                                    <th hidden="true">IDE</th>
                                                    <th>Estilista</th>
                                                    <th hidden="true">ID</th>
                                                    <th>Servicio</th>
                                                    <th>Precio</th>
                                                    <th>Cant.</th>
                                                    <th>Subtotal</th>
                                                    <th>Desc.</th>
                                                    <th>Total</th>
                                                    <th>
                                                        <button
                                                            type="button"
                                                            class="btn btn-primary"
                                                            data-bs-toggle="modal"
                                                            onclick="operacionDel();"
                                                            data-bs-target="#modal-message">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentcolor" class="bi bi-trash" viewBox="0 0 16 16">
                                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                            </svg>
                                                        </button>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="table-group-divider"></tbody>
                                            <tfoot class="table-group-divider">
                                                <tr>
                                                    <td colspan="6" style="text-align: right">
                                                        Total S/.
                                                    </td>
                                                    <td>
                                                        <input type="text" id="ttotal" 
                                                               readonly="readonly" value="0"
                                                               style="width: 80px; text-align: center"/>
                                                    </td>
                                                    <td>&nbsp;</td>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="d-grid mb-3">
                                            <button
                                                type="button"
                                                class="btn btn-sm btn-success"
                                                data-bs-toggle="modal"
                                                onclick="add2();"
                                                data-bs-target="#fin_operacion">
                                                Continuar
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Operaciones data -->

        <!-- Modelo Tabla Detalle -->
        <div class="modal fade" id="tbl_detalle" data-bs-backdrop="static" tabindex="-1" aria-hidden="true"
             style="backdrop-filter: blur(5px);">
            <div class="modal-dialog modal-dialog-centered modal-lg">
                <div class="modal-content">
                    <div class="modal-header text-bg-dark">
                        <h5 class="modal-title">Detalle de Operación</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="row">
                                <table id="tbventa" class="table table-bordered table-sm align-middle">
                                    <thead>
                                        <tr>
                                            <th hidden="true">ID</th>
                                            <th style="width:240px" >Servicio</th>
                                            <th style="width:80px" >Precio</th>
                                            <th style="width:50px" >Cant.</th>
                                            <th style="width:100px" >Subtotal</th>
                                            <th style="width:60px">Desc.</th>
                                            <th style="width:80px">Total</th>
                                            <th>
                                                <button
                                                    type="button"
                                                    class="btn btn-primary"
                                                    data-bs-toggle="modal"
                                                    onclick="operacionDel();"
                                                    data-bs-target="#modal-message">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                    </svg>
                                                </button>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody class="table-group-divider"></tbody>
                                    <tfoot class="table-group-divider">
                                        <tr>
                                            <td colspan="5" style="text-align: right">
                                                Total S/.
                                            </td>
                                            <td style="text-align: left">
                                                <input type="text" id="ttotal" 
                                                       readonly="readonly" value="0"
                                                       style="width: 80px"/>
                                            </td>
                                            <td>&nbsp;</td>
                                        </tr>
                                    </tfoot>
                                </table>
                                <div class="col-md-2">
                                    <div class="d-grid">
                                        <button
                                            type="button"
                                            class="btn btn-sm btn-secondary"
                                            data-bs-toggle="modal"
                                            data-bs-target="#retornar">
                                            Retornar
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="d-grid">
                                        <button
                                            type="button"
                                            class="btn btn-sm btn-success"
                                            data-bs-toggle="modal"
                                            onclick="add2();"
                                            data-bs-target="#fin_operacion">
                                            Siguiente
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="d-grid">
                                        <button
                                            type="button"
                                            class="btn btn-sm btn-warning"
                                            data-bs-dismiss="modal"
                                            aria-label="Close">
                                            Cerrar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modelo Tabla Detalle -->

        <!-- Modelo Finalizar Operación -->
        <div class="modal fade" id="fin_operacion" data-bs-backdrop="static" tabindex="-1" aria-hidden="true"
             style="backdrop-filter: blur(5px);">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header text-bg-dark">
                        <h5 class="modal-title">Registrar de Operación</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idmetpago">
                                                <c:forEach var="p" items="${list4}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idmetpago">Seleccione un Método de Pago</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idcliente">
                                                <c:forEach var="p" items="${list5}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idcliente">Seleccione un Cliente</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idproveedor">
                                                <c:forEach var="p" items="${list6}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idproveedor">Seleccione un Proveedor</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idusuario">
                                                <c:forEach var="p" items="${lstUser}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idusuario">Seleccione un Usuario</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <select class="form-select form-select-sm" id="idcaja">
                                                <c:forEach var="p" items="${lstCaja}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                            <label for="idcaja">Seleccione un Caja</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <input type="text" class="form-control form-control-sm" id="idmontoope" value="0.00" required>
                                            <label for="idmontoope">Monto Operación</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <input type="text" class="form-control form-control-sm" id="idpagado" value="0.00" required>
                                            <label for="idpagado">Monto Pagado</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <input type="text" class="form-control form-control-sm" id="idvuelto" value="0.00" required>
                                            <label for="idvuelto">Vuelto</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <input type="text" class="form-control form-control-sm" id="idcobrado" value="0.00" required>
                                            <label for="idcobrado">Monto Cobrado</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3 form-floating">
                                            <input type="text" class="form-control form-control-sm" id="idsaldo" value="0.00" required>
                                            <label for="idsaldo">Saldo</label>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3 form-floating">
                                            <input type="date" class="form-control form-control-sm" id="iddate" required>
                                            <label for="iddate">Fecha de Operación</label>
                                        </div>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="d-grid">
                                            <button
                                                type="button"
                                                class="btn btn-sm btn-success"
                                                onclick="operacionIns();">
                                                Finalizar
                                            </button>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="d-grid">
                                            <button
                                                type="button"
                                                class="btn btn-sm btn-warning"
                                                data-bs-dismiss="modal"
                                                aria-label="Close">
                                                Cerrar
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modelo Agregar Operación -->

        <!-- Modelo Mensaje -->
        <div
            class="modal fade"
            id="modal-message"
            tabindex="-1"
            aria-labelledby="modal-message-label"
            aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" id="message-header"></div>
                    <div class="modal-body" id="message-body"></div>
                    <div class="modal-footer" id="message-footer"></div>
                </div>
            </div>
        </div>
        <!-- Modelo Mensaje -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/operaciones.js" type="text/javascript"></script>
        <script src="parainfo/message.js" type="text/javascript"></script>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de Servicios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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
        </style>
    </head>
    <body class="bg-light">
        <%@include file="../../WEB-INF/jspf/menuglobal.jspf" %>
        <!-- Operaciones data -->
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-2">
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Catálogo</div>
                        <!--                        <a 
                                                    href="#" 
                                                    class="list-group-item list-group-item-action" 
                                                    data-bs-toggle="modal" 
                                                    data-bs-target="#add_operacion">
                                                    Agregar Operación
                                                </a>-->
                        <!--<a href="view/operacionIns.jsp" class="list-group-item list-group-item-action">Agregar Operación</a>-->
                        <a href="Operaciones?accion=LST_ADD" class="list-group-item list-group-item-action">Agregar Servicio</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LSTCAT" class="list-group-item list-group-item-action">Ver Catálogo</a>
                    </div>
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Enlaces</div>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST" class="list-group-item list-group-item-action">Operaciones</a>
                        <a href="#" class="list-group-item list-group-item-action">Clientes</a>
                        <a href="#" class="list-group-item list-group-item-action">Proveedores</a>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="card shadow-sm border-0 mb-3">
                        <div class="card-header text-bg-dark text-center">Catálogo de Servicios</div>
                        <form method="POST">
                            <table class="table table-sm small table-bordered align-middle mb-0">
                                <tr class="table-secondary">
                                    <th hidden="true">serv_id</th>
                                    <th>Servicio</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th hidden="true">cate_id</th>
                                    <th>Categoría</th>
                                    <th>Detalle</th>
                                    <th>Editar</th>
                                    <th>Borrar</th>
                                </tr>
                                <c:forEach var="s" items="${listSrv}">
                                    <tr>
                                        <td hidden="true">${s[0]}</td>
                                        <td>${s[1]}</td>
                                        <td>${s[2]}</td>
                                        <td>${s[3]}</td>
                                        <td hidden="true">${s[4]}</td>
                                        <td>${s[5]}</td>
                                        <td>
                                            <div class="d-grid">
                                                <a 
                                                    href="#" 
                                                    class="btn btn-sm btn-primary" 
                                                    data-bs-toggle="modal" 
                                                    data-bs-target="#detalle_operacion">
                                                    Detalle
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="d-grid">
                                                <a 
                                                    href="#" 
                                                    class="btn btn-sm btn-warning" 
                                                    data-bs-toggle="modal" 
                                                    data-bs-target="#editar_operacion">
                                                    Editar
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="d-grid">
                                                <a 
                                                    href="#" 
                                                    class="btn btn-sm btn-danger" 
                                                    data-bs-toggle="modal" 
                                                    data-bs-target="#borrar_operacion">
                                                    Borrar
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Operaciones data -->

        <!-- Modelo Agregar Operación -->
        <div 
            class="modal fade"
            id="add_operacion"
            data-bs-backdrop="static"
            tabindex="-1"
            aria-hidden="true"
            style="backdrop-filter: blur(5px);">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header text-bg-dark">
                        <h5 class="modal-title">Agregar Detalle de Operación</h5>
                        <button
                            type="button"
                            class="btn-close btn-close-white"
                            data-bs-dismiss="modal"
                            aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="container">
                                <div class="row gx-3">
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idtipooper" style="width: 300px">
                                                <option value="0">Seleccionar un tipo de operación ...</option>
                                                <c:forEach var="p" items="${list3}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idmetpago" style="width: 300px">
                                                <option value="0">Seleccionar un medio de pago ...</option>
                                                <c:forEach var="p" items="${list4}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idcliente" style="width: 300px">
                                                <option value="0">Seleccionar un cliente ...</option>
                                                <c:forEach var="p" items="${list5}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idproveedor" style="width: 300px">
                                                <option value="0">Seleccionar un proveedor ...</option>
                                                <c:forEach var="p" items="${list6}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idservicio" onchange="getPrecio();" style="width: 300px">
                                                <option value="0">Seleccionar un servicio ...</option>
                                                <c:forEach var="p" items="${list1}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <select class="form-select form-select-sm" id="idproducto" style="width: 300px">
                                                <option value="0">Seleccionar un producto ...</option>
                                                <c:forEach var="p" items="${list7}">
                                                    <option value="${p[0]}">${p[1]}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idprecio" placeholder="0.00" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idcantidad" placeholder="1" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idsubtotal" placeholder="0.00" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="iddescuento" placeholder="0.00">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idtotal" placeholder="0.00">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idcaja" placeholder="Caja" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idmontoope" placeholder="Monto Operacion" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idpagado" placeholder="Monto Pagado" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idvuelto" placeholder="Vuelto" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idcobrado" placeholder="Monto Cobrado" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <input type="text" class="form-control form-control-sm" id="idsaldo" placeholder="Saldo" required>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="mb-3">
                                            <input type="date" class="form-control form-control-sm" id="iddate" required>
                                        </div>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="d-grid">
                                            <button
                                                onclick="operacionAcepta();"
                                                type="button"
                                                class="btn btn-sm btn-success">
                                                Agregar Operación
                                            </button>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="d-grid">
                                            <button
                                                type="submit"
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

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/operaciones.js" type="text/javascript"></script>
    </body>
</html>

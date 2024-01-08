<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operaciones</title>
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
        <%@include file="../WEB-INF/jspf/menuglobal.jspf" %>

        <!-- Operaciones data -->
        <div class="container">
            <div class="row justify-content-center">

                <!-- Operaciones Menú Lateral -->
                <div class="col-md-2">
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Operaciones</div>
                        <a href="Operaciones?accion=LST_ADD" class="list-group-item list-group-item-action">Agregar Operación</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST" class="list-group-item list-group-item-action">Ver Operaciones</a>
                    </div>
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Enlaces</div>
                        <a href="#" class="list-group-item list-group-item-action">Clientes</a>
                        <a href="#" class="list-group-item list-group-item-action">Proveedores</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LSTCAT" class="list-group-item list-group-item-action">Catálogo</a>
                    </div>
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Caja</div>
                        <a href="#" class="list-group-item list-group-item-action">Cerrar Caja</a>
                        <a href="#" class="list-group-item list-group-item-action">Abrir Caja</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LSTCAT" class="list-group-item list-group-item-action">Ver Caja</a>
                    </div>
                </div>
                <!-- Operaciones Menú Lateral -->
                
                <!-- Operaciones Listado -->
                <div class="col-md-10">
                    <div class="card shadow-sm border-0 mb-3">
                        <div class="card-header text-bg-dark text-center">Listado de Operaciones</div>
                        <form method="POST">
                            <table class="table table-sm small table-bordered align-middle mb-0" id="tbListado">
                                <tr class="table-secondary">
                                    <th>ID</th>
                                    <th hidden="true">tope_id</th>
                                    <th>Tipo Oper.</th>
                                    <th hidden="true">mpag_id</th>
                                    <th>Medio de Pag.</th>
                                    <th hidden="true">clie_id</th>
                                    <th>Cliente</th>
                                    <th hidden="true">prov_id</th>
                                    <th>Proveedor</th>
                                    <th hidden="true">Fecha y Hora Sist.</th>
                                    <th>Monto Oper.</th>
                                    <th hidden="true">Monto Pag.</th>
                                    <th hidden="true">Vuelto</th>
                                    <th hidden="true">Monto Cobr.</th>
                                    <th hidden="true">Saldo</th>
                                    <th>Fecha Oper.</th>
                                    <th>Detalle</th>
                                    <th>Editar</th>
                                    <th>Borrar</th>
                                </tr>
                                <c:forEach var="p" items="${list1}">
                                    <tr>
                                        <td>${p[0]}</td>
                                        <td hidden="true">${p[1]}</td>
                                        <td>${p[2]}</td>
                                        <td hidden="true">${p[3]}</td>
                                        <td>${p[4]}</td>
                                        <td hidden="true">${p[5]}</td>
                                        <td>${p[6]}</td>
                                        <td hidden="true">${p[7]}</td>
                                        <td>${p[8]}</td>
                                        <td hidden="true">${p[9]}</td>
                                        <td>${p[10]}</td>
                                        <td hidden="true">${p[11]}</td>
                                        <td hidden="true">${p[12]}</td>
                                        <td hidden="true">${p[13]}</td>
                                        <td hidden="true">${p[14]}</td>
                                        <td>${p[15]}</td>
                                        <td>
                                            <div class="d-grid">
                                                <a 
                                                    href="#" 
                                                    class="btn btn-sm btn-primary" 
                                                    data-bs-toggle="modal" 
                                                    onclick="obtDetalle(this);" 
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
                                                    onclick="actOperacion(this);">
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
                <!-- Operaciones Listado -->
                
            </div>
        </div>
        <!-- Operaciones data -->

        <!-- Modelo Detalle -->
        <div class="modal fade" id="detalle_operacion" data-bs-backdrop="static" tabindex="-1" aria-hidden="true"
             style="backdrop-filter: blur(5px);">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header text-bg-dark">
                        <h5 class="modal-title">Detalle de Operación</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tbOperacion" class="table table-bordered small mb-8">
                        </table>

                        <table id="tbDetalle" class="table table-bordered table-sm align-middle">
                            <thead>
                                <tr>
                                    <th hidden="true">ID</th>
                                    <th>Servicio</th>
                                    <th>Precio</th>
                                    <th>Cant.</th>
                                    <th>Subtotal</th>
                                    <th>Desc.</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                            </tbody>
                            <tfoot class="table-group-divider">
                                <tr>
                                    <td colspan="5" style="text-align: right">
                                        Total S/.
                                    </td>
                                    <td style="text-align: left">
                                        <input type="text" id="ttotal" readonly="readonly" value="0.00"
                                               style="width: 80px" />
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modelo Tabla Detalle -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/operaciones.js" type="text/javascript"></script>
    </body>
</html>

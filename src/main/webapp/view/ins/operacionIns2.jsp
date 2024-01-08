<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Operación</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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

            table.table th a {
                cursor: pointer;
                margin: 0 5px;
                min-width: 24px;
            }

            table.table th a.delete {
                color: #E34724;
            }

            table.table th i {
                font-size: 19px;
            }

            .input-group-text {
                width: 160px;
                align-content: flex-end;
            }
        </style>
    </head>
    <body class="bg-light">
        <%@include file="../../WEB-INF/jspf/menuglobal.jspf" %>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-2">
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Operaciones</div>
                        <a href="#" class="list-group-item list-group-item-action">Agregar Operación</a>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST" class="list-group-item list-group-item-action">Ver Operaciones</a>
                    </div>
                    <div class="list-group shadow-sm small mb-3">
                        <div class="list-group-item active">Enlaces</div>
                        <a href="#" class="list-group-item list-group-item-action">Clientes</a>
                        <a href="#" class="list-group-item list-group-item-action">Proveedores</a>
                        <a href="#" class="list-group-item list-group-item-action">Catálogo</a>
                    </div>
                </div>
                <div class="col-md-10">
                    <form method="POST">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="mb-3">
                                    <div class="input-group">
                                        <label for="idtipooper" class="input-group-text" >Tipo de Operación</label>
                                        <select class="form-control form-select form-select-sm" id="idtipooper" style="width: 300px">
                                            <option value="0" selected>Seleccionar un tipo de operación ...</option>
                                            <c:forEach var="p" items="${list2}">
                                                <option value="${p[0]}">${p[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="input-group">
                                        <label for="idservicio" class="input-group-text">Servicios</label>
                                        <select class="form-control form-select form-select-sm" id="idservicio" onchange="obtPrecio();" style="width: 300px">
                                            <option value="0" selected>Seleccionar un servicio ...</option>
                                            <c:forEach var="p" items="${list3}">
                                                <option value="${p[0]}">${p[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%-- mensajes lado del cliente --%>
        <div style="display: none">
            <div id="dlg_message"><p id="message"></p></div>
        </div>
        
    </body>
</html>

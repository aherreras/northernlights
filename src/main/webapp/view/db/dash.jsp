<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
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
        <!-- Cards -->
        <div class="container-fluid" id="dash">
            <div class="row justify-content-center mt-5 mb-5">
                <div class="col-md-3">
                    <div class="card text-bg-primary shadow text-center">
                        <div class="card-header">Operaciones</div>
                        <div class="card-body">
                            <div class="row align-items-center">
                                <div class="col-md-4">
                                    <div class="card text-bg-primary shadow text-center">
                                        <div class="card-body">
                                            <span class="fs-6">${opePrv}</span>
                                        </div>
                                        <div class="card-footer small text-decoration-none text-white">
                                            <span class="fs-8">${desPrv}</span>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-2">
                                    <c:choose>
                                        <c:when test="${opePrv gt opeAct}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="red" class="bi bi-arrow-down-square" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 2.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
                                            </svg>
                                        </c:when>
                                        <c:otherwise>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="green" class="bi bi-arrow-up-square-fill" viewBox="0 0 16 16">
                                            <path d="M2 16a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2zm6.5-4.5V5.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 5.707V11.5a.5.5 0 0 0 1 0z"/>
                                            </svg>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="col-md-6">
                                    <div class="card text-bg-primary shadow text-center">
                                        <div class="card-body">
                                            <div class="row align-items-center">
                                                <span class="fs-1">${opeAct}</span>
                                            </div>
                                        </div>
                                        <div class="card-footer small text-decoration-none text-white">
                                            <span class="fs-6">${desAct}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/Operaciones?accion=LST" class="card-footer small text-decoration-none text-white">
                            Ver operaciones
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card text-bg-primary shadow text-center">
                        <div class="card-header">Clientes</div>
                        <div class="card-body">
                            <div class="row align-items-center">
                                <div class="col-md-4">
                                    <div class="card text-bg-primary shadow text-center">
                                        <div class="card-body">
                                            <span class="fs-6">${cliPrv}</span>
                                        </div>
                                        <div class="card-footer small text-decoration-none text-white">
                                            <span class="fs-8">${desPrv}</span>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-2">
                                    <c:choose>
                                        <c:when test="${cliPrv gt cliAct}">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="red" class="bi bi-arrow-down-square" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm8.5 2.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
                                            </svg>
                                        </c:when>
                                        <c:otherwise>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="green" class="bi bi-arrow-up-square-fill" viewBox="0 0 16 16">
                                            <path d="M2 16a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2zm6.5-4.5V5.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 5.707V11.5a.5.5 0 0 0 1 0z"/>
                                            </svg>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="col-md-6">
                                    <div class="card text-bg-primary shadow text-center">
                                        <div class="card-body">
                                            <span class="fs-1">${cliAct}</span>
                                        </div>
                                        <div class="card-footer small text-decoration-none text-white">
                                            <span class="fs-6">${desAct}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="#" class="card-footer small text-decoration-none text-white">
                            Ver Clientes
                        </a>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-2">
                    <div class="card text-bg-success shadow text-center">
                        <div class="card-header">Ingresos</div>
                        <div class="card-body">
                            <span class="fs-1">S/. ${ing}</span>
                        </div>
                        <a href="#" class="card-footer small text-decoration-none text-white">
                            Ver ingresos
                        </a>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card card-custom shadow text-center">
                        <div class="card-header">Gastos</div>
                        <div class="card-body">
                            <span class="fs-1">S/. ${gas}</span>
                        </div>
                        <a href="#" class="card-footer small text-decoration-none">
                            Ver Gastos
                        </a>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="card text-bg-warning shadow text-center">
                        <div class="card-header">Costos</div>
                        <div class="card-body">
                            <span class="fs-1">S/. ${cos}</span>
                        </div>
                        <a href="#" class="card-footer small text-decoration-none">
                            Ver Costos
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cards -->
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
    </body>
</html>

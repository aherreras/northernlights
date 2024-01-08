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
        <%@include file="../../WEB-INF/jspf/menuglobal.jspf" %>

        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-md-2"></div>

                <!-- Bloque IGU -->
                <div class="col-md-5">
                    <!-- Ingresos -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between">
                                        <div class="p-2">
                                            <h5>Utilidad
                                                <span class="
                                                      badge
                                                      rounded-pill
                                                      text-danger
                                                      text-bg-warning
                                                      fs--1
                                                      ms-2">-5.20%
                                                </span>
                                            </h5>
                                            <div id="lblUti"></div>
                                        </div>
                                        <div class="p-2" id="totUti"></div>
                                    </div>
                                    <div class="mt-3">
                                        <canvas id="chartUt"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Ingresos -->

                    <!-- Bloque Gastos -->
                    <div class="row">
                        <div class="col-md-12 mt-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between">
                                        <div class="p-2">
                                            <h5>Ingresos
                                                <span class="
                                                      badge
                                                      rounded-pill
                                                      text-success
                                                      text-bg-light
                                                      fs--1
                                                      ms-2">+10.48%
                                                </span>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="mt-3">
                                        <canvas id="chartIng"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Gastos -->

                    <!-- Utilidad -->
                    <div class="row">
                        <div class="col-md-12 mt-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between">
                                        <div class="p-2">
                                            <h5>Gastos
                                                <span class="
                                                      badge
                                                      rounded-pill
                                                      text-success
                                                      text-bg-light
                                                      fs--1
                                                      ms-2">+10.48%
                                                </span>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="mt-3">
                                        <canvas id="chartGa"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Bloque Utilidad -->
                </div>
                <!-- Bloque IGU -->

                <!-- Bloque Top 10-->
                <div class="col-md-5">
                    <!-- Top Ingreso x Servicio -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between">
                                        <div class="p-2">
                                            <h5>Top 10 Ingresos
                                                <span class="
                                                      badge
                                                      rounded-pill
                                                      text-danger
                                                      text-bg-warning
                                                      fs--1
                                                      ms-2">-5.20%
                                                </span>
                                            </h5>
                                            <h6 class="text-700">En el mes actual</h6>
                                        </div>
                                        <div class="p-2" id="totIng"></div>
                                    </div>
                                    <div>
                                        <canvas id="chartMt"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Top Ingreso x Servicio -->

                    <!-- Top Ingresos más Solicitados -->
                    <div class="row mt-3">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between">
                                        <div class="p-2">
                                            <h5>Top 10 Servicios
                                                <span class="
                                                      badge
                                                      rounded-pill
                                                      text-danger
                                                      text-bg-warning
                                                      fs--1
                                                      ms-2">-5.20%
                                                </span>
                                            </h5>
                                            <h6 class="text-700">En el mes actual</h6>
                                        </div>
                                        <div class="p-2" id="totIng"></div>
                                    </div>
                                    <div class="mt-3">
                                        <canvas id="chartCn"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Top Ingresos más Solicitados -->
                </div>
                <!-- Bloque Top 10 -->
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="jq/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>

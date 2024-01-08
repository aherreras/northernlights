$(document).ready(function () {
    $.get("Dashboard?accion=DATA", function (data) {
        var myArray = [];
        var idCaja = [];
        var datArrayVta = [];
        var lblArray = [];
        var datArrayEdi = [];
        var datArrayXio = [];
        var datArrayGas = [];
        var lblArraySrv = [];
        var datArraySrv = [];
        var lblArrayMnt = [];
        var datArrayMnt = [];
        var lblArrayCnt = [];
        var datArrayCnt = [];
        var lblArrayUti = [];
        var datArrayUti = [];
        myArray = data.split("|");
        idCaja = obtainData(myArray[0], "0");
        lblArray = obtainData(myArray[0], "1");
        datArrayVta = obtainData2(myArray[1], idCaja);
        datArrayGas = obtainData2(myArray[2], idCaja);
//        datArrayEdi = obtainData(myArray[3], "5");
//        datArrayXio = obtainData(myArray[3], "3");
//        lblArraySrv = obtainData(myArray[4], "0");
//        datArraySrv = obtainData(myArray[4], "1");
        lblArrayMnt = obtainData(myArray[4], "0");
        datArrayMnt = obtainData(myArray[4], "1");
        lblArrayCnt = obtainData(myArray[4], "2");
        datArrayCnt = obtainData(myArray[4], "3");
        for (var i = 0; i < datArrayVta.length; i++) {
            datArrayUti.push(datArrayVta[i] - datArrayGas[i]);
        }

        var auxArrayUti = [];
        for (var i = 0; i < lblArray.length; i++) {
            auxArrayUti = lblArray[i].split(" ");
            lblArrayUti[i] = auxArrayUti[0].substring(0, 3) + ' ' + auxArrayUti[1];
        }

        $("#lblUti").append("<h6 class='text-700'>Periodo: " + lblArrayUti[0] + " - " + lblArrayUti[lblArrayUti.length - 1] + "</h6>");
        const ctx = document.getElementById('chartIng');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: lblArrayUti,
                datasets: [{
                        label: 'Ingresos',
                        data: datArrayVta,
                        borderColor: 'rgb(75, 192, 192)',
                        tension: 0,
                        fill: true
                    }]
            },
            options: {
                scales: {
                    x: {
                        ticks: {
                            font: {
                                size: 12
                            }
                        }
                    },
                    y: {
                        beginAtZero: true,
                        ticks: {
                            font: {
                                size: 12
                            }
                        }
                    }
                },
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        var uti = 0;
        for (var i = 0; i < datArrayUti.length; i++) {
            uti += eval(datArrayUti[i].toFixed(2));
        }
        $("#totUti").append("<h4 >Acumulado S/. " + new Intl.NumberFormat('en-US').format(uti) + "</h4>");
        const ctx3 = document.getElementById('chartGa');
        new Chart(ctx3, {
            type: 'line',
            data: {
                labels: lblArrayUti,
                datasets: [{
                        label: 'Gastos',
                        data: datArrayGas,
                        borderColor: 'rgb(238, 174, 87)',
                        tension: 0,
                        fill: true
                    }]
            },
            options: {
                scales: {
                    x: {
                        ticks: {
                            font: {
                                size: 12
                            }
                        }
                    },
                    y: {
                        beginAtZero: true,
                        ticks: {
                            font: {
                                size: 12
                            }
                        }
                    }
                },
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        const ctx4 = document.getElementById('chartPa');
        new Chart(ctx4, {
            type: 'line',
            data: {
                labels: ['4/9 - 10/9', '11/9 - 17/9', '18/9 - 24/9', '25/9 - 1/10'],
                datasets: [{
                        barPercentage: 0.5,
                        barThickness: 20,
                        maxBarThickness: 20,
                        minBarLength: 2,
                        label: '# of Votes',
                        data: [5, 7, 9, 15],
                        borderWidth: 1
                    }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        const ctx5 = document.getElementById('chartUt');
        new Chart(ctx5, {
            type: 'line',
            data: {
                labels: lblArrayUti,
                datasets: [{
                        label: 'Utilidad',
                        data: datArrayUti,
                        borderColor: 'rgb(211, 87, 238)',
                        tension: 0,
                        fill: true
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        const ctx6 = document.getElementById('chartCn');
        new Chart(ctx6, {
            type: 'doughnut',
            data: {
                labels: lblArrayCnt,
                datasets: [{
                        label: ' # Servicios',
                        data: datArrayCnt,
                        backgroundColor: ["#74992e", "#80ced6", "#d5f4e6", "#f18973", "#fefbd8", "#135FE5", "#C513E5", "#E51313", "#20E513", "#F2E80D"]
                    }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'right'
                    },
                    title: {
                        display: true,
                        text: 'Top 10 de servicios más solicitados',
                        color: '#000',
                        font: {
                            size: 22
                        }
                    }
                }
            },
        });
        const ctx7 = document.getElementById('chartMt');
        new Chart(ctx7, {
            type: 'pie',
            data: {
                labels: lblArrayMnt,
                datasets: [{
                        label: ' Total ingreso',
                        data: datArrayMnt,
                        backgroundColor: ["#74992e", "#80ced6", "#d5f4e6", "#f18973", "#fefbd8", "#135FE5", "#C513E5", "#E51313", "#20E513", "#F2E80D"]
                    }]
            },
            options: {
                responsive: true,
                layout: {
                    padding: 2
                },
                plugins: {
                    legend: {
                        position: 'right'
                    },
                    title: {
                        display: true,
                        text: 'Top 10 ingresos x servicio',
                        color: '#000',
                        font: {
                            size: 22
                        }
                    }
                }
            },
        });
        const ctx8 = document.getElementById('chartMtCnt');
        new Chart(ctx8, {
            type: 'pie',
            data: {
                labels: lblArrayCnt,
                datasets: [{
                        label: ' # Servicios',
                        data: datArrayCnt,
                        backgroundColor: ["#74992e", "#80ced6", "#d5f4e6", "#f18973", "#fefbd8", "#135FE5", "#C513E5", "#E51313", "#20E513", "#F2E80D"]
                    }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'right',
                        labels: {
                            font: {
                                size: 12
                            }
                        }
                    },
                    title: {
                        display: true,
                        text: 'Total ingresos x servicio'
                    }
                }
            },
        });
    }
    );
})

function obtainData(str, idx) {
    var strData = str.substring(3, str.length);
    var arr = strData.split(",");
    var result = [];
    var oldId = "0";
    var newId = "0";
    var mnt = 0.00;
    var lbl = "";

    if (str.substring(0, 2) === "d0") {
        if (idx === '0') {
            for (var i = 0; i < arr.length; i += 2) {
                result.push(arr[i]);
            }
        } else {
            for (var i = 1; i < arr.length; i += 2) {
                result.push(arr[i]);
            }
        }
        /*    
         } else if (str.substring(0, 2) === "d3") {
         for (var i = 0; i < arr.length; i++) {
         newId = arr[i];
         i++;
         if (oldId === newId) {
         mnt += eval(parseFloat(arr[i]).toFixed(2));
         } else {
         if (newId !== "1") {
         result.push(mnt);
         }
         mnt = eval(parseFloat(arr[i]).toFixed(2));
         }
         if (i === arr.length - 1) {
         result.push(mnt);
         } else {
         oldId = newId;
         }
         }
         } else if (str.substring(0, 2) === "d4") {
         for (var i = 0; i < arr.length; i++) {
         newId = arr[i];
         i++;
         if (idx === arr[i]) {
         i++;
         if (oldId === newId) {
         mnt += eval(parseFloat(arr[i]).toFixed(2));
         } else {
         if (newId !== "1") {
         result.push(mnt);
         }
         mnt = eval(parseFloat(arr[i]).toFixed(2));
         }
         if (i === arr.length - 1) {
         result.push(mnt);
         } else {
         oldId = newId;
         }
         } else {
         i++;
         if (oldId !== newId) {
         if (mnt === 0) {
         result.push(mnt);
         }
         }
         if (i === arr.length - 1) {
         result.push(mnt);
         } else {
         oldId = newId;
         }
         }
         }    
         */
    } else if (str.substring(0, 2) === "d3") {
        if (idx === "0") {
            for (var i = 0; i < arr.length; i++) {
                lbl = "# " + arr[i] + ": ";
                i++;
                lbl += arr[i];
                result.push(lbl);
                lbl = "";
            }
        } else if (idx === "1") {
            for (var i = 1; i < arr.length; i += 2) {
                result.push(arr[i]);
            }
        }
    } else if (str.substring(0, 2) === "d4") {
        if (idx === "0") {
            for (var i = 0; i < arr.length; i += 2) {
                lbl = "Total " + arr[i] + ": ";
                i++;
                lbl += "S/. " + arr[i];
                result.push(lbl);
                lbl = "";
            }
        } else if (idx === "1") {
            for (var i = 1; i < arr.length; i += 3) {
                result.push(arr[i]);
            }
        } else if (idx === "2") {
            for (var i = 0; i < arr.length; i++) {
                lbl = "# " + arr[i] + ": ";
                i += 2;
                lbl += arr[i];
                result.push(lbl);
                lbl = "";
            }
        } else if (idx === "3") {
            for (var i = 2; i < arr.length; i += 3) {
                result.push(arr[i]);
            }
        }
    }

    return result;
}

function obtainData2(str, arrCj) {
    var strData = str.substring(3, str.length);
    var arr = strData.split(",");
    var result = [];
    var idx = 0;

    for (var i = 0; i < arrCj.length; i++) {
        if (arrCj[i] === arr[idx]) {
            idx++;
            result.push(arr[idx]);
            idx++;
        } else {
            result.push(0);
        }
    }

    return result;
}
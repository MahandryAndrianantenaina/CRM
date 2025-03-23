var campaignChartWidget,
    data = [44, 55, 20, 41, 17],
    color = generateRandomColors(data.length),
    campaignChartWidgetOptions = {
        series: data,
        chart: {
            type: "donut",
            height: 270,
            zoom: { enabled: !1 },
            toolbar: { show: !1 }
        },
        theme: { mode: colors.chartTheme },
        plotOptions: {
            pie: {
                donut: {
                    size: "40%",
                    background: "transparent"
                },
                expandOnClick: !1
            }
        },
        labels: ["Clothing", "Shoes", "Others", "Electronics", "Books"],
        dataLabels: {
            enabled: false,
        },
        legend: { show: !1 },
        stroke: {
            show: !1,
            colors: colors.borderColor,
            width: 1,
            dashArray: 0
        },
        fill: {
            opacity: 1
        }
    },
  campaignChartWidgetCtn = document.querySelector("#campaignChartWidget");
  var columnChart,
    columnChartoptions = {
        series: [
            {
                name: "Expenses",
                data: [32, 66, 44, 55, 41, 24, 67, 22, 43, 32, 66, 44, 55, 41, 24, 67, 22, 43]
            },
            {
                name: "Budget",
                data: [7, 30, 13, 23, 20, 12, 8, 13, 27, 7, 30, 13, 23, 20, 12, 8, 13, 27]
            }
        ],
        chart: {
            type: "bar",
            height: 259,
            stacked: false,
            columnWidth: "70%",
            zoom: { enabled: true },
            toolbar: { show: false },
            background: "transparent"
        },
        dataLabels: { enabled: false },
        theme: { mode: colors.chartTheme },
        responsive: [
            {
                breakpoint: 480,
                options: {
                    legend: {
                        position: "bottom",
                        offsetX: -10,
                        offsetY: 0
                    }
                }
            }
        ],
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: "40%",
                radius: 30,
                enableShades: false,
                endingShape: "rounded"
            }
        },
        xaxis: {
            type: "datetime",
            categories: [
                "01/01/2020 GMT", "01/02/2020 GMT", "01/03/2020 GMT", "01/04/2020 GMT",
                "01/05/2020 GMT", "01/06/2020 GMT", "01/07/2020 GMT", "01/08/2020 GMT",
                "01/09/2020 GMT", "01/10/2020 GMT", "01/11/2020 GMT", "01/12/2020 GMT",
                "01/13/2020 GMT", "01/14/2020 GMT", "01/15/2020 GMT", "01/16/2020 GMT",
                "01/17/2020 GMT", "01/18/2020 GMT"
            ],
            labels: {
                show: true,
                trim: true,
                minHeight: undefined,
                maxHeight: 120,
                style: {
                    colors: colors.mutedColor,
                    cssClass: "text-muted",
                    fontFamily: base.defaultFontFamily
                }
            },
            axisBorder: { show: false }
        },
        yaxis: {
            labels: {
                show: true,
                trim: false,
                offsetX: -10,
                minHeight: undefined,
                maxHeight: 120,
                style: {
                    colors: colors.mutedColor,
                    cssClass: "text-muted",
                    fontFamily: base.defaultFontFamily
                }
            }
        },
        legend: {
            position: "top",
            fontFamily: base.defaultFontFamily,
            fontWeight: 400,
            labels: {
                colors: colors.mutedColor,
                useSeriesColors: false
            },
            markers: {
                width: 10,
                height: 10,
                strokeWidth: 0,
                strokeColor: "#fff",
                radius: 6,
                customHTML: undefined,
                onClick: undefined,
                offsetX: 0,
                offsetY: 0
            },
            itemMargin: {
                horizontal: 10,
                vertical: 0
            },
            onItemClick: {
                toggleDataSeries: true
            },
            onItemHover: {
                highlightDataSeries: true
            }
        },
        fill: {
            opacity: 1
        },
        grid: {
            show: true,
            borderColor: colors.borderColor,
            strokeDashArray: 0,
            position: "back",
            xaxis: {
                lines: { show: false }
            },
            yaxis: {
                lines: { show: true }
            },
            row: {
                colors: undefined,
                opacity: 0.5
            },
            column: {
                colors: undefined,
                opacity: 0.5
            },
            padding: {
                top: 0,
                right: 0,
                bottom: 0,
                left: 0
            }
        }
    },
  columnChartCtn = document.querySelector("#columnChart");

  var lineChart,
    lineChartoptions = {
        series: [
            {
                name: "Expenses",
                data: [31, 28, 30, 51, 42, 109, 100, 31, 40, 28, 31, 58, 30, 51, 42, 109, 100, 116]
            }
        ],
        chart: {
            height: 350,
            type: "line",
            background: false,
            zoom: { enabled: false },
            toolbar: { show: false }
        },
        theme: { mode: colors.chartTheme },
        stroke: {
            show: true,
            curve: "smooth",
            lineCap: "round",
            colors: chartColors,
            width: [3, 2, 3],
            dashArray: [0, 0, 0]
        },
        dataLabels: { enabled: false },
        responsive: [
            {
                breakpoint: 480,
                options: {
                    legend: {
                        position: "bottom",
                        offsetX: -10,
                        offsetY: 0
                    }
                }
            }
        ],
        markers: {
            size: 4,
            colors: base.primaryColor,
            strokeColors: colors.borderColor,
            strokeWidth: 2,
            strokeOpacity: 0.9,
            strokeDashArray: 0,
            fillOpacity: 1,
            discrete: [],
            shape: "circle",
            radius: 2,
            offsetX: 0,
            offsetY: 0,
            onClick: undefined,
            onDblClick: undefined,
            showNullDataPoints: true,
            hover: {
                size: undefined,
                sizeOffset: 3
            }
        },
        xaxis: {
            type: "datetime",
            categories: [
                "01/01/2020 GMT", "01/02/2020 GMT", "01/03/2020 GMT", "01/04/2020 GMT",
                "01/05/2020 GMT", "01/06/2020 GMT", "01/07/2020 GMT", "01/08/2020 GMT",
                "01/09/2020 GMT", "01/10/2020 GMT", "01/11/2020 GMT", "01/12/2020 GMT",
                "01/13/2020 GMT", "01/14/2020 GMT", "01/15/2020 GMT", "01/16/2020 GMT",
                "01/17/2020 GMT", "01/18/2020 GMT"
            ],
            labels: {
                show: true,
                trim: false,
                minHeight: undefined,
                maxHeight: 120,
                style: {
                    colors: colors.mutedColor,
                    cssClass: "text-muted",
                    fontFamily: base.defaultFontFamily
                }
            },
            axisBorder: { show: false }
        },
        yaxis: {
            labels: {
                show: true,
                trim: false,
                offsetX: -10,
                minHeight: undefined,
                maxHeight: 120,
                style: {
                    colors: colors.mutedColor,
                    cssClass: "text-muted",
                    fontFamily: base.defaultFontFamily
                }
            }
        },
        legend: {
            position: "top",
            fontFamily: base.defaultFontFamily,
            fontWeight: 400,
            labels: {
                colors: colors.mutedColor,
                useSeriesColors: false
            },
            markers: {
                width: 10,
                height: 10,
                strokeWidth: 0,
                strokeColor: colors.borderColor,
                fillColors: chartColors,
                radius: 6,
                customHTML: undefined,
                onClick: undefined,
                offsetX: 0,
                offsetY: 0
            },
            itemMargin: {
                horizontal: 10,
                vertical: 0
            },
            onItemClick: {
                toggleDataSeries: true
            },
            onItemHover: {
                highlightDataSeries: true
            }
        },
        grid: {
            show: true,
            borderColor: colors.borderColor,
            strokeDashArray: 0,
            position: "back",
            xaxis: {
                lines: { show: false }
            },
            yaxis: {
                lines: { show: true }
            },
            row: {
                colors: undefined,
                opacity: 0.5
            },
            column: {
                colors: undefined,
                opacity: 0.5
            },
            padding: {
                top: 0,
                right: 0,
                bottom: 0,
                left: 0
            }
        }
    },
  lineChartCtn = document.querySelector("#lineChart");

  if (lineChartCtn) {
      lineChart = new ApexCharts(lineChartCtn, lineChartoptions);
      lineChart.render();
  }
  if (columnChartCtn) {
      columnChart = new ApexCharts(columnChartCtn, columnChartoptions);
      columnChart.render();
  }
  if (campaignChartWidgetCtn) {
    campaignChartWidget = new ApexCharts(campaignChartWidgetCtn, campaignChartWidgetOptions);
    campaignChartWidget.render();
  }

// Flot Chart.js
// This file should not be included in your project.
// ====================================================================
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {


    // FLOT CHART
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================
    var pageviews = [
            [1, 400],
            [2, 350],
            [3, 400],
            [4, 400],
            [5, 450],
            [6, 550],
            [7, 480],
            [8, 550],
            [9, 500],
            [10, 610],
            [11, 520],
            [12, 570]
        ],
        unique_visitor = [
            [1, 200],
            [2, 250],
            [3, 240],
            [4, 280],
            [5, 230],
            [6, 250],
            [7, 200],
            [8, 300],
            [9, 240],
            [10, 300],
            [11, 320],
            [12, 370]
        ];

    var plot = $.plot("#demo-flot-line", [{
        label: 'Pageviews',
        data: pageviews,
        lines: {
            show: true,
            fill: true,
            lineWidth: 2,
            fillColor: {
                colors: ["rgba(255,255,255,.0)", "rgba(1,192,200,.6)"]
            }
        },
        points: {
            show: true,
            lineWidth: 2,
            fill: true,
            fillColor: "#ffffff",
            symbol: "circle",
            radius: 5
        }
    }, {
        label: 'Unique Visitor',
        data: unique_visitor,
        lines: {
            show: true,
            lineWidth: 2,
            fill: false,
            fillColor: {
                colors: [{
                    opacity: 0.5
                }, {
                    opacity: 0.5
                }]
            }
        },
        points: {
            show: true,
            lineWidth: 2,
            fill: true,
            fillColor: "#ffffff",
            symbol: "circle",
            radius: 5
        }
    }], {
        series: {
            lines: {
                show: true
            },
            points: {
                show: true
            },
            shadowSize: 0 // Drawing is faster without shadows
        },
        colors: ['#01c0c8', '#99e5e9'],
        legend: {
            show: true,
            position: 'nw',
            margin: [15]

        },
        grid: {
            hoverable: true,
            clickable: true,
            tickColor: "#eeeeee",
            borderWidth: 1,
            borderColor: "#eeeeee"
        },
        xaxis: {
            ticks: [
                [1, "Jan."],
                [2, "Feb."],
                [3, "Mar."],
                [4, "Apr."],
                [5, "May"],
                [6, "June"],
                [7, "July"],
                [8, "Aug."],
                [9, "Sept."],
                [10, "Oct."],
                [11, "Nov."],
                [12, "Dec."]
            ]
        }
    });


    // Flot tooltip
    // =================================================================
    $("<div id='demo-flot-tooltip'></div>").css({
        position: "absolute",
        display: "none",
        padding: "10px",
        color: "#fff",
        "text-align": "right",
        "background-color": "#1c1e21"
    }).appendTo("body");


    $("#demo-flot-line").bind("plothover", function(event, pos, item) {

        if (item) {
            var x = item.datapoint[0].toFixed(2),
                y = item.datapoint[1];
            $("#demo-flot-tooltip").html("<p class='h4'>" + item.series.label + "</p>" + y)
                .css({
                    top: item.pageY + 5,
                    left: item.pageX + 5
                })
                .fadeIn(200);
        } else {
            $("#demo-flot-tooltip").hide();
        }

    });




    // FLOT PIE CHART
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================
    var dataSet = [{
        label: "Comedy",
        data: 4119630000,
        color: "#01c0c8"
    }, {
        label: "Action",
        data: 1012960000,
        color: "#33ccd3"
    }, {
        label: "Adventure",
        data: 727080000,
        color: "#66d9de"
    }, {
        label: "Drama",
        data: 344120000,
        color: "#99e5e9"
    }];

    $.plot('#demo-flot-pie', dataSet, {
        series: {
            pie: {
                show: true,
                combine: {
                    color: '#999',
                    threshold: 0.1
                }
            }
        },
        legend: {
            show: true
        }
    });

    // FLOT DONUT CHART
    // =================================================================
    // Require Donut Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================
    var dataSet = [{
        label: "Comedy",
        data: 4119630000,
        color: "#01c0c8"
    }, {
        label: "Action",
        data: 1012960000,
        color: "#33ccd3"
    }, {
        label: "Adventure",
        data: 727080000,
        color: "#66d9de"
    }, {
        label: "Drama",
        data: 344120000,
        color: "#99e5e9"
    }];

    $.plot('#demo-flot-donut', dataSet, {
        series: {
            pie: {
                show: true,
                innerRadius: 0.5
            }
        },
        legend: {
            show: true
        }
    });

    // FLOT STYLED DONUT CHART
    // =================================================================
    // Require Donut Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================
    var dataSet = [{
        label: "Comedy",
        data: 4119630000,
        color: "#01c0c8",
		data: 30
    }, {
        label: "Action",
        data: 1012960000,
        color: "#33ccd3",
		data: 27
    }, {
        label: "Adventure",
        data: 727080000,
        color: "#66d9de",
		data: 18
    }, {
        label: "Romance",
        data: 785624000,
        color: "#99e5e9",
		data: 11
    }, {
        label: "Drama",
        data: 344120000,
        color: "#b2ecee",
		data: 14
    }];

    $.plot('#demo-donut-chart', dataSet, {
        series: {
            pie: {
                show: true,
                innerRadius: 0.5
            }
        },
        legend: {
            show: false
        },
        grid: {
            hoverable: true,
            clickable: true
        },
       tooltip: true,
       tooltipOpts: {
           content: "%p.0%, %s",
           defaultTheme: false
       },
    });

    // FLOT BAR CHART - NEGATIVE
    // =================================================================
    // Require flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var negativebar = [
        [0, 0],
        [1, 0.8],
        [2, 0.9],
        [3, 0.1],
        [4, -0.8],
        [5, -1.0],
        [6, -0.3],
        [7, 0.7],
        [8, 1],
        [9, 0.4],
        [10, -0.5],
        [11, -1],
        [12, -0.5],
        [13, 0.4],
        [14, 1],
        [15, 0.7],
        [16, -0.3],
        [17, -1.0],
        [18, -0.8],
        [19, 0.1],
    ];

    var data = [{
        label: "value A",
        data: negativebar
    }, ];

    $.plot($("#demo-negativebar"), data, {
        series: {
            bars: {
                show: true,
                barWidth: 0.5,
                horizontal: false,
                order: 1,
                fillColor: {
                    colors: [{
                        opacity: 0.5
                    }, {
                        opacity: 0.9
                    }]
                }
            }
        },
        legend: {
            show: true
        },
        grid: {
            borderWidth: 1,
            tickColor: "#eeeeee",
            borderColor: "#eeeeee",
            hoverable: true,
            clickable: true
        },
        xaxis: {
            font: {
                color: "#ccc"
            }
        },
        yaxis: {
            font: {
                color: "#ccc"
            }
        },
        colors: ['#01c0c8'],
    });

    // SINGLE FLOT BAR CHART
    // =================================================================
    // Require flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var singledata = [
        [1, 5],
        [2, 6],
        [3, 7],
        [4, 8],
        [5, 9],
        [6, 12],
        [7, 9],
        [8, 8],
        [9, 7],
        [10, 6],
        [11, 5]
    ];

    var data = [{
        label: "value A",
        data: singledata
    }, ];

    $.plot($("#demo-singlebar"), data, {
        series: {
            bars: {
                show: true,
                barWidth: 0.5,
                horizontal: false,
                order: 1,
                fillColor: {
                    colors: [{
                        opacity: 0.5
                    }, {
                        opacity: 0.9
                    }]
                }
            }
        },
        legend: {
            show: true
        },
        grid: {
            borderWidth: 1,
            tickColor: "#eeeeee",
            borderColor: "#eeeeee",
            hoverable: true,
            clickable: true
        },
        xaxis: {
            font: {
                color: "#ccc"
            }
        },
        yaxis: {
            font: {
                color: "#ccc"
            }
        },
        colors: ['#01c0c8'],
    });

    // FLOT BAR CHART
    // =================================================================
    // Require flot orderBars Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var a1 = [
        [1, 20],
        [2, 30],
        [3, 20],
        [4, 19],
        [5, 20],
        [6, 28]
    ];
    var a2 = [
        [1, 16],
        [2, 22],
        [3, 14],
        [4, 12],
        [5, 15],
        [6, 22]
    ];
    var a3 = [
        [1, 12],
        [2, 10],
        [3, 5],
        [4, 5],
        [5, 7],
        [6, 20]
    ];

    var data = [{
        label: "France",
        data: a1
    }, {
        label: "Germany",
        data: a2
    }, {
        label: "Italy",
        data: a3
    }];

    $.plot($("#placeholder1"), data, {
        series: {
            stack: true,
            bars: {
                show: true,
                fill: 1,
                barWidth: 0.4,
                horizontal: false
            }
        },
        grid: {
            borderWidth: 1,
            tickColor: "#eeeeee",
            borderColor: "#eeeeee",
            hoverable: true,
            clickable: true
        },
        colors: ['#01c0c8', '#4dd2d8', '#99e5e9'],
    });

    // FLOT SPLINE CHART
    // =================================================================
    // Require flot Spine Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var origData = {
            daterange: ["7-1-13", "7-7-13"],
            count: [12, 10, 31, 13, 65, 10, 14]
        },
        ticks = [],
        max = 0;

    function formatData(data) {
        dataTemp = {
            date: [],
            count: data.count
        };
        dataOut = [];

        var range = moment().range(moment(data.daterange[0], "M-D-YY"), moment(data.daterange[1], "M-D-YY"));

        range.by(moment().range(moment(data.daterange[0], "M-D-YY"), moment(data.daterange[0], "M-D-YY").add("days", 1)), function(m) {
            dataTemp.date.push(m.valueOf());
            ticks.push([m.valueOf(), m.format("MMM D")]);
        });

        num = dataTemp.count.length;

        for (var i = 0; i < num; i++) {
            dataOut.push([dataTemp.date[i], dataTemp.count[i]]);
        }

        var units = Math.pow(10, Math.floor(Math.log(Math.max.apply(Math, dataTemp.count)) / Math.log(10)));
        max = Math.ceil(Math.max.apply(Math, dataTemp.count) / units) * units;

        return dataOut;
    }

    function yticks(axis) {
        var units = Math.pow(10, Math.floor(Math.log(axis.datamax) / Math.log(10))),
            maxScale = Math.ceil(axis.datamax / units) * units,
            values = [];

        while (maxScale / 4 !== Math.round(maxScale / 4)) maxScale++;

        values.push([maxScale, (maxScale).toLocaleString()]);
        values.push([(maxScale * 3) / 4, ((maxScale * 3) / 4).toLocaleString()]);
        values.push([(maxScale * 2) / 4, ((maxScale * 2) / 4).toLocaleString()]);
        values.push([(maxScale) / 4, (maxScale / 4).toLocaleString()]);
        values.push([0, "0"]);

        return values;
    }

    var plot = $.plot("#flot-spline", [{
        label: "Uploads",
        data: formatData(origData)
    }], {
        series: {
            points: {
                radius: 4,
                fill: true,
                show: true,
                fillColor: "#01c0c8"
            },
            splines: {
                show: true,
                tension: 0.4,
                lineWidth: 1,
				fill: 1
            },
        },
        xaxis: {
            tickLength: 0,
            ticks: ticks,
        },
        yaxis: {
            font: {
                size: 11,
                lineHeight: 13,
                color: "#888"
            },
            tickFormatter: function(y) {
                return y.toLocaleString();
            },
            min: 0,
            max: max,
            ticks: yticks
        },
        colors: ["#01c0c8"],
        shadowSize: 0,
        tooltip: true,
        tooltipOpts: {
            content: function(label, x, y) {
                return '<div class="hover-title">' + moment(x).format("dddd, MMMM Do YYYY") + '</div><b style="color:#e74c3c">' + y.toLocaleString() + " </b><span>" + label.toLowerCase() + "</span>";
            }
        },
        grid: {
            hoverable: true,
            borderWidth: 0,
            margin: 1,
            mouseActiveRadius: 2000
        },
        legend: {
            labelFormatter: function() {
                return "";
            }
        }
    });

});

// FLOT REAL TIME CHART
// =================================================================
// Require Flot Area Chart
// -----------------------------------------------------------------
// http://www.flotcharts.org/
// =================================================================


        var data1 = [];
        var totalPoints = 300;
        function GetData() {
        data1.shift();
        while (data1.length < totalPoints) {
        var prev = data1.length > 0 ? data1[data1.length - 1] : 50;
        var y = prev + Math.random() * 10 - 5;
        y = y < 0 ? 0 : (y > 100 ? 100 : y);
        data1.push(y);
        }
    var result = [];
    for (var i = 0; i < data1.length; ++i) {
        result.push([i, data1[i]])
        }
    return result;
    }
    var updateInterval = 100;
    var plot = $.plot($("#demo-realtime"), [
            GetData()], {
            series: {
                lines: {
                    show: true,
                    fill: true
                },
                shadowSize: 0
            },
            yaxis: {
                min: 0,
                max: 100,
                ticks: 10
            },
            xaxis: {
                show: true
            },
            grid: {
                hoverable: true,
                clickable: true,
                tickColor: "#eeeeee",
                borderWidth: 1,
                borderColor: "#eeeeee"
            },
            colors: ["#01c0c8"]
        });
        function update() {
            plot.setData([GetData()]);
            plot.draw();
            setTimeout(update, updateInterval);
        }
        update();
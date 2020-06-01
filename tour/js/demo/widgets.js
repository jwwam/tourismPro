
// Widgets.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {

    // SITE STATISTICS
    // =================================================================
    // Require flot Spine Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var origData = {
            daterange: ["7-1-16", "7-7-16"],
            count: [60000, 100000, 80000, 140000, 80000, 100000, 80000]
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

    var plot = $.plot("#demo-site-statistics", [{
        label: "New Visitors",
        data: formatData(origData)
    }], {
        series: {
            points: {
                radius: 5,
                fill: true,
                show: true
            },
            splines: {
                show: true,
                tension: 0.4,
                lineWidth: 2,
				fill: true
            },
        },
        xaxis: {
            tickLength: 0,
            ticks: ticks,
        },
        colors: ["#666666"],
        shadowSize: 0,
        grid: {
            hoverable: true,
            borderWidth: 0,
            margin: 1,
            mouseActiveRadius: 2000
        },
    });

    // ORDER STATISTICS
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var origData = {
            daterange: ["7-8-16", "7-15-16"],
            count: [60, 80, 120, 100, 60, 80, 120]
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

    var plot = $.plot("#demo-order-statistics", [{
        label: "New Orders",
        data: formatData(origData)
    }], {
        series: {
            points: {
                radius: 5,
                fill: true,
                show: true
            },
            splines: {
                show: true,
                tension: 0.4,
                lineWidth: 2,
				fill: true
            },
        },
        xaxis: {
            tickLength: 0,
            ticks: ticks,
        },
        colors: ["#e74c3c"],
        fillColor: "#e74c3c",
        shadowSize: 0,
        grid: {
            hoverable: true,
            borderWidth: 0,
            margin: 1,
            mouseActiveRadius: 2000
        },
    });


    // SALES STATISTICS
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var origData = {
            daterange: ["7-16-16", "7-30-16"],
            count: [100, 80, 140, 100, 80, 160, 180]
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

    var plot = $.plot("#demo-sales-statistics", [{
        label: "New Sales",
        data: formatData(origData)
    }], {
        series: {
            points: {
                radius: 5,
                fill: true,
                show: true
            },
            splines: {
                show: true,
                tension: 0.4,
                lineWidth: 2,
				fill: true
            },
        },
        xaxis: {
            tickLength: 0,
            ticks: ticks,
        },
        colors: ["#29b7d3"],
        shadowSize: 0,
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




	// GMAPS
	// =================================================================
	// Require gmaps
	// -----------------------------------------------------------------
	// http://hpneo.github.io/gmaps/
	// =================================================================

	var overlayMap = new GMaps({
		div: '#demo-overlays-map',
		lat: 37.336095,
		lng: -121.8885431
	});
	overlayMap.drawOverlay({
		lat: overlayMap.getCenter().lat(),
		lng: overlayMap.getCenter().lng(),
		content: '<div class="popover top" style="display:block; width:200px"><div class="arrow"></div><div class="popover-content"><strong>You are here</strong><p>86 Washington Sq, San Jose, CA 95192, United States</p></div></div>',
		verticalAlign: 'top',
		horizontalAlign: 'center'
	});





	// MEDIUM WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	// on Android, a nasty hack is needed: {"resizeClear": true}


	skyconsOptions = {
		"color": "#fff",
		"resizeClear": true
	}





	// LARGE WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	/* Main Icon */

	var skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-lg-icon-1", Skycons.RAIN);
	skycons.play();

	var skycons2 = new Skycons(skyconsOptions);
	skycons.add("demo-weather-lg-icon-2", Skycons.PARTLY_CLOUDY_DAY);
	skycons.play();





	// SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	var skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-sm-icon", Skycons.RAIN);
	skycons.play();





	// EXTRA SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	skycons = new Skycons(skyconsOptions);
	skycons.add("demo-weather-xs-icon-1", Skycons.CLEAR_DAY);
	skycons.play();
    



	// EXTRA SMALL WEATHER WIDGET
	// =================================================================
	// Require sckycons
	// -----------------------------------------------------------------
	// http://darkskyapp.github.io/skycons/
	// =================================================================

	skycons = new Skycons({
		"color": "#00b19d",
		"resizeClear": true
	});

	skycons.add("demo-weather-xs-icon-2", Skycons.PARTLY_CLOUDY_DAY);
	skycons.play();




	// JQUERY TAG IT
	// =================================================================
	// Require jQuery Tag It
	// http://harvesthq.github.io/chosen/
	// =================================================================

    $("#jquery-tagIt-white").tagit({
        
    });


	// SUMMERNOTE
	// =================================================================
	// Require Summernote
	// http://hackerwins.github.io/summernote/
	// =================================================================
    $('#demo-summernote').summernote({
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
        ],
        height: 272   //set editable area's height
    });


});


// Homepage-2.js
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
            count: [100, 500, 300, 900, 300, 500, 300]
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

	// ORDER STATISTICS
    // =================================================================
    // Require flot Spine Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var origData = {
            daterange: ["7-1-16", "7-7-16"],
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


// FLOT REAL TIME CHART
// =================================================================
// Require Flot Area Chart
// -----------------------------------------------------------------
// http://www.flotcharts.org/
// =================================================================

		
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
        height: 300   //set editable area's height
    });

});
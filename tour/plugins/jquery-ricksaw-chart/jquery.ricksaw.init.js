	// RICKSAW CHART REALTIME
	// =================================================================
	// Require Ricksaw Chart
	// -----------------------------------------------------------------
	// https://github.com/shutterstock/rickshaw
	// =================================================================

    var seriesData = [
        [],
        []
    ];
    var random = new Rickshaw.Fixtures.RandomData(50);

    for (var i = 0; i < 50; i++) {
        random.addData(seriesData);
    }

    graph = new Rickshaw.Graph({
        element: document.querySelector("#chart"),
        height: 175,
        renderer: 'area',
        series: [{
            data: seriesData[0],
            color: 'rgb(248, 164, 163)',
            name: 'DB Server'
        }, {
            data: seriesData[1],
            color: '#eceff1',
            name: 'Web Server'
        }]
    });
    var hoverDetail = new Rickshaw.Graph.HoverDetail({
        graph: graph
    });

    setInterval(function() {
        random.removeData(seriesData);
        random.addData(seriesData);
        graph.update();

    }, 1000);

	// RICKSAW CHART REALTIME
	// =================================================================
	// Require Ricksaw Chart
	// -----------------------------------------------------------------
	// https://github.com/shutterstock/rickshaw
	// =================================================================

    var analyticData = [
        [],
        []
    ];
    var random = new Rickshaw.Fixtures.RandomData(50);

    for (var i = 0; i < 50; i++) {
        random.addData(analyticData);
    }

    analyticgraph = new Rickshaw.Graph({
        element: document.querySelector("#map-chart"),
        height: 150,
        renderer: 'area',
        series: [{
            data: analyticData[0],
            color: 'rgba(0,144,217,0.25)',
            name: 'DB Server'
        }, {
            data: analyticData[1],
            color: '#eceff1',
            name: 'Web Server'
        }]
    });
    var hoverDetail = new Rickshaw.Graph.HoverDetail({
        graph: analyticgraph
    });

    setInterval(function() {
        random.removeData(analyticData);
        random.addData(analyticData);
        analyticgraph.update();

    }, 1000);


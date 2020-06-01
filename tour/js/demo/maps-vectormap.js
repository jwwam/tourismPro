
// jvector Map
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {

    $('#world-map-markers').vectorMap({
        map: 'world_mill_en',
        scaleColors: ['#C8EEFF', '#0071A4'],
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        markerStyle: {
            initial: {
                fill: '#fad733'
            },
            selected: {
                fill: '#ffffff'
            }
        },
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        },
        series: {
            markers: [{
                attribute: 'r',
                scale: [5, 15],
                values: [
                    187.70,
                    255.16,
                    310.69,
                    605.17,
                    248.31,
                    107.35,
                    217.22
                ]
            }]
        },
        backgroundColor: '#fff',
        regionsSelectable: true,
        markersSelectable: true,
        markers: [{
            latLng: [41.90, 12.45],
            name: 'Vatican City'
        }, {
            latLng: [55.75, 37.61],
            name: 'Moscow'
        }, {
            latLng: [52.52, 13.40],
            name: 'Berlin'
        }, {
            latLng: [37.77, -122.41],
            name: 'San Francisco'
        }, {
            latLng: [3.2, 73.22],
            name: 'Maldives'
        }, {
            latLng: [32.71, -117.16],
            name: 'San Diego'
        }, {
            latLng: [40.71, -74.00],
            name: 'New York'
        }, {
            latLng: [47.60, -122.33],
            name: 'Seattle'
        }, {
            latLng: [1.3, 103.8],
            name: 'Singapore'
        }, {
            latLng: [41.87, -87.62],
            name: 'Chicago'
        }, {
            latLng: [26.02, 50.55],
            name: 'Bahrain'
        }, {
            latLng: [43.73, 7.41],
            name: 'Monaco'
        }, {
            latLng: [-0.52, 166.93],
            name: 'Nauru'
        }, {
            latLng: [-8.51, 179.21],
            name: 'Tuvalu'
        }, {
            latLng: [43.93, 12.46],
            name: 'San Marino'
        }, {
            latLng: [47.14, 9.52],
            name: 'Liechtenstein'
        }, {
            latLng: [40.71, -74.00],
            name: 'New York'
        }, {
            latLng: [29.76, -95.36],
            name: 'Houston'
        }, {
            latLng: [1.46, 173.03],
            name: 'Kiribati'
        }, {
            latLng: [-21.13, -175.2],
            name: 'Tonga'
        }, {
            latLng: [15.3, -61.38],
            name: 'Dominica'
        }]
    });

    $('#usa-map-markers').vectorMap({
        map: 'us_aea_en',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        markersSelectable: true,
        markerStyle: {
            initial: {
                fill: '#fad733',
            },
            hover: {
                stroke: 'black',
				"stroke-width": 2
            },
            selected: {
              fill: 'blue'
            }
        },
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        },
        series: {
            markers: [{
                attribute: 'r',
                scale: [5, 15],
                values: [
                    187.70,
                    255.16,
                    310.69,
                    605.17,
                    248.31,
                    107.35,
                    217.22
                ]
            }]
        },
        markers: [{
            latLng: [40.71, -74.00],
            name: 'New York'
        }, {
            latLng: [34.05, -118.24],
            name: 'Los Angeles'
        }, {
            latLng: [41.87, -87.62],
            name: 'Chicago'
        }, {
            latLng: [29.76, -95.36],
            name: 'Houston'
        }, {
            latLng: [39.95, -75.16],
            name: 'Philadelphia'
        }, {
            latLng: [38.62, -90.19],
            name: 'St. Louis,MO'
       },  {
            latLng: [38.90, -77.03],
            name: 'Washington'
       },  {
            latLng: [37.36, -122.03],
            name: 'Silicon Valley'
        }]
    });


    $('#uk-map-markers').vectorMap({
		map: 'uk_countries_mill',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        }
	});

    $('#ar-map-markers').vectorMap({
		map: 'ar_mill',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        }
	});
	
    $('#au-map-markers').vectorMap({
		map: 'au_mill',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        }
	});
	
    $('#de-map-markers').vectorMap({
		map: 'de_mill',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        }
	});

    $('#north-america-map-markers').vectorMap({
		map: 'north_america_mill',
        normalizeFunction: 'polynomial',
        hoverOpacity: 0.7,
        hoverColor: false,
        backgroundColor: '#fff',
        regionsSelectable: true,
        regionStyle: {
            initial: {
                fill: '#01c0c8'
            },
            selected: {
                fill: '#27c24c'
            }
        }
	});
	
});
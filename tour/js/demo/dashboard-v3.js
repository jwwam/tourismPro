
// Homepage-2.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {

	// JVECTOR MAP
	// =================================================================
	// Require jvectormap.js
	// -----------------------------------------------------------------
	// https://github.com/bjornd/jvectormap
	// =================================================================

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


    // EARNING STATISTICS
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================
    var earning = [['Jan', 5], ['Feb', 8], ['March', 6], ['April', 9], ['May', 7], ['June', 4], ['July', 8], ['Aug', 12], ['Sept', 6], ['Oct', 8], ['Nov', 6], ['Dec', 10]];

    var plot = $.plot("#demo-earning-statistics", [{
        label: 'Net Earning',
        data: earning,
       }], {
        series: {
            lines: {
                show: true,
				lineWidth: 2,
				fill: false
            },
            points: {
                show: true,
				lineWidth: 2,
				fill: true,
				fillColor: "#ffffff",
				symbol: "circle",
				radius: 5
            },
            shadowSize: 0 // Drawing is faster without shadows
        },
        colors: ['#248aaf'],
        tooltip: true,
        tooltipOpts: {
            defaultTheme: false
        },
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
            mode: "categories"
        }
    });


    // SALES STATISTICS
    // =================================================================
    // Require Flot Charts
    // -----------------------------------------------------------------
    // http://www.flotcharts.org/
    // =================================================================

    var sales = [['Jan', 6], ['Feb', 12], ['March', 10], ['April', 8], ['May', 12], ['June', 10], ['July', 8], ['Aug', 12], ['Sept', 6], ['Oct', 8], ['Nov', 6], ['Dec', 10]];

    var plot = $.plot("#demo-sales-statistics", [{
        label: 'New Orders',
        data: sales,
       }], {
        series: {
            lines: {
                show: true,
				lineWidth: 2,
				fill: true
            },
            points: {
                show: true,
				lineWidth: 2,
				fill: true,
				fillColor: "#ffffff",
				symbol: "circle",
				radius: 5
            },
            shadowSize: 0 // Drawing is faster without shadows
        },
        colors: ['#29b7d3;'],
        tooltip: true,
        tooltipOpts: {
            defaultTheme: false
        },
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
            mode: "categories"
        }
    });


	// COLORFUL MORRIS DONUT CHART
	// =================================================================
	// Require MorrisJS Chart
	// -----------------------------------------------------------------
	// http://morrisjs.github.io/morris.js/
	// =================================================================
	Morris.Donut({
		element: 'demo-morris-color-donut',
		data: [
			{label: "Download Sales", value: 12},
			{label: "In-Store Sales", value: 30},
			{label: "COD Sales", value: 40},
			{label: "Mail-Order Sales", value: 20}
		],
		colors: ['#E9422E', '#FAC552', '#3eb489', '#29b7d3'],
		resize:true
	});
	
    // TODO LIST
    // =================================================================
    // Require jQuery Sortable js
    // =================================================================


$("#sortable").sortable();
$("#sortable").disableSelection();

countTodos();

// all done btn
$("#checkAll").click(function(){
    AllDone();
});

//create todo
$('.add-todo').on('keypress',function (e) {
      e.preventDefault
      if (e.which == 13) {
           if($(this).val() != ''){
           var todo = $(this).val();
            createTodo(todo); 
            countTodos();
           }else{
               // some validation
           }
      }
});
// mark task as done
$('.todolist').on('change','#sortable li input[type="checkbox"]',function(){
    if($(this).prop('checked')){
        var doneItem = $(this).parent().parent().find('label').text();
        $(this).parent().parent().parent().addClass('remove');
        done(doneItem);
        countTodos();
    }
});

//delete done task from "already done"
$('.todolist').on('click','.remove-item',function(){
    removeItem(this);
});

// count tasks
function countTodos(){
    var count = $("#sortable li").length;
    $('.count-todos').html(count);
}

//create task
function createTodo(text){
    var markup = '<li class="ui-state-default"><div class="checkbox"><label class="form-checkbox form-icon"><input type="checkbox"/>'+ text +'</label></div></li>';
    $('#sortable').append(markup);
    $('.add-todo').val('');
}

//mark task as done
function done(doneItem){
    var done = doneItem;
    var markup = '<li>'+ done +'<a class="remove-item fa fa-remove pull-right" href="#" role="button"></a></li>';
    $('#done-items').append(markup);
    $('.remove').remove();
}

//mark all tasks as done
function AllDone(){
    var myArray = [];

    $('#sortable li').each( function() {
         myArray.push($(this).text());   
    });
    
    // add to done
    for (i = 0; i < myArray.length; i++) {
        $('#done-items').append('<li>' + myArray[i] + '<a class="remove-item fa fa-remove pull-right" href="#" role="button"></a></li>');
    }
    
    // myArray
    $('#sortable li').remove();
    countTodos();
}

//remove done task from list
function removeItem(element){
    $(element).parent().remove();
}

});
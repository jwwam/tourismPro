
// Form-Component.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {



	// FULLSCREEN PANEL
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================

    $("[data-click=panel-expand]").click(function(e) {
        e.preventDefault();
        var t = $(this).closest(".panel");
        if ($("body").hasClass("panel-expand") && $(t).hasClass("panel-expand")) {
            $("body, .panel").removeClass("panel-expand");
            $(".panel").removeAttr("style")
        } else {
            $("body").addClass("panel-expand");
            $(this).closest(".panel").addClass("panel-expand")
        }
        $(window).trigger("resize")
    });


	// COLLAPSE PANEL
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================

    $("[data-click=panel-collapse]").click(function(e) {
        e.preventDefault();
        $(this).closest(".panel").find(".panel-body").slideToggle()
    });


	// RELOAD PANEL
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================


    $("[data-click=panel-reload]").click(function(e) {
        e.preventDefault();
        var t = $(this).closest(".panel");
        if (!$(t).hasClass("panel-loading")) {
            var n = $(t).find(".panel-body");
            var r = '<div class="panel-loader"><span class="spinner-small"></span></div>';
            $(t).addClass("panel-loading");
            $(n).prepend(r);
            setTimeout(function() {
                $(t).removeClass("panel-loading");
                $(t).find(".panel-loader").remove()
            }, 2000)
        }
    });


	// JQUERY TAG IT - COMPONENT
	// =================================================================
	// Require Jquery Tag It 
	// https://github.com/aehlke/tag-it
	// =================================================================

    $("#jquery-tagIt-default").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-inverse").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-white").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-primary").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-info").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-success").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-warning").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    });
    $("#jquery-tagIt-danger").tagit({
        availableTags: ["tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"]
    })



	// CHOSEN
	// =================================================================
	// Require Chosen
	// http://harvesthq.github.io/chosen/
	// =================================================================
	$('.demo-chosen-select').chosen({width:'100%'});
	$('.demo-cs-multiselect').chosen({width:'100%'});



	// DEFAULT RANGE SLIDER
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-def").noUiSlider({
		start: [ 20 ],
		connect : 'lower',
		range: {
			'min': [  0 ],
			'max': [ 100 ]
		}
	}).Link('lower').to($("#demo-range-def-val"));


	// RANGE SLIDER - SLIDER STEP BY STEP
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-step").noUiSlider({
		start: [ 20 ],
		connect : 'lower',
		step:10,
		range: {
		'min': [  0 ],
		'max': [ 100 ]
		}
	}).Link('lower').to($("#demo-range-step-val"));


	// VERTICAL RANGE SLIDER
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-ver1").noUiSlider({
		start: [ 80 ],
		connect: 'lower',
		range: {
			'min':  [20],
			'max':  [100]
		},
		orientation: 'vertical',
		direction: 'rtl'
	});

	$("#demo-range-ver2").noUiSlider({
		start: [ 50 ],
		connect: 'lower',
		range: {
			'min':  [20],
			'max':  [100]
		},
		orientation: 'vertical',
		direction: 'rtl'
	});

	$("#demo-range-ver3").noUiSlider({
		start: [ 30 ],
		connect: 'lower',
		range: {
			'min':  [20],
			'max':  [100]
		},
		orientation: 'vertical',
		direction: 'rtl'
	});

	$("#demo-range-ver4").noUiSlider({
		start: [ 50 ],
		connect: 'lower',
		range: {
			'min':  [20],
			'max':  [100]
		},
		orientation: 'vertical',
		direction: 'rtl'
	});

	$("#demo-range-ver5").noUiSlider({
		start: [ 80 ],
		connect: 'lower',
		range: {
		'min':  [20],
		'max':  [100]
		},
		orientation: 'vertical',
		direction: 'rtl'
	});


	// RANGE SLIDER - DRAG
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-drg").noUiSlider({
		start: [ 40, 60 ],
		behaviour: 'drag',
		connect: true,
		range: {
		'min':  20,
		'max':  80
		}
	});

	// RANGE SLIDER - DRAG-FIXED
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-fxt").noUiSlider({
		start: [ 40, 60 ],
		behaviour: 'drag-fixed',
		connect: true,
		range: {
			'min':  20,
			'max':  80
		}
	});

	// RANGE SLIDER - DRAG TAP
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-com").noUiSlider({
		start: [ 40, 60 ],
		behaviour: 'drag-tap',
		connect: true,
		range: {
			'min':  20,
			'max':  80
		}
	});



	// RANGE SLIDER PIPS
	// =================================================================
	var range_all_sliders = {
		'min': [ 0 ],
		'25%': [ 50 ],
		'50%': [ 100 ],
		'75%': [ 150 ],
		'max': [ 200 ]
	};



	// RANGE SLIDER - HORIZONTAL PIPS
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-hpips").noUiSlider({
		range: range_all_sliders,
		connect: 'lower',
		start: 90
	});


	// RANGE SLIDER - VERTICAL PIPS
	// =================================================================
	// Require noUiSlider
	// http://refreshless.com/nouislider/
	// =================================================================
	$("#demo-range-vpips").noUiSlider({
		range: range_all_sliders,
		start: 90,
		connect: 'lower',
		orientation: 'vertical',
		direction: 'rtl'
	});
	$(".demo-pips").noUiSlider_pips({
		mode: 'range',
		density: 5
	});




	// ION.RANGESLIDER
	// =================================================================
	// Require Ion.RangeSlider
	// https://github.com/IonDen/ion.rangeSlider
	// =================================================================


    $("#default_rangeSlider").ionRangeSlider({
        min: 0,
        max: 5e3,
        type: "double",
        prefix: "$",
        maxPostfix: "+",
        prettify: false,
        grid: true
    });
    $("#customRange_rangeSlider").ionRangeSlider({
        min: 1e3,
        max: 1e5,
        from: 3e4,
        to: 9e4,
        type: "double",
        step: 500,
        postfix: " €",
        grid: true
    });
    $("#customValue_rangeSlider").ionRangeSlider({
        values: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
        type: "single",
        grid: true
    })




	// BOOTSTRAP TIMEPICKER
	// =================================================================
	// Require Bootstrap Timepicker
	// http://jdewit.github.io/bootstrap-timepicker/
	// =================================================================
	$('#demo-tp-com').timepicker();



	// BOOTSTRAP TIMEPICKER - COMPONENT
	// =================================================================
	// Require Bootstrap Timepicker
	// http://jdewit.github.io/bootstrap-timepicker/
	// =================================================================
	$('#demo-tp-textinput').timepicker({
		minuteStep: 5,
		showInputs: false,
		disableFocus: true
	});


	// BOOTSTRAP DATEPICKER
	// =================================================================
	// Require Bootstrap Datepicker
	// http://eternicode.github.io/bootstrap-datepicker/
	// =================================================================
	$('#demo-dp-txtinput input').datepicker();


	// BOOTSTRAP DATEPICKER WITH AUTO CLOSE
	// =================================================================
	// Require Bootstrap Datepicker
	// http://eternicode.github.io/bootstrap-datepicker/
	// =================================================================
	$('#demo-dp-component .input-group.date').datepicker({autoclose:true});


	// BOOTSTRAP DATEPICKER WITH RANGE SELECTION
	// =================================================================
	// Require Bootstrap Datepicker
	// http://eternicode.github.io/bootstrap-datepicker/
	// =================================================================
	$('#demo-dp-range .input-daterange').datepicker({
		format: "MM dd, yyyy",
		todayBtn: "linked",
		autoclose: true,
		todayHighlight: true
	});


	// INLINE BOOTSTRAP DATEPICKER
	// =================================================================
	// Require Bootstrap Datepicker
	// http://eternicode.github.io/bootstrap-datepicker/
	// =================================================================
	$('#demo-dp-inline div').datepicker({
	format: "MM dd, yyyy",
	todayBtn: "linked",
	autoclose: true,
	todayHighlight: true
	});



	// DROPZONE.JS
	// =================================================================
	// Require Dropzone
	// http://www.dropzonejs.com/
	// =================================================================
	Dropzone.options.demoDropzone = { // The camelized version of the ID of the form element
		// The configuration we've talked about above
		autoProcessQueue: false,
		//uploadMultiple: true,
		//parallelUploads: 25,
		//maxFiles: 25,

		// The setting up of the dropzone
		init: function() {
		var myDropzone = this;
		//  Here's the change from enyo's tutorial...
		//  $("#submit-all").click(function (e) {
		//  e.preventDefault();
		//  e.stopPropagation();
		//  myDropzone.processQueue();
			//
		//}
		//    );

		}

	}



	// SUMMERNOTE
	// =================================================================
	// Require Summernote
	// http://hackerwins.github.io/summernote/
	// =================================================================
	$('#demo-summernote').summernote({height: 250});





	// MASKED INPUT
	// =================================================================
	// Require Masked Input
	// http://digitalbush.com/projects/masked-input-plugin/
	// =================================================================


	// Initialize Masked Inputs
	// a - Represents an alpha character (A-Z,a-z)
	// 9 - Represents a numeric character (0-9)
	// * - Represents an alphanumeric character (A-Z,a-z,0-9)
	$('#demo-msk-date').mask('99/99/9999');
	$('#demo-msk-date2').mask('99-99-9999');
	$('#demo-msk-phone').mask('(999) 999-9999');
	$('#demo-msk-taxid').mask('99-9999999');
	$('#demo-msk-ssn').mask('999-99-9999');
	$('#demo-msk-pkey').mask('aaaa*-aaaa*-aaaa*-aaaa*-aaaa*');
	$('#demo-msk-currency').mask('$ 999,999,999.99');
	$('#demo-msk-ipv6').mask('9999:9999:9999:9:999:9999:9999:9999');
	$('#demo-msk-ipv4').mask('999.999.999.999');
	$('#demo-msk-isbn2').mask('999/99/999/9999/9');
	$('#demo-msk-isbn1').mask('999-99-999-9999-9');



});

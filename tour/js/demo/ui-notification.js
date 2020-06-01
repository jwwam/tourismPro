
// UI-Alerts.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {

	// [ DEMO ] GENERATE RANDOM ALERTS
	// =================================================================
	var dataAlert = [{
			type : "info"
		},{
			type : "primary"
		},{
			type : "success"
		},{
			type : "warning"
		},{
			type : "danger"
		},{
			type : "mint"
		},{
			type : "purple"
		},{
			type : "pink"
		},{
			type : "dark"
		}
	],
	alertContent = $('#demo-preview-alert-1').find('.alert').html(),
	autoClose = true;
	$('#demo-alert-close-1').on('jasmine.ch.checked', function(){
		autoClose = true;
	});
	$('#demo-alert-close-2').on('jasmine.ch.checked', function(){
		autoClose = false;
	});
	// =================================================================



	// GROW-LIKE / FLOATING ALERTS
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================
	$('#demo-alert-noty').on('click', function(){
		dataNum = jasmine.randomInt(0,8);
		contentHTML = alertContent.replace("btn-danger", "btn-"+dataAlert[dataNum].type);

		$.jasmineNoty({
			type: dataAlert[dataNum].type,
			container : 'floating',
			html : contentHTML,
			timer : autoClose ? 3000 : 0
		});
	});


	// [ DEMO ] ALERT SELECTOR
	// =================================================================
	var prevAlert = $('.demo-preview-alert');
	prevAlert.hide();
	$('#demo-preview-alert-1').fadeIn(300);
	$('#demo-alert-type-1').on('jasmine.ch.checked', function(){
		prevAlert.hide();
		alertContent = $('#demo-preview-alert-1').find('.alert').html();
		$('#demo-preview-alert-1').fadeIn(300);
	}).jasmineCheck('toggleOn');

	$('#demo-alert-type-2').on('jasmine.ch.checked', function(){
		prevAlert.hide();
		alertContent = $('#demo-preview-alert-2').find('.alert').html();
		$('#demo-preview-alert-2').fadeIn(300);
	});

	$('#demo-alert-type-3').on('jasmine.ch.checked', function(){
		prevAlert.hide();
		alertContent = $('#demo-preview-alert-3').find('.alert').html();
		$('#demo-preview-alert-3').fadeIn(300);
	});

})
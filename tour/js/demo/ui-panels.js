
// UI-Panels.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


 $(document).ready(function() {


	// UI DRAG & DROP PANEL
	// =================================================================
	// Require Bootstrap Button
	// -----------------------------------------------------------------
	// http://getbootstrap.com/javascript/#buttons
	// =================================================================

    $(".grid").sortable({
        tolerance: 'pointer',
        revert: 'invalid',
        handle: '.panel-heading',
        connectWith: '.row > [class*=col]',
        placeholder: 'well placeholder tile',
        forceHelperSize: true
    });


	// PANEL WITH SWITCH - TURN YOUR DEFAULT CHECKBOX INTO BEAUTIFUL IOS 7 STYLE SWITCHES.
	// =================================================================
	// Require Switchery
	// http://abpetkov.github.io/switchery/
	// =================================================================
	new Switchery(document.getElementById('demo-panel-w-switch'));


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

	// PANEL WITH VARIETY OF COMPONENTS - DEMO AUTO CLOSE ALERTS
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================
	$('#demo-panel-alert').on('click', function(){
		$.jasmineNoty({
			type: 'primary',
			container : '#demo-panel-w-alert',
			html : '<strong>Well done!</strong> You successfully read this important alert message.',
			focus: false,
			timer : 2000
		});
	});



	// PANEL WITH VARIETY OF COMPONENTS - DEMO STICKY ALERTS
	// =================================================================
	// Require Nyasa Admin Javascript
	// Designbudy.com
	// =================================================================
	$('#demo-panel-alert2').on('click', function(){
		$.jasmineNoty({
			type: 'success',
			container : '#demo-panel-w-alert',
			html : '<div class="media-left"> <span class="icon-wrap icon-wrap-xs icon-circle alert-icon"><i class="fa fa-thumbs-up fa-lg"></i></span></div><div class="media-body"><h4 class="alert-title">Successfully Saved</h4><p class="alert-message">Your Settings Successfully Saved</p></div>',
			focus: false
		});
	});


 });
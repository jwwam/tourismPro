
// Form-Component.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {


	// CHOSEN
	// =================================================================
	// Require Chosen
	// http://harvesthq.github.io/chosen/
	// =================================================================
	$('#demo-chosen-select').chosen();
	$('#demo-cs-multiselect').chosen({width:'100%'});



	// JQUERY TAG IT
	// =================================================================
	// Require jQuery Tag It
	// http://harvesthq.github.io/chosen/
	// =================================================================

    $("#jquery-tagIt-inverse").tagit({
        
    });
    $("#jquery-tagIt-primary").tagit({
        
    });



	// SUMMERNOTE
	// =================================================================
	// Require Summernote
	// http://hackerwins.github.io/summernote/
	// =================================================================
	$('#demo-summernote').summernote({height: 250});


});

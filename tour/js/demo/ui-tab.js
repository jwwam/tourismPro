
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


 });

// Pages Directory 
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -



$(document).ready(function() {



	// Filtering
	// -----------------------------------------------------------------
	var filtering = $('#demo-foo-filtering');
	filtering.footable().on('footable_filtering', function (e) {
		var selected = $('#demo-foo-filter-status').find(':selected').val();
		e.filter += (e.filter && e.filter.length > 0) ? ' ' + selected : selected;
		e.clear = !e.filter;
	});

	// Filter status
	$('#demo-foo-filter-status').change(function (e) {
		e.preventDefault();
		filtering.trigger('footable_filter', {filter: $(this).val()});
	});

	// Search input
	$('#demo-foo-search').on('input', function (e) {
		e.preventDefault();
		filtering.trigger('footable_filter', {filter: $(this).val()});
	});


});

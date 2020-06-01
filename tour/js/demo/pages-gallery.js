
// Gallery.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -



 $(document).ready(function() {
	 
	// GAMMA GALLERY
	// =================================================================
	// Require Gamma Gallery js
	// -----------------------------------------------------------------
	// https://github.com/codrops/GammaGallery
	// =================================================================

			    var GammaSettings = {
			        // order is important!
			        viewport: [{
			            width: 1200,
			            columns: 5
			        }, {
			            width: 900,
			            columns: 4
			        }, {
			            width: 500,
			            columns: 3
			        }, {
			            width: 320,
			            columns: 2
			        }, {
			            width: 0,
			            columns: 2
			        }]
			    };

			    Gamma.init(GammaSettings, fncallback);


			    // Example how to add more items (just a dummy):

			    var page = 0,
			        items = ['<li><div data-alt="img03" data-description="<h3>Sky high</h3>" data-max-width="1800" data-max-height="1350"><div data-src="img/gamma/xxxlarge/3.jpg" data-min-width="1300"></div><div data-src="img/gamma/xxlarge/3.jpg" data-min-width="1000"></div><div data-src="img/gamma/xlarge/3.jpg" data-min-width="700"></div><div data-src="img/gamma/large/3.jpg" data-min-width="300"></div><div data-src="img/gamma/medium/3.jpg" data-min-width="200"></div><div data-src="img/gamma/small/3.jpg" data-min-width="140"></div><div data-src="img/gamma/xsmall/3.jpg"></div><noscript><img src="img/gamma/xsmall/3.jpg" alt="img03"/></noscript></div></li><li><div data-alt="img03" data-description="<h3>Sky high</h3>" data-max-width="1800" data-max-height="1350"><div data-src="img/gamma/xxxlarge/3.jpg" data-min-width="1300"></div><div data-src="img/gamma/xxlarge/3.jpg" data-min-width="1000"></div><div data-src="img/gamma/xlarge/3.jpg" data-min-width="700"></div><div data-src="img/gamma/large/3.jpg" data-min-width="300"></div><div data-src="img/gamma/medium/3.jpg" data-min-width="200"></div><div data-src="img/gamma/small/3.jpg" data-min-width="140"></div><div data-src="img/gamma/xsmall/3.jpg"></div><noscript><img src="img/gamma/xsmall/3.jpg" alt="img03"/></noscript></div></li><li><div data-alt="img03" data-description="<h3>Sky high</h3>" data-max-width="1800" data-max-height="1350"><div data-src="img/gamma/xxxlarge/3.jpg" data-min-width="1300"></div><div data-src="img/gamma/xxlarge/3.jpg" data-min-width="1000"></div><div data-src="img/gamma/xlarge/3.jpg" data-min-width="700"></div><div data-src="img/gamma/large/3.jpg" data-min-width="300"></div><div data-src="img/gamma/medium/3.jpg" data-min-width="200"></div><div data-src="img/gamma/small/3.jpg" data-min-width="140"></div><div data-src="img/gamma/xsmall/3.jpg"></div><noscript><img src="img/gamma/xsmall/3.jpg" alt="img03"/></noscript></div></li><li><div data-alt="img03" data-description="<h3>Sky high</h3>" data-max-width="1800" data-max-height="1350"><div data-src="img/gamma/xxxlarge/3.jpg" data-min-width="1300"></div><div data-src="img/gamma/xxlarge/3.jpg" data-min-width="1000"></div><div data-src="img/gamma/xlarge/3.jpg" data-min-width="700"></div><div data-src="img/gamma/large/3.jpg" data-min-width="300"></div><div data-src="img/gamma/medium/3.jpg" data-min-width="200"></div><div data-src="img/gamma/small/3.jpg" data-min-width="140"></div><div data-src="img/gamma/xsmall/3.jpg"></div><noscript><img src="img/gamma/xsmall/3.jpg" alt="img03"/></noscript></div></li><li><div data-alt="img03" data-description="<h3>Sky high</h3>" data-max-width="1800" data-max-height="1350"><div data-src="img/gamma/xxxlarge/3.jpg" data-min-width="1300"></div><div data-src="img/gamma/xxlarge/3.jpg" data-min-width="1000"></div><div data-src="img/gamma/xlarge/3.jpg" data-min-width="700"></div><div data-src="img/gamma/large/3.jpg" data-min-width="300"></div><div data-src="img/gamma/medium/3.jpg" data-min-width="200"></div><div data-src="img/gamma/small/3.jpg" data-min-width="140"></div><div data-src="img/gamma/xsmall/3.jpg"></div><noscript><img src="img/gamma/xsmall/3.jpg" alt="img03"/></noscript></div></li>']

			    function fncallback() {

			        $('#loadmore').show().on('click', function() {

			            ++page;
			            var newitems = items[page - 1]
			            if (page <= 1) {

			                Gamma.add($(newitems));

			            }
			            if (page === 1) {

			                $(this).remove();

			            }

			        });

			    }
      
	  });

jQuery(document).ready(function($){
	
	selectnav('nav', {
		nested: true,
		indent: '-'
	});
	
	//------------------------
	/* Jquery UI */
	//------------------------
	
	$('.tabs').tabs();
		
	$('.accordion').accordion({
		autoHeight: false,
		navigation: true
	});
	
	$('.input-cal').datepicker();
	
	//------------------------
	/* Portfolio Filter Jquery */
	//------------------------
	
	var $theme_isotope = $('.tag-filter-container');
	
	if( $theme_isotope.length ){
		$(window).load(function(){
			$theme_isotope.isotope({
				filter: '*',
				animationOptions: {
					duration: 750,
					easing: 'linear',
					queue: false,
				}
			});
			
			$('.tag-filter a').click(function(){
				var selector = $(this).attr('data-filter');
				$theme_isotope.isotope({
					filter: selector,
					animationOptions: {
						duration: 750,
						easing: 'linear',
						queue: false,
					}
				});
				return false;
			});
	
			var $optionSets = $('.tag-filter'),
			$optionLinks = $optionSets.find('a');
			$optionLinks.click(function(){
				var $this = $(this);
				// don't proceed if already selected
				if ( $this.hasClass('selected') ) {
					return false;
				}
				var $optionSet = $this.parents('.tag-filter');
				$optionSet.find('.selected').removeClass('selected');
				$this.addClass('selected'); 
			});
		}); 
	}
	
	//------------------------
	/* Flexslider */
	//------------------------
	
	var $themes_flexslider = $('.flexslider');
	
	if( $themes_flexslider.length ){
		$themes_flexslider.flexslider({
			animation: "slide",
			animationLoop: true,
			controlNav: false,
			itemWidth: 116,
			minItems: 2,
			maxItems: 4
		});
	}
	
	//------------------------
	/* Camera Slider */
	//------------------------
	
	var $themes_camera_wrap = $('#camera-wrap');
	
	if( $themes_camera_wrap.length ){
		$themes_camera_wrap.camera({
			height: '500px',
			opacityOnGrid: false,
			navigation: true,
			hover: false
		});
	}
	
	//------------------------
	/* Google Maps */
	//------------------------
	
	var $themes_map_contact = $('#map-canvas');
	
	if( $themes_map_contact.length ){
		$themes_map_contact.googleMaps({
			scroll: false,
			latitude: 40.81098,
			longitude: -73.92786,
			depth: 15, 
			markers: {
				latitude: 	40.81150,
				longitude: -73.92782,
				icon: { 
					image: 'images/map-pointer.png',  
					iconSize: '45, 52', 
				} 				
			}
		}); 
	}
	
	var $themes_map = $('#gmap');
	
	if( $themes_map.length ){	
		$('#gmap').googleMaps({
			scroll: false,
			latitude: 40.81098,
			longitude: -73.92786,
			depth: 15, 
			markers: {
				latitude: 	40.81150,
				longitude: -73.92782,
				icon: { 
					image: 'images/map-pointer.png',  
					iconSize: '55, 61', 
				} 				
			}
		}); 
	}
	
	//------------------------
	/* Contact Form Validation */
	//------------------------
	
	(function() {
		var animateSpeed=300;
		var emailReg = /^[a-zA-Z0-9._-]+@([a-zA-Z0-9.-]+\.)+[a-zA-Z0-9.-]{2,4}$/;
		
			// Validating
			
			function validateInput(element,regex) {
				if (regex === undefined){				
					if (element.val()=='') {element.addClass('validation-error',animateSpeed); return false;}
					else {element.removeClass('validation-error',animateSpeed); return true;}
				}
				else{
					if (!regex.test(element.val())) {element.addClass('validation-error',animateSpeed); return false;}
					else {element.removeClass('validation-error',animateSpeed); return true;}
				}
			}
						
			$('#contact-submit').click(function() {
				var result=true;
				
				var $name = $('input[name=name]');
				var $email = $('input[name=email]');
				var $message = $('textarea[name=message]');
				
				
				// Validate
				if(!validateInput($name)) result=false;				
				if(!validateInput($email,emailReg)) result=false;
				if(!validateInput($message)) result=false;
				
				if(result==false) return false;
								
				// Data
				var data = 'name=' + $name.val() + '&email=' + $email.val() + '&message='  + encodeURIComponent($message.val());		
				var error_message = 'Sorry, unexpected error. Please try again later.';
				
				// Disable fields
				$('.input-text').attr('disabled','true');	
				
				// Sent message using ajax
				$.ajax({
				
					url: "#",	
					type: "POST",	
					data: data,		
					cache: false,
					success: function (html) {				
						
						//enable for live site
						/*						
						if (html==1) {	
							alert('Your message has been successfully sent.');	
							$('#contact-submit').attr('disabled',true);
						}						
						else {
							alert(error_message);				
						}*/
						
						//demo purpose will always show success message
						alert('Your message has been successfully sent.');	
						$('#contact-submit').attr('disabled',true);
					},
					error: function(xhr, status, error){
						alert(error_message);
					}
				});
			
				return false;
				
			});
				
			$('input[name=name]').blur(function(){validateInput($(this));});
			$('input[name=email]').blur(function(){validateInput($(this),emailReg); });
			$('textarea[name=message]').blur(function(){validateInput($(this)); });
			   
		})();
			
});
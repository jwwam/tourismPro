
// UI-Modals.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


 $(document).ready(function() {

	// BOOTBOX - ALERT MODAL
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-alert').on('click', function(){
		bootbox.alert("Hello world!", function(){
			$.jasmineNoty({
				type: 'info',
				icon : 'fa fa-info',
				message : 'Hello world callback',
				container : 'floating',
				timer : 3000
			});
		});
	});



	// BOOTBOX - CONFIRM MODAL
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-confirm').on('click', function(){
		bootbox.confirm("Are you sure?", function(result) {
			if (result) {
				$.jasmineNoty({
					type: 'success',
					icon : 'fa fa-check',
					message : 'User confirmed dialog',
					container : 'floating',
					timer : 3000
				});
			}else{
				$.jasmineNoty({
					type: 'danger',
					icon : 'fa fa-minus',
					message : 'User declined dialog.',
					container : 'floating',
					timer : 3000
				});
			};

		});
	});



	// BOOTBOX - PROMPT MODAL
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-prompt').on('click', function(){
		bootbox.prompt("What is your name?", function(result) {
			if (result) {
				$.jasmineNoty({
					type: 'success',
					icon : 'fa fa-check',
					message : 'Hi ' + result,
					container : 'floating',
					timer : 3000
				});
			}else{
				$.jasmineNoty({
					type: 'danger',
					icon : 'fa fa-minus',
					message : 'User declined dialog.',
					container : 'floating',
					timer : 3000
				});
			};
		});
	});



	// BOOTBOX - CUSTOM DIALOG
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-custom').on('click', function(){
		bootbox.dialog({
			message: "I am a custom dialog",
			title: "Custom title",
			buttons: {
				success: {
					label: "Success!",
					className: "btn-success",
					callback: function() {
						$.jasmineNoty({
							type: 'success',
							icon : 'fa fa-check',
							message : '<strong>Well done!</strong> You successfully read this important alert message. ',
							container : 'floating',
							timer : 3000
						});
					}
				},

				danger: {
					label: "Danger!",
					className: "btn-danger",
					callback: function() {
						$.jasmineNoty({
							type: 'danger',
							icon : 'fa fa-times',
							message : '<strong>Oh snap!</strong> Change a few things up and try submitting again.',
							container : 'floating',
							timer : 3000
						});
					}
				},

				main: {
					label: "Click ME!",
					className: "btn-primary",
					callback: function() {
						$.jasmineNoty({
							type: 'primary',
							icon : 'fa fa-thumbs-o-up',
							message : "<strong>Heads up!</strong> This alert needs your attention, but it's not super important.",
							container : 'floating',
							timer : 3000
						});
					}
				}
			}
		});
	});



	// BOOTBOX - CUSTOM HTML CONTENTS
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-custom-h-content').on('click', function(){
		bootbox.dialog({
			title: "That html",
			message: '<div class="media"><div class="media-left"><img class="media-object img-lg img-circle" src="img/av3.png" alt="Profile picture"></div><div class="media-body"><h4 class="text-thin">You can also use <strong>html</strong></h4>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</div></div>',
			buttons: {
				confirm: {
					label: "Save"
				}
			}
		});
	});



	// BOOTBOX - CUSTOM HTML FORM
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-custom-h-form').on('click', function(){
		bootbox.dialog({
			title: "This is a form in a modal.",
			message:'<div class="row"> ' + 
			          '<div class="col-md-6"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Name</label> ' +
					        '<input id="name" name="name" type="text" placeholder="Your name" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
			          '<div class="col-md-6"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Surname</label> ' +
					        '<input id="name" name="name" type="text" placeholder="Your name" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
				    '</div> ' + 						 
			        '<div class="row"> ' + 
			          '<div class="col-md-12"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Address :- </label> ' +
					        '<input id="name" name="name" type="text" placeholder="Address" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
				    '</div> ' + 						 
			        '<div class="row"> ' + 
			          '<div class="col-md-4"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">City  </label> ' +
					        '<input id="name" name="name" type="text" placeholder="City" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
			          '<div class="col-md-4"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Country  </label> ' +
					        '<input id="name" name="name" type="text" placeholder="Country" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
			          '<div class="col-md-4"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Zip  </label> ' +
					        '<input id="name" name="name" type="text" placeholder="Zip" class="form-control input-md"> ' +
					     '</div> ' + 
					  '</div> ' + 						 
				    '</div> ' +
			        '<div class="row"> ' + 
			          '<div class="col-md-12"> ' +
					     '<div class="form-group"> ' +
					        '<label class="control-label" for="name">Address :- </label> ' +
					        '<textarea class="form-control autogrow" id="address" placeholder="Write something about yourself" style="height: 104px;"> </textarea>  ' +
					     '</div> ' + 
					  '</div> ' + 						 
				    '</div> ' + 						 
			        '<div class="row"> ' + 
					    '<div class="form-group"> ' +
					       '<label class="col-md-4 control-label" for="awesomeness">How awesome is this ?</label> ' +
						     '<div class="col-md-8">'+
							   '<div class="form-block">' +
							     '<label class="form-radio form-icon demo-modal-radio active"><input type="radio" autocomplete="off" name="awesomeness" value="Really awesome" checked> Really awesome</label>' +
                                 '<label class="form-radio form-icon demo-modal-radio"><input type="radio" autocomplete="off" name="awesomeness" value="Super awesome"> Super awesome </label> </div>' +
					           '</div> ' +
				             '</div> ' +
				        '</div> ' +						
				    '</div> ' +
					'</div> </div>' + '</form> </div> </div><script></script>',
			buttons: {
				success: {
					label: "Save Changes",
					className: "btn-danger",
					callback: function() {
						var name = $('#name').val();
						var answer = $("input[name='awesomeness']:checked").val();

						$.jasmineNoty({
							type: 'purple',
							icon : 'fa fa-check',
							message : "Hello " + name + ".<br> You've chosen <strong>" + answer + "</strong>",
							container : 'floating',
							timer : 4000
						});
					}
				}
			}
		});

		$(".demo-modal-radio").jasmineCheck();
	});



	// BOOTBOX - Tabs in Modal
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-custom-tab').on('click', function(){
		bootbox.dialog({
			message:'<div class="tab-base">' + 
                      '<ul class="nav nav-tabs">'+
                         '<li class="active">'+
                            '<a data-toggle="tab" href="#demo-lft-tab-1"> Home </a>'+
                         '</li>'+
                         '<li>'+
                            '<a data-toggle="tab" href="#demo-lft-tab-2">Profile</a>'+
                         '</li>'+
                         '<li>'+
                            '<a data-toggle="tab" href="#demo-lft-tab-3">Message</a>'+
                         '</li>'+
                         '<li>'+
                            '<a data-toggle="tab" href="#demo-lft-tab-4">Setting</a>'+
                         '</li>'+
                      '</ul>'+
					  '<div class="tab-content">'+
                        '<div id="demo-lft-tab-1" class="tab-pane fade active in">'+
                           '<h4 class="text-thin">First Tab Content</h4>'+
                           '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>'+
                           '<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>'+
                        '</div>'+
                        '<div id="demo-lft-tab-2" class="tab-pane fade">'+
                           '<h4 class="text-thin">Second Tab Content</h4>'+
                           '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>'+
                           '<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>'+
                        '</div>'+
                        '<div id="demo-lft-tab-3" class="tab-pane fade">'+
                           '<h4 class="text-thin">Third Tab Content</h4>'+
                           '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>'+
                           '<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>'+
                        '</div>'+
                        '<div id="demo-lft-tab-4" class="tab-pane fade">'+
                           '<h4 class="text-thin">Fourth Tab Content</h4>'+
                           '<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p>'+
                           '<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>'+
                        '</div>'+
					  '</div>'+
				    '</div>' 
		        });
	       });


	// BOOTBOX - Panel in Modal
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-panel-modal').on('click', function(){
		bootbox.dialog({
			message:'<div class="panel panel-bordered panel-primary">' + 
			          '<div class="panel-heading">'+
					      '<h3 class="panel-title">Default Panel</h3>'+
					  '</div>'+
					  '<div class="panel-body">'+
					      '<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>'+
					  '</div>'+
					'</div>'					
		       });
	      });

	// BOOTBOX - Accordion in Modal
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	// =================================================================
	$('#demo-bootbox-accordion').on('click', function(){
		bootbox.dialog({
			message:  '<div class="panel-group accordion" id="accordion">'+
                         '<div class="panel">'+
                            '<div class="panel-heading">'+
                                '<h4 class="panel-title">'+
                                    '<a data-parent="#accordion" data-toggle="collapse" href="#collapseOne">Collapsible Group Item #1</a>'+
                                 '</h4>'+
                            '</div>'+
                            '<div class="panel-collapse collapse in" id="collapseOne">'+
                               '<div class="panel-body">'+
                                   '<p> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably have not heard of them accusamus labore sustainable VHS.</p>'+
                               '</div>'+
                            '</div>'+
                         '</div>'+
                         '<div class="panel">'+
                            '<div class="panel-heading">'+
                                 '<h4 class="panel-title">'+
                                     '<a data-parent="#accordion" data-toggle="collapse" href="#collapseTwo">Collapsible Group Item #2</a>'+
                                 '</h4>'+
                            '</div>'+
                            '<div class="panel-collapse collapse" id="collapseTwo">'+
                               '<div class="panel-body">'+
                                   '<p> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably have not heard of them accusamus labore sustainable VHS.</p>'+
                               '</div>'+
                            '</div>'+
                         '</div>'+
                         '<div class="panel">'+
                            '<div class="panel-heading">'+
                                 '<h4 class="panel-title">'+
                                     '<a data-parent="#accordion" data-toggle="collapse" href="#collapseThree">Collapsible Group Item #3</a>'+
                                 '</h4>'+
                            '</div>'+
                            '<div class="panel-collapse collapse" id="collapseThree">'+
                               '<div class="panel-body">'+
                                   '<p> Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably have not heard of them accusamus labore sustainable VHS.</p>'+
                               '</div>'+
                            '</div>'+
                         '</div>'+
                      '</div>'
		       });
	      });

	// BOOTBOX - ZOOM IN/OUT ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-zoom').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>Zoom In/Out</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'zoomInDown',
			animateOut : 'zoomOutUp'
		});
	});



	// BOOTBOX - BOUNCE IN/OUT ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-bounce').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>Bounce</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'bounceIn',
			animateOut : 'bounceOut'
		});
	});



	// BOOTBOX - RUBBERBAND & WOBBLE ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-ruberwobble').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>RubberBand & Wobble</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'rubberBand',
			animateOut : 'wobble'
		});
	});



	// BOOTBOX - FLIP IN/OUT ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-flip').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>Flip</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'flipInX',
			animateOut : 'flipOutX'
		});
	});



	// BOOTBOX - LIGHTSPEED IN/OUT ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-lightspeed').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>Light Speed</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'lightSpeedIn',
			animateOut : 'lightSpeedOut'
		});
	});



	// BOOTBOX - SWING & HINGE IN/OUT ANIMATION
	// =================================================================
	// Require Bootbox
	// http://bootboxjs.com/
	//
	// Animate.css
	// http://daneden.github.io/animate.css/
	// =================================================================
	$('#demo-bootbox-swing').on('click', function(){
		bootbox.confirm({
			message : "<h4 class='text-thin'>Swing & Hinge</h4><p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>",
			buttons: {
				confirm: {
					label: "Save"
				}
			},
			callback : function(result) {
				//Callback function here
			},
			animateIn: 'swing',
			animateOut : 'hinge'
		});
	});


 })

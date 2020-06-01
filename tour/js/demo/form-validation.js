
// Form-Validation.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {


	// FORM VALIDATION
	// =================================================================
	// Require Bootstrap Validator
	// http://bootstrapvalidator.com/
	// =================================================================


	// FORM VALIDATION FEEDBACK ICONS
	// =================================================================
	var faIcon = {
		valid: 'fa fa-check-circle fa-lg text-success',
		invalid: 'fa fa-times-circle fa-lg',
		validating: 'fa fa-refresh'
	}



	// PASSWORD VALIDATION
	// =================================================================
	$('#demo-password').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: faIcon,
		fields: {
		username: {
			message: 'The username is not valid',
			validators: {
				notEmpty: {
					message: 'The username is required.'
				}
			}
		},
		password: {
			validators: {
				notEmpty: {
					message: 'The password is required and can\'t be empty'
				},
				identical: {
					field: 'confirmPassword',
					message: 'The password and its confirm are not the same'
				}
			}
		},
		confirmPassword: {
			validators: {
				notEmpty: {
					message: 'The confirm password is required and can\'t be empty'
				},
				identical: {
					field: 'password',
					message: 'The password and its confirm are not the same'
				}
			}
		}
    }
	}).on('success.field.bv', function(e, data) {
		// $(e.target)  --> The field element
		// data.bv      --> The BootstrapValidator instance
		// data.field   --> The field name
		// data.element --> The field element

		var $parent = data.element.parents('.form-group');

		// Remove the has-success class
		$parent.removeClass('has-success');
	});


	// CHECKBOX & RADIO BUTTON VALIDATION
	// =================================================================
	$('#demo-checkboxradio-btn').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: faIcon,
		fields: {
		username: {
			message: 'The username is not valid',
			validators: {
				notEmpty: {
					message: 'The username is required.'
				}
			}
		},
		member: {
			validators: {
				notEmpty: {
					message: 'The gender is required'
				}
			}
		},
		'programs[]': {
			validators: {
				choice: {
					min: 2,
					max: 4,
					message: 'Please choose 2 - 4 programming languages you are good at'
				}
			}
		},
    }
	}).on('success.field.bv', function(e, data) {
		// $(e.target)  --> The field element
		// data.bv      --> The BootstrapValidator instance
		// data.field   --> The field name
		// data.element --> The field element

		var $parent = data.element.parents('.form-group');

		// Remove the has-success class
		$parent.removeClass('has-success');
	});


	// NUMBER VALIDATION
	// =================================================================
	$('#demo-number').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: faIcon,
		fields: {
		username: {
			message: 'The username is not valid',
			validators: {
				notEmpty: {
					message: 'The username is required.'
				}
			}
		},
		integer: {
			validators: {
				notEmpty: {
					message: 'The number is required and can\'t be empty'
				},
				integer: {
					message: 'The value is not a number'
				}
			}
		},
		numeric: {
			validators: {
				notEmpty: {
					message: 'The number is required and can\'t be empty'
				},
				numeric: {
					message: 'The value is not a number'
				}
			}
		},
		greaterthan: {
			validators: {
				notEmpty: {
					message: 'The number is required and can\'t be empty'
				},
				greaterThan: {
					inclusive:false,
					//If true, the input value must be greater than or equal to the comparison one.
					//If false, the input value must be greater than the comparison one
					value: 50,
					message: 'Please enter a value greater than 50'
				}
			}
		},
		lessthan: {
			validators: {
				notEmpty: {
					message: 'The number is required and can\'t be empty'
				},
				lessThan: {
					inclusive:false,
					//If true, the input value must be less than or equal to the comparison one.
					//If false, the input value must be less than the comparison one
					value: 25,
					message: 'Please enter a value less than 25'
				}
			}
		},
		range: {
			validators: {
				inclusive:true,
				notEmpty: {
					message: 'The number is required and can\'t be empty'
				},
				between: {
					min:1,
					max:100,
					message: 'Please enter a number between 1 and 100'
				}
			}
		}
    }
	}).on('success.field.bv', function(e, data) {
		// $(e.target)  --> The field element
		// data.bv      --> The BootstrapValidator instance
		// data.field   --> The field name
		// data.element --> The field element

		var $parent = data.element.parents('.form-group');

		// Remove the has-success class
		$parent.removeClass('has-success');
	});



	// FORM VARIOUS VALIDATION
	// =================================================================
	$('#demo-bvd-notempty').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: faIcon,
		fields: {
		username: {
			message: 'The username is not valid',
			validators: {
				notEmpty: {
					message: 'The username is required.'
				}
			}
		},
		uppercase:{
			validators: {
				notEmpty: {
					message: 'The card holder is required and can\'t be empty'
				},
				// Since case is a Javascript keyword,
				// you should place it between quotes (like 'case' or "case")
				// to make it work in all browsers
				stringCase: {
					message: 'The card holder must be in uppercase',
					'case': 'upper'
				}
			}
		},
		email: {
			validators: {
				notEmpty: {
					message: 'The email address is required and can\'t be empty'
				},
				emailAddress: {
					message: 'The input is not a valid email address'
				}
			}
		},
		website: {
			validators: {
				notEmpty: {
					message: 'The website address is required and can\'t be empty'
				},
				uri: {
					allowLocal: false,
					message: 'The input is not a valid URL'
				}
			}
		},
		color: {
			validators: {
				notEmpty: {
					message: 'The hex color is required and can\'t be empty'
				},
				hexColor: {
					message: 'The input is not a valid hex color'
				}
			}
		}
		}
	}).on('success.field.bv', function(e, data) {
		// $(e.target)  --> The field element
		// data.bv      --> The BootstrapValidator instance
		// data.field   --> The field name
		// data.element --> The field element

		var $parent = data.element.parents('.form-group');

		// Remove the has-success class
		$parent.removeClass('has-success');
	});


	// FORM VALIDATION
	// =================================================================

    $('#registrationForm').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            firstName: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
            lastName: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'The last name is required'
                    }
                }
            },
            username: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },
                    different: {
                        field: 'username',
                        message: 'The password cannot be the same as username'
                    }
                }
            },
            gender: {
                validators: {
                    notEmpty: {
                        message: 'The gender is required'
                    }
                }
            },
            agree: {
                validators: {
                    notEmpty: {
                        message: 'You must agree with the terms and conditions'
                    }
                }
            }
        }
    });



	// FORM VALIDATION WITH TOOLTIP
	// =================================================================
	// Indicate where the error messages are shown WITH Tooltip
	// =================================================================

	$('#demo-tooltip-validation').bootstrapValidator({
		message: 'This value is not valid',
		excluded: [':disabled'],
		feedbackIcons: faIcon,
		fields: {
		name: {
			container: 'tooltip',
			validators: {
				notEmpty: {
					message: 'The first name is required and cannot be empty'
				},
				regexp: {
					regexp: /^[A-Z\s]+$/i,
					message: 'The first name can only consist of alphabetical characters and spaces'
				}
			}
		},
		lastName: {
			validators: {
				notEmpty: {
					message: 'The last name is required and cannot be empty'
				},
				regexp: {
					regexp: /^[A-Z\s]+$/i,
					message: 'The last name can only consist of alphabetical characters and spaces'
				}
			}
		},
		email: {
			container: 'tooltip',
			validators: {
				notEmpty: {
					message: 'The email address is required and can\'t be empty'
				},
				emailAddress: {
					message: 'The input is not a valid email address'
				}
			}
		}
      }
   })

	// FORM VALIDATION WITH POPOVER
	// =================================================================
	// Indicate where the error messages are shown with popover 
	// =================================================================

	$('#demo-popover-validation').bootstrapValidator({
		message: 'This value is not valid',
		excluded: [':disabled'],
		feedbackIcons: faIcon,
		fields: {
		username: {
			container: 'popover',
			message: 'The username is not valid',
			validators: {
				notEmpty: {
					message: 'The username is required and cannot be empty'
				},
				stringLength: {
					min: 6,
					max: 30,
					message: 'The username must be more than 6 and less than 30 characters long'
				},
				regexp: {
					regexp: /^[a-zA-Z0-9_\.]+$/,
					message: 'The username can only consist of alphabetical, number, dot and underscore'
				},
				different: {
					field: 'password',
					message: 'The username and password cannot be the same as each other'
				}
			}
			},
		password: {
			container: 'popover',
				validators: {
					notEmpty: {
					message: 'The password is required and cannot be empty'
					},
					different: {
						field: 'username',
						message: 'The password cannot be the same as username'
					}
				}
		    }
        }
   })



	// FORM VALIDATION WITH CUSTOM ERROR CONTAINER
	// =================================================================
	// Indicate where the error messages are shown with Custom Container
	// =================================================================
    
	$('#demo-custom-container').bootstrapValidator({
		message: 'This value is not valid',
		excluded: [':disabled'],
		feedbackIcons: faIcon,
		fields: {
		phoneNumber: {
			container: '#demo-error-container',
			validators: {
				notEmpty: {
					message: 'The phone number is required and cannot be empty'
				},
				digits: {
					message: 'The value can contain only digits'
				}
				}
		},
		city:{
			container: '#demo-error-container',
			validators: {
				notEmpty: {
					message: 'The city is required and cannot be empty'
				},
			}
		}
	}
})

});

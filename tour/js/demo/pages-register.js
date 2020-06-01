
// Form-Validation.js
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {


    // FORM VALIDATION FEEDBACK ICONS
    // =================================================================

    // FORM VALIDATION
    // =================================================================
    // Require Bootstrap Validator
    // http://bootstrapvalidator.com/
    // =================================================================

    $('#registration').bootstrapValidator({
        framework: 'bootstrap',
        fields: {
            firstName: {
                container: '#demo-error-container',
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    },
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: 'The username must be more than 6 and less than 20 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            email: {
                container: '#demo-error-container',
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
                container: '#demo-error-container',
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    },
                    different: {
                        field: 'firstName',
                        message: 'The password cannot be the same as firstName'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'The password and its confirm are not the same'
                    }
                }
            }
        }
    });
});
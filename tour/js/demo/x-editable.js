
// Bootstrap X-editable
// ====================================================================
// This file should not be included in your project.
// This is just a sample how to initialize plugins or components.
//
// - Designbudy.com -


$(document).ready(function() {
  
   //defaults
    $.fn.editable.defaults.mode = 'popover';
    
        
    //editables 
    $('#username').editable({
           type: 'text',
           pk: 1,
           name: 'username',
           title: 'Enter username'
    });
    
    $('#firstname').editable({
        validate: function(value) {
           if($.trim(value) == '') return 'This field is required';
        }
    });
    
    $('#sex').editable({
        prepend: "not selected",
        source: [
            {value: 1, text: 'Male'},
            {value: 2, text: 'Female'}
        ],
        display: function(value, sourceData) {
             var colors = {"": "gray", 1: "green", 2: "blue"},
                 elem = $.grep(sourceData, function(o){return o.value == value;});
                 
             if(elem.length) {    
                 $(this).text(elem[0].text).css("color", colors[value]); 
             } else {
                 $(this).empty(); 
             }
        }   
    });    
    
    $('#status').editable();   
    
    $('#group').editable({
       showbuttons: false 
    });   

    $('#vacation').editable({
        datepicker: {
            todayBtn: 'linked'
        } 
    });  
        
    $('#dob').editable({
        format: 'yyyy-mm-dd',    
        viewformat: 'dd/mm/yyyy',    
        datepicker: {
                weekStart: 1
           }
    });

    $('#combodate').editable({
        format: 'YYYY-MM-DD',    
        viewformat: 'DD.MM.YYYY',    
        template: 'D / MMMM / YYYY',    
        combodate: {
                minYear: 2000,
                maxYear: 2015,
                minuteStep: 1
           }
    });

    $('#email').editable({
        title: 'Enter email'
    });

    $('#password').editable({
        title: 'Enter password'
    });

    $('#url').editable({
        title: 'Type URL'
    });

    $('#number').editable({
        title: 'Enter Number'
    });

    $('#range').editable({
        title: 'Range'
    });

    $('#time').editable({
        title: 'Enter Time'
    });

    $('#options').editable({
        value: [2, 3],    
        source: [
              {value: 1, text: 'option1'},
              {value: 2, text: 'option2'},
              {value: 3, text: 'option3'}
           ]
    });  

    $('#comments').editable({
        title: 'Enter comments',
        rows: 5,
        showbuttons: 'bottom'
    });

   $('#fruits').editable({
       pk: 1,
       limit: 3,
       source: [
        {value: 1, text: 'banana'},
        {value: 2, text: 'peach'},
        {value: 3, text: 'apple'},
        {value: 4, text: 'watermelon'},
        {value: 5, text: 'orange'}
       ]
    }); 
       

   //defaults
    $.fn.editable.defaults.mode = 'inline';
    
        
    //editables 
    $('#inline-username').editable({
           type: 'text',
           pk: 1,
           name: 'username',
    });
    
    $('#inline-firstname').editable({
        validate: function(value) {
           if($.trim(value) == '') return 'This field is required';
        }
    });
    
    $('#inline-sex').editable({
        prepend: "not selected",
        source: [
            {value: 1, text: 'Male'},
            {value: 2, text: 'Female'}
        ],
        display: function(value, sourceData) {
             var colors = {"": "gray", 1: "green", 2: "blue"},
                 elem = $.grep(sourceData, function(o){return o.value == value;});
                 
             if(elem.length) {    
                 $(this).text(elem[0].text).css("color", colors[value]); 
             } else {
                 $(this).empty(); 
             }
        }   
    });    
    
    $('#inline-status').editable();   
    
    $('#inline-group').editable({
       showbuttons: false 
    });   

    $('#inline-vacation').editable({
        datepicker: {
            todayBtn: 'linked'
        } 
    });  
        
    $('#inline-dob').editable({
        format: 'yyyy-mm-dd',    
        viewformat: 'dd/mm/yyyy',    
        datepicker: {
                weekStart: 1
           }
    });

    $('#inline-combodate').editable({
        format: 'YYYY-MM-DD',    
        viewformat: 'DD.MM.YYYY',    
        template: 'D / MMMM / YYYY',    
        combodate: {
                minYear: 2000,
                maxYear: 2015,
                minuteStep: 1
           }
    });

    $('#inline-email').editable({
    });

    $('#inline-password').editable({
    });

    $('#inline-url').editable({
    });

    $('#inline-number').editable({
    });

    $('#inline-range').editable({
    });

    $('#inline-time').editable({
    });

    $('#inline-options').editable({
        value: [2, 3],    
        source: [
              {value: 1, text: 'option1'},
              {value: 2, text: 'option2'},
              {value: 3, text: 'option3'}
           ]
    });  

    $('#inline-comments').editable({
        rows: 5,
        showbuttons: 'bottom'
    });

   $('#inline-fruits').editable({
       pk: 1,
       limit: 3,
       source: [
        {value: 1, text: 'banana'},
        {value: 2, text: 'peach'},
        {value: 3, text: 'apple'},
        {value: 4, text: 'watermelon'},
        {value: 5, text: 'orange'}
       ]
    }); 
       

});
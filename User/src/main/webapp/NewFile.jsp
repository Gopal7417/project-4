<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" 
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
</script>
<script type="text/javascript">
$(document).ready(function () {
	
	 $('#me').click(function(){
		$.ajax('hello',   // request url
		{            
			success: function (data, status, xhr) {  
			
		
				 $("#kk").append(data);
				 $("#kk1").append(data);
				 
				
				for(var i in data)
				 $.each(data, function (index, value) {
				     
				        $('#three').append($('<option>').val(data[i]).text(data[i])); 
				    });  
		              
		             
		            }
				// success callback function
			          
			
			});
		});
	 });





$(document).ready(function () {
	
	 $('#ajaxBtn').click(function(){
             
		$.getJSON("hello", function(data){
			var data1 = JSON.stringify(data);
                        document.getElementById("kk").innerHTML=data1; 
$.each(data, function (index, value) {
   
   $('#three').append($('<option>').val(value.STAN_ID).text(value.STAN_ID)); 
});
});

		});
	 });
        
        $(document).ready(function () {
        	 $('#mie').click(function(){
        		 
        		 
            var data = [{"STAN_DISTANCE":"0","STAN_ID":"VSKP","STAN_NAME":"Visakhapatnam"},
            	{"STAN_DISTANCE":"150","STAN_ID":"ANVM","STAN_NAME":"Annavaram"},
            	{"STAN_DISTANCE":"250","STAN_ID":"KKD ","STAN_NAME":"Kakinada"},
            	{"STAN_DISTANCE":"300","STAN_ID":"RMD ","STAN_NAME":"Rajamundry"},
            	{"STAN_DISTANCE":"400","STAN_ID":"VJD ","STAN_NAME":"Vijaywada"},
            	{"STAN_DISTANCE":"600","STAN_ID":"HYD ","STAN_NAME":"Hyderabad"}]
            
            
            $("#kk").append("Appended text");
            
            
            $(data).each(function (index, item) {
            	
                var isAdmin = item.STAN_ID;
            
                $('#three').append($('<option>').val(isAdmin).text(isAdmin)); 
             
            });
            

        }); 	
        	 });
        
        
        
        
        
        
    </script>
</head>
<body>

<button id="me">hello</button>
<p id="kk"></p>
<p id="kk1"></p>
 <select id="three"> 
      
        </select>
<h>hellooo</h>
</body>
</html>

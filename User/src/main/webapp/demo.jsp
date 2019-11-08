<%-- 
    Document   : newjsp
    Created on : 31 Oct, 2019, 10:01:06 AM
    Author     : pennantstaff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <script type="text/javascript" 
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
    </script>
	<script type="text/javascript">
        $(document).ready(function () {
			
		 $('#ajaxBtn').click(function(){
                  
			$.getJSON("something", function(data){
                                var data1 = JSON.stringify(data);
                             document.getElementById("kk").innerHTML=data1;
                           
    $.each(data, function (index, value) {
        
        $('#three').append($('<option>').val(value.STAN_ID).text(value.STAN_ID)); 
    });
});

			});
		 });

       
    </script>
</head>
<body>
	<h1> jQuery ajax() demo 
	</h1>
	<input type="button" id="ajaxBtn" value="press" />
        <select id="three"> 
      
        </select>
        
        
        
       <input type="button" id="ajaxBtn" value="press" />
        <select id="three"> 
      
        </select>   
        
        
	<p id="kk">
	</p>
	
	
	
</body>


</html>
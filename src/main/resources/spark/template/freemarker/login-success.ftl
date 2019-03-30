<!doctype html>
<html lang="en">


  <head>
   
  </head>
  
  
  
<body id="page_body" bgcolor="#F0FFF0" >
  
  
  
	<div class="container-fluid full">
	
			
			
			<h1>Login Status</h1>
			
			
			
			<p>You are logged in as: </p>
							
				<#if loggedInUser??>${loggedInUser}
				
				<#else>
				
					--- NOT logged in ---
				
				</#if>
			
	
	
	
	
	</div>  <!-- containter-fluid -->


<br>
<br>
<br>
<br>
<br>


<i>Please reload repeated to see logged in and NOT logged in behavior.</i>


</body>

</html>
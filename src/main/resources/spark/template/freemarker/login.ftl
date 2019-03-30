<!doctype html>
<html lang="en">


<body id="page_body" bgcolor="#F0FFF0" >
  
  
<div class="container-fluid full">

	
	<h1>Login</h1>
	
		
	<div class="row">
	
			
			<div class="col-sm-5">
	
				
					<div class="col-sm-5">
	
											
						<form id="loginForm" method="post" action="/login" accept-charset="utf-8"><div style="display:none;"><input type="hidden" name="_method" value="POST" /></div>
						<div class="input text"><label for="username">Username </label>
						<input class="form-control" name="username" type="text" id="username"  value="<#if DEV?? && DEV == true>${username}</#if>"/></div>
						<div class="input password"><label for="password">Password </label>
						<input class="form-control" type="password" name="password" id="password" <#if DEV?? && DEV == true>value="${password}"</#if> /></div>
						<div class="submit"><input 0="0" class="btn btn-primary" class="input ui-button ui-button-text-only ui-state-default ui-corner-all" type="submit" value="Submit" /></div></form>
		
											
					</div>
		
							
	
		</div>
		
	</div>
		
		

</div>  <!-- containter-fluid -->



  </body>
</html>
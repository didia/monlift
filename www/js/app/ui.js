

define(['jquery', 'app/auth'], function($, auth){
	 

	 
	 return {
 		
		go:function(){
			// implements all ui specific functions here	
		
			ML.log("Welcome to the monlift framework");
			
			$("#login-form").submit(function(e){
				e.preventDefault();
				var email = $(this).find('input[name = "email"]').val();
				var pwd = $(this).find('input[name = "passwd"]').val();	
				auth.login(email, pwd, function(resultatLogin){
					if(resulatLogin.statu == "succes")
						{
						ML.log(resultatLogin.user.firstname +" "+firstname+" Bonne visite");
						}
					else
						{
						ML.log("Erreur d'hautentification");

						}
				});
			})
		
		}
		 
	 }
 	
 })
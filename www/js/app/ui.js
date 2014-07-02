

define(['jquery', 'app/auth'], function($, auth){
	 

	 
	 return {
 		
		go:function(){
			// implements all ui specific functions here	
		
			ML.log("Welcome to the monlift framework");
			$("singin-form").submit({

				auth.login();

			})
		
		}
		 
	 }
 	
 })
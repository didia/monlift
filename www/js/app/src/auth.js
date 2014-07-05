/**
 * This file contains files related to authentification management.
 *
 */

 define(['app/monlift'], function(monlift){
	 
	 ML = monlift.getInstance();
	 
	 return {
 		/*
 		 * Function to login to the server, return a token
 		 *
 		 */
 		login: function(email, password, cb)
 		{
 			if(email && password)
 			{
	 		 	var endpoint = 'oauth/login';
	 		 	var jsonRequest = {"email":email, "password":password};
	 		 	ML.post(endpoint, jsonRequest, function(response){
					
	 		 		if(response.status = "success")
	 		 		{
	 		 			ML.log(response.body.session.token);
 						ML.log(response.body.session.user);
 						ML.setSession(response.body.session);

	 		 		}
	 		 		else
	 		 		{
	 		 			ML.log(response.data.reason);
	 		 		}

	 		 		if(cb)
	 		 		    cb(response);
	 		 	});

 		 	}

 		},

 		/*
 		 * Function to register a new user
 		 *
 		 */ 
		 
 		register:function(firstname, lastname, email, password, phone, cb){
 			if(firstname && lastname && password && email && phone)
 			{
 				var endpoint = "oauth/register";
 				var jsonRequest = {
 					"firstname":firstname,
 					"lastname":lastname,
 					"password":password,
 					"email":email,
 					"phone":phone
 				}

 				ML.post(endpoint, jsonRequest, function(response, status){
					console.log(response);
 					if(response.status = "success")
 					{
 						ML.log(response.body);

 					}
 					else
 					{
 						ML.log(response.body.reason);
 					}
 					if(cb)
 						cb(response)
 				})


 			}
 		},
		
 		/*
 		 * Function to get the login status of the user
 		 * @return boolean
 		 *
 		 */
 		 isUserLoggedIn : function()
 		 {
			 return ML.isUserLoggedIn();
		 },
		 
	 }
 	
 })
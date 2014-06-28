/**
 * This file contains files related to authentification management.
 *
 */

 define(['init'], function(){
 	ML.provide('Auth', {
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
 						Auth.setSession(response.body.session);

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
 		register:function(firstname, lastname, password, email, phone, cb){
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
 		 *Function to set a user session
 		 *session is an object with the form:
 		 * {
		 *  user: The user Object
		 *  token: The user OAuth Token.
		 * }
 		 */
 		setSession: function(session)
 		{
 			ML._session = session;
 			window.localStorage.setItem('session', session);
 		},

 		/*
 		 * Function to get the login status of the user
 		 * @return boolean
 		 *
 		 */
 		 isUserLoggedIn : function()
 		 {
 		 	if(ML._session)
 		 	{
 		 		return true;
 		 	}
 		 	session = window.localStorage.getItem('session');
 		 	if(session)
 		 	{
 		 		ML._session = session;
 		 		return true;
 		 	}

 		 	return false;
 		 }

 	})
 })
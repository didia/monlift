/**
* This file contains the ML object. This is where everything about monlift is performed.
* This helps keep monlift separated from other Object and to live to its own spaces.
* This object is inspired from the FB object of the facebook javascript sdk
*
*/

define(["jquery"], function($) {
	
	window.DEVELOPPEMENT = true;
	function MonLift()
	{
		this._session = null;
		this._userStatus = 'unknow';
		this._logging = true;
		this._domain = {
			api: window.DEVELOPPEMENT?'http://localhost:8080/api':'https://monliftca.appspot.com/api'
		};
	}
	
	
	
	MonLift.prototype = 
	{
		constructor: MonLift,
		
		init: function(options){
			this.opts = options;
			this._loadSession();
			
		},
		
		/*
		 * Load a session from localStorage if one exists
		 *
		 */
		_loadSession: function(){
			var session = window.localStorage.getItem('session');
			if(session)
 		 	{
 		 		this._session = session;
 		 		this._userStatus = "connected";
 		 	}
		},
		
		
		/**
		 * Posts json data to api 
		 * @param endpoint 
		 * @param data
		 * @param cb
		 */
		 post:function(endpoint, request, cb) {
			 	
			 request = JSON.stringify(request);
		     if(endpoint[0] != "/")
		    	  endpoint = "/" + endpoint;
		     endpoint = ML._domain.api + endpoint;
	
			 $.ajax({
			 	type: "POST",
			 	url:endpoint, 
			 	dataType:"json",
			 	async: true,
			 	data: request, 
				contentType: "application/json; charset=utf-8",

			 	success:function(data){
					console.log(data);
					cb.apply(null, [data, "ok"])
				},

			 	error: function(data){
					console.log(data);
					cb(null, [data, "failed"]);

				}
		 });
		 },
		
		/**
		 * Logs a message for the developer if logging is on.
		 *
		 * @param args {Object} the thing to log
		 */
		log: function(args) {
			if (this._logging) {
				if (window.console) {
		          window.console.log(args);
		        }
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
 			this._session = session;
			this._userStatus = "connected";
 			window.localStorage.setItem('session', session);
 		},	
 		
		/*
 		 * Function to get the login status of the user
 		 * @return boolean
 		 *
 		 */
 		 isUserLoggedIn : function()
 		 {
 		 	if(this._userStatus == "connected")
 		 	{
 		 		return true;
 		 	}
 		 	this._loadSession();
 		 	
			return this.userStatus == "connected"?true:false;
 		 },
		 
		 bind: function(toObject, methodName){
    			return function(){toObject[methodName](Array.prototype.slice.call(arguments))};
	     }
			
		
	}
	
	MonLift.instance = null;
	return {
		getInstance:function(){
			if(MonLift.instance)
			{
				return MonLift.instance;
			}
			MonLift.instance = new MonLift();
			MonLift.instance.init();
			return MonLift.instance;
		}
	}

})
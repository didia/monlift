
define(['jquery', 'react', 'app/monlift', 'app/auth', 'components/header', 'components/parametter', 'components/body', 'components/footer', 'components/forms'], 
		function($, React, monlift, auth, headers, parametters, Body, Footer, forms){
	
	 
	 ML = monlift.getInstance();
	 
	 return {
		getHeader: function(){
			return headers.IndexHeader;
		},
		
 		getHomePage: function(){
			return Body;
		
		},
		
		getFooter: function()
		{
			return Footer;
		},
		
		getLoginButton:function(){	
		
		},
		
		getLogoutButton:function(){
			
		},
		
		getRegisterButton: function(){
		
		},
		
		getLoginForm: function(){
		
		},
		
		getRegisterForm: function(){
		
		},
		
		
		getSearchForm: function(){
			return forms.SearchForm;
		},
		
		getDriverHomePage: function(){
		
		},
		
		getProfilePage: function()
		{
			
		}
		
		getParamettersDiv : function()
		{
			return parametters;
		}
		
		 
	 }
 	
 })
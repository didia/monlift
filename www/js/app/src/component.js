
define(['jquery', 'react', 'app/monlift', 'app/auth', 'components/header', 'components/body', 'components/footer', 'components/forms'], 
		function($, React, monlift, auth, Header, Body, Footer, forms){
	
	 
	 ML = monlift.getInstance();
	 
	 return {
		getHeader: function(){
			return Header;
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
		
		 
	 }
 	
 })
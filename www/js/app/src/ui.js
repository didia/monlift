/** @jsx React.DOM */
define(['jquery','react', 'app/auth', 'components/forms'], function($,React, auth, forms){
	 
	 // because JSX component do not understand the "." in forms.X, define a variable for them instead
	 var SearchForm = forms.SearchForm;
	 var LoginForm = forms.LoginForm;
	 var RegisterForm = forms.RegisterForm;
	 
	 return {
 		
		go:function(){
			// implements all ui specific functions here	
			
			React.renderComponent(
  			<SearchForm />,
  			document.getElementById('passenger-welcome')
			);
			ML.log("Welcome to the monlift framework");
			
			$("#signin").click(function(e) {
                e.preventDefault();
				console.log("signin appélé");
				if($(this).text() == "Sign in")
				{
					React.renderComponent(
					<LoginForm />,
					document.getElementById('content')
					);
					
					$(this).text("signup");
				}
				else
				{
					React.renderComponent(
						<RegisterForm />,
						document.getElementById('content')
					);
					$(this).text("Sign in");
				}
            });
			
		
		},
		
		
		 
	 }
 	
 })
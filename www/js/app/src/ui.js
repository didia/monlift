/** @jsx React.DOM */
define(['jquery','react', 'app/auth', 'app/component','components/forms'], function($,React, auth, component, forms, UI){
	 
	 // because JSX component do not understand the "." in forms.X, define a variable for them instead
	 console.log(component);
	 var SearchForm = forms.SearchForm;
	 var LoginForm = forms.LoginForm;
	 var RegisterForm = forms.RegisterForm;
	 var HomePage = component.getHomePage();
	 var Header = component.getHeader();
	 var Footer = component.getFooter();
	 
	 console.log(Header, HomePage, Footer);
	 
	 return {
 		
		go:function(){
			// implements all ui specific functions here	
			React.renderComponent(
				<Header />,
				document.getElementById('header')
			);
			
			React.renderComponent(
				<HomePage />,
				document.getElementById('app-body')
			);
			
			React.renderComponent(
				<Footer />,
				document.getElementById('footer')
			);
			
			$("#signin").click(function(e) {
                e.preventDefault();
				console.log("signin appélé");
				if($(this).text() == "Sign in")
				{
					React.renderComponent(
					<LoginForm />,
					document.getElementById('app-body')
					);
					
					$(this).text("signup");
				}
				else
				{
					React.renderComponent(
						<RegisterForm />,
						document.getElementById('app-body')
					);
					$(this).text("Sign in");
				}
            });
			
		
		},
		
		
		 
	 }
 	
 })
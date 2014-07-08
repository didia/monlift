/** @jsx React.DOM */
define(['jquery','react', 'app/auth', 'app/component','components/forms', 'app/event'], function($,React, auth, component, forms, EventProvider){
	 
	 // because JSX component do not understand the "." in forms.X, define a variable for them instead
	 
	 console.log(component);
	 var SearchForm = forms.SearchForm;
	 var LoginForm = forms.LoginForm;
	 var RegisterForm = forms.RegisterForm;
	 var HomePage = component.getHomePage();
	 var Header = component.getHeader();
	 var Footer = component.getFooter();
	 var LogOutButton = component.getLogoutButton();
	 
	 
	 
	 console.log(Header, HomePage, Footer);
	 
	 UI =  {
 		
		go:function(){
			// implements all ui specific functions here
			
			
			mixins: [events.mixinFor("logout")],	// TODO
			
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
		
		showLoginPage: function()
		{
			React.renderComponent(
				<LoginForm />,
				document.getElementById('app-body')
			);
					
		},
		
		showHomePage: function()
		{
			React.renderComponent(
				<Header />,
				document.getElementById('header')
			);
			
			React.renderComponent(
				<HomePage />,
				document.getElementById('app-body')
			);
		}
		
		
		
		 
	 }
	 
	 EventProvider.subscribe('auth.login', UI.showHomePage);
	 
	 return UI;
 	
 });

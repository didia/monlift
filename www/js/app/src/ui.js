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
			
			React.renderComponent(
				<Header page='index' />,
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
			
		},
		
		showLoginPage: function()
		{
			React.renderComponent(
				<Header page='login' />,
				document.getElementById('header')
			);
			
			React.renderComponent(
				<LoginForm />,
				document.getElementById('app-body')
			);
					
		},
		
		showHomePage: function()
		{
			
			React.renderComponent(
				<Header page='home' />,
				document.getElementById('header')
			);
			
			React.renderComponent(
				<HomePage />,
				document.getElementById('app-body')
			);
		},
		
		showRegisterPage: function()
		{
			React.renderComponent(
				<Header page='register' />,
				document.getElementById('header')
			);
			
			React.renderComponent(
				<RegisterForm />,
				document.getElementById('app-body')
			);
		}
		
		
		
		 
	 }
	 
	 EventProvider.subscribe('auth.login', UI.showHomePage);
	 EventProvider.subscribe('auth.logout', UI.showHomePage);
	 EventProvider.subscribe('ui.showLoginPage', UI.showLoginPage);
	 EventProvider.subscribe('ui.showRegisterPage', UI.showRegisterPage);
	 return UI;
 	
 });

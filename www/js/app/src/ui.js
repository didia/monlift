/** @jsx React.DOM */
define(['jquery','react', 'app/auth', 'app/component','components/forms', 'app/event', 'app/monlift'], function($,React, auth, component, forms, EventProvider, monlift){
	 
	 // because JSX component do not understand the "." in forms.X, define a variable for them instead
	ML = monlift.getInstance();
	 console.log(component);
	 var SearchForm = forms.SearchForm;
	 var LoginForm = forms.LoginForm;
	 var RegisterForm = forms.RegisterForm;
	 var HomePage = component.getHomePage();
	 var Header = component.getHeader();
	 var Footer = component.getFooter();
	 var LogOutButton = component.getLogoutButton();
	 var ProfilePage = component.getProfilePage();
	 var ParametterPage = component.getParamettersPage();
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
		},
		
		showProfilePage: function()
		{	
			
			React.renderComponent(
				<ProfilePage />,
				document.getElementById('app-body')
			);
				
		},
		showParametterPage: function()
		{	
			
			React.renderComponent(
				<ParametterPage />,
				document.getElementById('app-body')
			);
				
		},
		
		VerifieStatutAndshowProfilePage: function()
		{	
			if(ML.isUserLoggedIn())
				{
				showProfilePage();
				}
			else{
				showLoginPage();
			}
		}
		
		
		
		 
	 }
	 
	 EventProvider.subscribe('auth.login', UI.showHomePage);
	 EventProvider.subscribe('auth.logout', UI.showHomePage);
	 EventProvider.subscribe('ui.showLoginPage', UI.showLoginPage);
	 EventProvider.subscribe('ui.showRegisterPage', UI.showRegisterPage);
	 EventProvider.subscribe('ui.showProfilePage', UI.showProfilePage);
	 EventProvider.subscribe('ui.showParametterPage', UI.showParametterPage);
	 
	 return UI;
 	
 });

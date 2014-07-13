/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth','components/buttons'], 
function($, React, monlift, auth, buttons){
		
		ML = monlift.getInstance();
		
		
		return {
			Header: React.createClass({displayName:'Header',
				
		    	render: function(){
					var Button = null;
					switch(this.props.page)
					{
						case 'index':
						case 'home':
							Button = ML.isUserLoggedIn()?buttons.LogoutButton:buttons.LoginButton;
							break;
						case 'login':
							Button = buttons.RegisterButton;
							break;
						case 'register':
							Button = buttons.LoginButton;
							break;
						default:
							Button = ML.isUserLoggedIn()?buttons.LogoutButton:buttons.LoginButton;
							break;
							
					}
					
		        	return (
		            	<header className="bar bar-nav">
                        	<a className="btn pull-left" href=""> Help </a>
                            <h1 className="title">MonLift</h1>
							{Button != null?<Button />:''}
                        </header>
                    );
                                               
              	 }
                        
			}),
				
			IndexHeader: React.createClass({displayName:'IndexHeader',
		    	render: function(){
					var Button = ML.isUserLoggedIn()?buttons.LogoutButton:buttons.LoginButton;
		        	return (
		            	<header className="bar bar-nav">
                        	<a className="btn pull-left" href=""> Help </a>
                            <h1 className="title">MonLift</h1>
							<Button />
                        </header>
                    );
                                               
              	 }
                        
			}),
                                  
			LoginHeader : React.createClass({displayName:'LoginHeader',
		    	render: function(){
					var Button = component.getRegisterButton();
		        	return (
						<header className="bar bar-nav">
							<h1 className="title">MonLift</h1>
							<Button />
                         </header>
                    );
                                               
                }
            }),
            LogoutHeader: React.createClass({displayName:'LogoutHeader',
            	render:function(){
            		return(
            				<header className = "bar bar-nav">
            				<h1 className = "title">Monlift</h1>
            				<a className = "btn pull-right" href ="#"> Login</a>
            				</header>
            				);
            	}
            }),
            
            
		}
		
})

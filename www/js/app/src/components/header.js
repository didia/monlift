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
		            	<div>
                        	<a className="btn pull-left" href=""> Help </a>
                            <h1 className="title">{this.props.page}</h1>
							{Button != null?<Button />:''}
                        </div>
                    );
                                               
              	 }
                        
			}),
				
			IndexHeader: React.createClass({displayName:'IndexHeader',
		    	render: function(){
					var Button = ML.isUserLoggedIn()?buttons.LogoutButton:buttons.LoginButton;
		        	return (
		            	<div>
                        	<a className="btn pull-left" href=""> Help </a>
                            <h1 className="title">MonLift</h1>
							<Button />
                        </div>
                    );
                                               
              	 }
                        
			}),
                                  
			LoginHeader : React.createClass({displayName:'LoginHeader',
		    	render: function(){
					var Button = component.getRegisterButton();
		        	return (
						<div>
							<h1 className="title">MonLift</h1>
							<Button />
                         </div>
                    );
                                               
                }
            }),
            LogoutHeader: React.createClass({displayName:'LogoutHeader',
            	render:function(){
            		return(
            				<div>
            				<h1 className = "title">Monlift</h1>
            				<a className = "btn pull-right" href ="#"> Login</a>
            				</div>
            				);
            	}
            }),
            
            
		}
		
})

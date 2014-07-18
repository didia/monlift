/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth','components/buttons'], 
function($, React, monlift, auth, buttons){
		
		ML = monlift.getInstance();
		
		
		return {
			Header: React.createClass({displayName:'Header',
				
		    	render: function(){
					var Button = null;
					var ParametterButton = buttons.ParametterButton;
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
		            		
		            			<ParametterButton  event = "ui.showParametterPage" />
		            	
						      <h1 className="title">{this.props.page}</h1>
							{(Button != null)?<Button />:''}
                        </div>
                    );
                                               
              	 }
                        
			}),
				
			
            
            
		}
		
})

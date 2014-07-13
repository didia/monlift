/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth', 'app/event', 'app/ui'], 
function($, React, monlift, auth, EventProvider, UI){
	 
	 ML = monlift.getInstance();
	 
	 return {
 		
		LogoutButton : React.createClass({displayName:'LogoutButton',
			
			handleClick: function(e){ 
				e.preventDefault();
				auth.logout();
			},
			
			render: function(){
				return (
					<a className = "btn pull-right" href ="#" onclick={this.handleClick}> Logout </a>
				);
			}
		
		}),
		
		LoginButton: React.createClass({displayName:'LoginButton',
			handleClick: function(e){
				UI.showLoginPage();
			},
			
			render:function(){
				<a className="btn pull-right" id="login-button" onclick={this.handleClick}>Log in</a>
			}
		}),
		
		RegisterButton: React.createClass({displayName:'RegisterButton',
			handleClick:function(e){
				UI.showRegisterPage();
			},
			render: function(){
				<a className="btn pull-right" id="register-button" onclick={this.handleClick}> Register </a>
			}
		})
	 }
 	
 })
/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth', 'app/event', 'app/ui'], 
function($, React, monlift, auth, EventProvider, UI){
	 
	 ML = monlift.getInstance();
	 
	 return {
 		
		LogoutButton : React.createClass({displayName:'LogoutButton',
			
			handleClick: function(e){ 
				e.preventDefault();
				console.log("logout clicked");
				auth.logout();
			},
			
			render: function(){
				return (
					<a className = "btn pull-right" href ="#" onClick={this.handleClick}> Logout </a>
				);
			}
		
		}),
		
		LoginButton: React.createClass({displayName:'LoginButton',
			
			handleClick: function(e){
				EventProvider.fire('ui.showLoginPage');
			},
			
			render:function(){
				return (
					<a className="btn pull-right" id="login-button" onClick={this.handleClick}>Log in</a>
				);
			}
		}),
		
		RegisterButton: React.createClass({displayName:'RegisterButton',
			handleClick:function(e){
				EventProvider.fire('ui.showRegisterPage');
			},
			render: function(){
				return (
					<a className="btn pull-right" id="register-button" onClick={this.handleClick}> Register </a>
				);
			}
		}),
		
		FooterButton: React.createClass({displayName:'FooterButton',
			handleClick:function(e){
				EventProvider.fire(this.props.event);
			},
			render: function(){
				return (
					<a className="tab-item" onClick={this.handleClick} href="#">
								<img src={this.props.image}   height="30" weight="30"  />
					</a>
				);
			}
		})
	 }
 	
 })
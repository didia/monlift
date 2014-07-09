/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
		ML = monlift.getInstance();
		
		return {	
			IndexHeader: React.createClass({displayName:'IndexHeader',
		    	render: function(){
		        	return (
		            	<header className="bar bar-nav">
                        	<a className="btn pull-left" href=""> Help </a>
                            <h1 className="title">MonLift</h1>
							<a className="btn pull-right" id="signin">Signin </a>
                        </header>
                    );
                                               
              	 }
   
                                        
			}),
                                  
			LoginHeader : React.createClass({displayName:'LoginHeader',
		    	render: function(){
		        	return (
						<header className="bar bar-nav">
							<h1 className="title">MonLift</h1>
							<a className="btn pull-right" href="">logout</a>
                         </header>
                    );
                                               
                }
            }),
            logoutHeader: react.createClass({displayName:'logoutHeader'
            	render:function(){
            		return(
            				<header className = "bar bar-nav">
            				<h1 className = "title">Monlift</h1>
            				<a className = "btn pull-right" href ="#" Login</a>
            				</header>
            				);
            	}
            }),
            
            
		}
		
})

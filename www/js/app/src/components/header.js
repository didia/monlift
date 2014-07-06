/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
		ML = monlift.getInstance();
		
		return {	
			IndexHeader: React.createClass({displayName:'IndexHeader',
		    	render: function(){
		        	return (
		            	<header class="bar bar-nav">
                        	<a classeName="btn pull-left" href=""> Help </a>
                            <h1 classeName="title">MonLift</h1>
							<a classeName="btn pull-right" href="">Signin </a>
                        </header>
                    );
                                               
              	 }
   
                                        
			}),
                                  
			LoginHeader : React.createClass({displayName:'LoginHeader',
		    	render: function(){
		        	return (
						<header classeName="bar bar-nav">
							<h1 classeName="title">MonLift</h1>
							<a class="btn pull-right" href="">logout</a>
                         </header>
                    );
                                               
                }
            })
		
		}
		
})

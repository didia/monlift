/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
		ML = monlift.getInstance();
		
		return {	IndexHeader: React.createClass({displayName:'IndexHeader',
		                    render: function(){
		                    	    return (
		                    	    	
		                    	    	<header class="bar bar-nav">
                                  
                                                   <a classeName="btn pull-left" href=""> Help </a>
                                    
                                                   <h1 classeName="title">MonLift</h1>
                                  
                                                   <a classeName="btn pull-right" href="html/loginForm.html">Signin </a>
                                
                                               </header>
                                               );
                                               
                                         }
                                         
                                        
                                        
                                        
                                  })
                                  
                                  
                                  
                                  LoginHeadr : React.createClass({displayName:'LoginHeadr ',
		                    render: function(){
		                    	    return (
		                    	    	
		                    	    	<header classeName="bar bar-nav">
                                  
                                                   <a classeName="btn pull-left" href=""> Help </a>
                                    
                                                   <h1 classeName="title">MonLift</h1>
                                  
                                                   <a class="btn pull-right" href="html/loginForm.html">Signin </a>
                                
                                               </header>
                                               );
                                               
                                         }
                                         
                                        
                                        
                                        
                                  })
			
			
		}
		
	
})

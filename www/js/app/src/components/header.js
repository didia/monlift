/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	
	var Header = React.createClass({displayName:'Header', 
		render: function(){
			return (
				<header class="bar bar-nav">
                                  
                                  <a class="btn pull-left" href=""> Help </a>
                                  
                                  <h1 class="title">MonLift</h1>
                                  
                                  <a class="btn pull-right" href="html/loginForm.html">Signin </a>
                                
                                </header>
			)
		}
	});
	
	return Header;
	
});

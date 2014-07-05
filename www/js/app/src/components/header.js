/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	
	var Header = React.createClass({displayName:'Header', 
		render: function(){
			return (
				<header className="bar bar-nav">
            		<a className="icon icon-list pull-left"></a>
            		<h1 className="title">MonLift</h1>
            		<a id="signin" className="btn pull-right">Sign in</a>
             	</header>
			)
		}
	});
	
	return Header;
	
});
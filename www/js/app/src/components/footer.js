/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	
	var Footer = React.createClass({displayName:'Footer', 
		render: function(){
			return (
				<div className="bar bar-tab">
            		<a className="tab-item">
                		<span className="tab-label">
                  			<img src="img/icon.png" height="30" /> 
                		</span>
           			 </a>
        		</div>
			)
		}
	});
	
	return Footer;
	
});// JavaScript Document
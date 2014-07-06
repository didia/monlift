/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	
	var Footer = React.createClass({displayName:'Footer', 
		render: function(){
			return (
        		<div className ="bar bar-tab">
            		<a className="tab-item">                
                 		<span className="icon icon-home"  href=""></span>
            		</a>
            		<a className="tab-item">
                  		<span className="icon icon-plus" href="#"></span>
					</a>
        		</div>
			)
		}
	});
	
	return Footer;
	
});// JavaScript Document
/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	
	var Footer = React.createClass({displayName:'Footer', 
		render: function(){
			return (
        		<div class ="bar bar-tab">
            		<a class="tab-item">                
                 		<span class="icon icon-home"  href=""></span>
            		</a>
            		<a class="tab-item">
                  		<span class="icon icon-plus" href="#"></span>
					</a>
        		</div>
			)
		}
	});
	
	return Footer;
	
});// JavaScript Document
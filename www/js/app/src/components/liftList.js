/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'components/lift'], function($, React, monlift, Lift){
	
	var LiftList = React.createClass({displayName:'LiftList', 
		render: function(){
			return (
				<div>
          	    	<ul class="table-view">
						<Lift />
						<Lift />
					</ul>
        		</div>
			)
		}
	});
	
	return LiftList;
	
});// JavaScript Document
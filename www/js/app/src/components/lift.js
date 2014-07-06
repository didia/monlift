/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift'], function($, React, monlift){
	
	var Lift = React.createClass({displayName:'Lift', 
		render: function(){
			return (
				<li class="table-view-cell media">
             		<img src="img/D04.png" height="70" weight="70" />
					<div class="media-body">
                		fred
                  		<h4>
                  			FROM:SSSSS
                      		<a href="">
                      		</a>
							TO:SSSSS
                      		<a href="">
                      		</a>
                 		</h4>
              			<div id="ride-pic">
              				<img src="img/car2.png"  height="100" weight="100" />
						</div>
      				</div>
  				</li>
			)
		}
	});
	
	return Lift;
	
});// JavaScript Document
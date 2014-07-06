/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift'], function($, React, monlift){
	
	var Lift = React.createClass({displayName:'Lift', 
		render: function(){
			return (
				
                               
                 <div>

                        <ul class="table-view">
    
                           <li class="table-view-cell media">

                           		<img  src="img/photo.jpg" height="70" weight="70" />

                           		<div class="media-body">
        
                            		<a href="">  fredy   </a>              

                           			<img src="img/car2.png"  height="100" weight="100" />
								</div>
							</li>
						</ul>
              	</div>
                       


			)
		}
	});
	
	return Lift;
	
});// JavaScript Document

/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'components/buttons'], function($, React, monlift, buttons){
		ML = monlift.getInstance();
		var FooterButton = buttons.FooterButton;
		return {
			
				IndexFooter: React.createClass({displayName:'IndexFooter',
				
					render: function(){
						return (
	                  
						  <div>
						  	<FooterButton active="true" image="img/Search.png" event="" />
							<FooterButton image = "img/addLift.png" event="" />
							<FooterButton image = "img/road.svg" event="" />
							<FooterButton image = "img/notification.png" event="" />
							<FooterButton image = "img/profil.png" event="ui.showProfilePage" />
						  </div>
                    	);
                                               
               		 }
   

                                        
      })
		           

			
	}

})// JavaScript Document

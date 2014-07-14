/** @jsx React.DOM */


define(['jquery', 'react', 'app/monlift'], function($, React, monlift){
                ML = monlift.getInstance();
                
                return {
                
                	DriverProfile: React.createClass({displayName:'DriverProfile',
                	render: function(){
                	        return (
                	        
                	        <div className="content_Driver_Profil">
                	        
                	          <div id="box">
                	               <div id="topleft">
                	                    <img src="img/profil.png"   height="30" weight="30" id="profil" href="" />
                	                              <h5 id="MyInfos">My Infos</h5>
                	               </div>
                	               
                	               <div id="topright">
                	                    <img src="img/addlift.png"   height="30" weight="30" id="addlift" href="" />
                	                              <h5 id="MyAutos">My Autos</h5>
                	               </div>
                	               
                	               <div id="bottomleft">
                	                    <img src="img/Alert.png"   height="30" weight="30" id="Alert" href="" />
                	                              <h5 id="MyAlerts">My Alerts</h5>
                	                              
                	                   </div>
                                <div id="bottomright">
                                     <img src="img/reviews.png"   height="30" weight="30"  id ="rev"  href="" />
                                             <h5 id="MyReviews">My Reviews</h5>
                                </div>

                           </div>
                        </div>
                    );
                                               
               }
                
          }),
                
        
        
           PassangerProfile: React.createClass({displayName:'PassangerProfile',
                	render: function(){
                	        return (
								<div className="content_Passanger_Profil">
                                        <div id="box">
                                          
										  <div id="topleft">
                                             <img src="img/profil.png"   height="30" weight="30" id="profil" href="" />
                                             <h5 id="MyInfos">My Infos</h5>
                                          </div>
                                        
										<div id="topright">
                                         	<img src="img/addlift.png"   height="30" weight="30" id="addlift" href="" />
                                         	<h5 id="MyAutos">My Autos</h5>
                                        </div>

                                        <div id="bottomleft">
                                         	<img src="img/Alert.png"   height="30" weight="30" id="Alert" href="" />
                                         	<h5 id="MyAlerts">My Alerts</h5>
                                        </div>
									
                                      </div>

                                    </div>        

                   );
                                               
               }
                
          })
                   
      }

})

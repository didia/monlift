/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth', 'components/buttons'], function($, React, monlift, auth, buttons){

	ML = monlift.getInstance();
	return{
	Parametters :React.createClass({displayName:'parametters',
	render:function(){
		return(
				<div className="paramComponents" id = "paramComponents">
				
				
				<ul className="table-view">
				<li className="table-view-cell media">
					<a className="pull-right">
					<div className="slider" id = "logo">
					  
					 <img src="img/logoTest.png"  height="100" weight="100" />
					    
					</div>
					</a>
					</li>
					
					
				  {(ML.isUserLoggedIn())?<li className="table-view-cell media">
				    <a className="navigate-right" href="#" onClick={auth.logout}>
				      <span className="media-object pull-right icon icon-person"></span>
				      <div className="media-body">
				    	  Fermer votre session
				      </div>
				    </a>
				  </li>:
				  <li className="table-view-cell media">
				    <a className="navigate-right">
				      <span className="media-object pull-right icon icon-person"></span>
				      <div className="media-body">
				    	  ouvrir une session
				      </div>
				    </a>
				  </li>}
				  
				  
				  {(ML.isUserLoggedIn())? <li className="table-view-cell">
				    Notification lift dispo
				    <div className="toggle active">
				      <div className="toggle-handle"></div>
				    </div>
				  </li>:''}
				  
				  <li className="table-view-cell media">
				    <a className="navigate-right ">
				      <span className="media-object pull-right"> <img class="tab-icon" src="img/enveloppe.png" height="30" weight="30"/></span>
				      <div className="media-body">
				      Contacter le soutien technique
				      </div>
				    </a>
				  </li>
				  
				  <li className="table-view-cell media">
				    <a className="navigate-right">
				      <span className="media-object pull-left icon icon-help"></span>
				      <div className="media-body">
				      Partager cette application
				      </div>
				    </a>
				  </li>
				  
				  <li className="table-view-cell media">
				    <a className="navigate-right">
				      <span className="media-object pull-left icon icon-help"></span>
				      <div className="media-body">
				      Laisser un commentaire
				      </div>
				    </a>
				  </li>
				  
				  <li className="table-view-cell media">
				    <a className="navigate-right">
				      <span className="media-object pull-left icon icon-help"></span>
				      <div class="media-body">
				      Condition d'utilistion
				      </div>
				    </a>
				  </li>
				  
				  <li className="table-view-cell media">
				    <a className="navigate-right">
				      <span className="media-object pull-left icon icon-help"></span>
				      <div class="media-body">
				        Help
				      </div>
				    </a>
				  </li>
				</ul>
				</div>
			);
		}
	})
	}
	})// JavaScript Document
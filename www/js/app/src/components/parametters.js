/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift'], function($, React, monlift){

	ML = monlift.getInstance();
	
	var parametters = React.createClass({displayName:'parametters',
	render:function(){
		retrun(
		<div className="paramComponents" id = "paramComponents"> 
		<div className= "segmented-control"> 
		if ML.isUserLoggedIn(){
			<a className="control-item active" href = "# ">
			Ouvrir une session 
			</a>
		}
		else{
			<a className="control-item active" href = "# ">
			fermer session 
		</a>
		}
		<img  src="img/profil.png" height="70" weight="70" />
		</div>
		<div className= "segmented-control"> 
		<a className="control-item active" href = "# ">
			Partager cette application
		</a>
		 <a class="icon icon-right-nav" href="#"></a>
		
		</div>
		<div className= "segmented-control"> 
		<a className="control-item active" href = "#">
			Laisser un commentaire
		</a>
		 <a class="icon icon-right-nav" href="#"></a>
		
		</div>
		</div>
		)
		}
	});
		return parametters;
});// JavaScript Document
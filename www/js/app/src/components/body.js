/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'components/forms', 'components/liftList'], function($, React, monlift, forms, LiftList){
	
	var SearchForm = forms.SearchForm;
	
	var Body = React.createClass({displayName:'Body', 
		render: function(){
			return (
				<div id="content" className="content">
					<div className="segmented-control">
                		<a className="control-item active" href="#passenger-welcome">
                     		Passenger
               		    </a>
                		<a className="control-item" href="#driver-welcome">
                     		Driver
                		</a>
            		</div>

        			<div className="content2">
            			<div id="welcome">
                			<div id="passenger-welcome" className="control-content active">
                           		<SearchForm />
               				</div>

                			<div id="driver-welcome" className="control-content">
                    			<input type="text" placeholder="From" />
                    			<input type="text" placeholder="To" />
                    			<button className="btn btn-primary btn-block">
                    				<a href="">
                    					Offer a ride 
                    				</a>
                    			</button>
                			</div>
						</div>
            		</div>
					
					<LiftList />
					
				</div>
			)
		}
	});
	
	return Body;
	
});// JavaScript Document
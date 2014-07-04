/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth'], function($, React, monlift, auth){
	 
	 ML = monlift.getInstance();
	 
	 return {
 		
		LoginForm:React.createClass({displayName:'LoginForm',
			
			render: function(){
				return (
					<form id ="singin-form">
                		<input type="text" className="form-control" placeholder="Username" required />
                		<input type="password" className ="form-control" placeholder="Password" required />
                		<label className="checkbox pull-left">
                			<input type="checkbox" value="remember-me" />
                 				Remember me
                		</label>
                		<a href="#" className="pull-right need-help">Need help? </a><span className="clearfix"></span>
                		<button className="btn btn-primary btn-block">Sign in</button>
            		</form> 
				);
			}
		
		}),
		
		RegisterForm: React.createClass({displayName:'RegisterForm', 
			render: function(){
				return (
					<form id="register" className="form-horizontal" method="POST" action="#">
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-user"></i> </span>
									<input type="text" className="input-xlarge" id="fname" name="fname" placeholder="First Name" required/>
								</div>
							</div>
						</div>
						<div className="control-group ">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-user"></i></span>
									<input type="text" className="input-xlarge form-control" name="lname" placeholder="Last Name" required />
								</div>
							</div>
						</div>
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-envelope"></i></span>
									<input type="text" className="input-xlarge" id="email" name="email" placeholder="Email" required />
								</div>
							</div>
						</div>
			
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-lock"></i></span>
									<input type="Password" className="input-xlarge" name="password" required placeholder="Password" />
								</div>
							</div>
						</div>
			
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-lock"></i></span>
									<input type="Password" className="input-xlarge" name="conpasswd" placeholder="Re-enter Password" required />
								</div>
							</div>
						</div>
			
						<div className="control-group">
							<label className="control-label"></label>
							<div className="controls">
								<button className="btn btn-primary btn-block">Create My Account</button>
							</div>
						</div>
	  				</form>

				);
			}
		}),
		
		ToDriverForm: function(){
			
		},
		
		SearchForm : React.createClass({displayName:'SearchForm',
			render: function(){
				return (
					<form id="search-form">
                        <input type="text" name="from-place" placeholder="From" />
                        <input type="text" name="to-place" placeholder="To" />
                        <div className="more-option">
                            <span className="icon icon-caret">
                                more options
                            </span>
                        </div>
                        <button className="btn btn-primary btn-block">
                        	<a href="">
                            	Search
                        	</a>
                        </button>
                    </form>
				);
			}
		
		})
		 
	 }
 	
 })
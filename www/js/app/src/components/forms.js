/** @jsx React.DOM */
define(['jquery', 'react', 'app/monlift', 'app/auth', 'app/event'], function($, React, monlift, auth, EventProvider){
	 
	 ML = monlift.getInstance();
	 
	 return {
 		
		LoginForm:React.createClass({displayName:'LoginForm',
			getInitialState: function() {
    			return {errorMessage: ''};
  			},
			
			validateForm: function(email, password){
				var missing_fields = [];
				
				if(!email)
				{
					missing_fields.push("email");
				}
				if(!password)
				{
					missing_fields.push("password");
				}
				if(missing_fields.length == 0)
					return true;
				if(missing_fileds.length == 1)
					var message = "The value for field \"" + missing_fields[0] +" is missing";  
				else
					var message = "The values for fields \"" + missing_fields.toString() + " are missing";
				this.setState({errorMessage:message});
				return false;
			},
			handleSubmit:function(e){
				e.preventDefault();
				var email = this.refs.email.getDOMNode().value;
				var password  = this.email.getDOMNode().value;
				if(this.validateForm(email, password))
				{
					auth.login(email, password);
				}
				consol.log(ML._session);	
			},
			render: function(){
				return (
					<form id = "singin-form"  className = "forme-horizontal" onSubmit= {this.handleSubmit}>
						<input type="email" class="input-xlarge" id="email" name="email" placeholder="Email" ref = "email" required />
						<input type="password" className ="form-control" placeholder="Password" ref = "password" required />
                		<label className="checkbox pull-left">
                		<input type="checkbox" value="remember-me" />
                 				Remember me
                		</label>
                		<a href="#" className="pull-right need-help">Need help? </a><span className="clearfix"></span>
                		<button className="btn btn-primary btn-block" type = "submit">Sign in</button>
            		</form> 
                		
				);
			}
		
		}),
		
		RegisterForm: React.createClass({displayName:'RegisterForm', 
			
			handleSubmit: function(e){
				e.preventDefault();
				var firstname = this.refs.firstname.getDOMNode().value;
				var lastname = this.refs.lastname.getDOMNode().value;
				var email = this.refs.email.getDOMNode().value;
				var password = this.refs.password.getDOMNode().value;
				var phone = this.refs.phone.getDOMNode().value;
				if(this.validateForm(firstname, lastname, email, password, phone))
				{
					auth.register(firstname, lastname, email, password, phone);
				}
			},
			validateForm: function(firstname, lastname, email, password, phone)
			{
				var missing_values = [];
				if(!firstname)
					missing_values.push("firstname");
				if(!lastname)
					missing_values.push("lastname");
				if(!email)
					misssing_values.push("email");
				if(!password)
					missing_Values.push("password");
				if(!phone)
					missing_values.push("phone");
					
				if(missing_fields.length == 0)
					return true;
				if(missing_fileds.length == 1)
					var message = "The value for field \"" + missing_fields[0] +" is missing";  
				else
					var message = "The values for fields \"" + missing_fields.toString() + " are missing";
				this.setState({errorMessage:message});
				return false;
			},
			registrationFailed: function(message)
			{
				console.log("RegistrationFailed called with message: ");
				console.log(arguments);
				this.setState({errorMessage:message});
			},
			
			getInitialState: function() {
    			return {errorMessage: ''};
  			},
			
			componentWillUnmount: function(){
				console.log("Registration Form will unmount");
				var that = this;
				EventProvider.clear('auth.registerFailed');
			},
			
			componentDidMount: function(){
				console.log("Registration Form did unmount");
				var that = this;
				EventProvider.subscribe('auth.registerFailed', ML.bind(that, 'registrationFailed'));
			},
			render: function(){
				
				return (
					<form id="register" className="form-horizontal" onSubmit={this.handleSubmit}>
						{this.state.errorMessage? <p>{this.state.errorMessage} </p>:''}
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-user"></i> </span>
									<input type="text" className="input-xlarge" id="fname" name="fname" placeholder="First Name" ref="firstname" required/>
								</div>
							</div>
						</div>
						<div className="control-group ">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-user"></i></span>
									<input type="text" className="input-xlarge form-control" name="lname" placeholder="Last Name" ref="lastname" required />
								</div>
							</div>
						</div>
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-envelope"></i></span>
									<input type="email" className="input-xlarge" id="email" name="email" placeholder="Email" ref="email" required />
								</div>
							</div>
						</div>
			
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-lock"></i></span>
									<input type="Password" className="input-xlarge" name="password" ref="password" required placeholder="Password" />
								</div>
							</div>
						</div>
								
						<div className="control-group">
							<div className="controls">
								<div className="input-prepend">
									<span className="add-on"><i className="icon-lock"></i></span>
									<input type="text" className="input-xlarge" name="phone" ref="phone" placeholder="Your phone number" required />
								</div>
							</div>
						</div>
						
						<div className="control-group">
							<label className="control-label"></label>
							<div className="controls">
								<button type="submit" className="btn btn-primary btn-block">Create My Account</button>
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
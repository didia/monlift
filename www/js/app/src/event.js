/** @jsx React.DOM */
define([], function(){
	
	return {
		
        subscribers: function() {
			  
			if (!this._subscribersMap) {
			  this._subscribersMap = {};
			}
			return this._subscribersMap;
		  },
		 
		subscribe: function(name, cb) {
 			var subs = this.subscribers();
			 if (!subs[name]) {
                 subs[name] = [cb];
             } else {
                 subs[name].push(cb);
             }
		  },
		  
		unsubscribe: function(name, cb) {
			var subs = this.subscribers()[name];
			subs.forEach(function(value, key) {
      			if (value == cb) {
        			subs[key] = null;
      			}
    		});
  		},
		
		monitor: function(name, callback) {
			if (!callback()) {
			  var
				ctx = this,
				fn = function() {
				  if (callback.apply(callback, arguments)) {
					ctx.unsubscribe(name, fn);
				  }
				};
		
			  this.subscribe(name, fn);
			}
		},	
  		
		clear: function(name) {
    		delete this.subscribers()[name];
  		},
		
		fire: function() {
    		var
      			args = Array.prototype.slice.call(arguments),
      			name = args.shift();

    			this.subscribers()[name].forEach(function(sub) {
    	  			if (sub) {
        				sub.apply(this, args);
      				}
    			});
  		}
		
	}
	
});// JavaScript Document
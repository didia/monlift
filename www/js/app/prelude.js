/**
* This file contains the ML object. This is where everything about monlift is performed.
* This helps keep monlift separated from other Object and to live to its own spaces.
* This object is inspired from the FB object of the facebook javascript sdk
*
*/

define(function() {


	window.developpement = true;

	if(!window.ML)
	{
		ML = {
			_apiKey:null,
			_session:null,
			_userStatus:'unknow', // 'notConnected' or 'connected'
			_logging: true,
			_domain:{
				api:window.developpement? 'http://localhost:8080/api':'https://monliftca.appspot.com/api'

			},

			/**
		     * Copies things from source into target.
		     *
		     * @param target    {Object}  the target object where things will be copied
		     *                            into
		     * @param source    {Object}  the source object where things will be copied
		     *                            from
		     * @param overwrite {Boolean} indicate if existing items should be
		     *                            overwritten
		     * @param tranform  {function} [Optional], transformation function for
		     *        each item
		     */
		    copy: function(target, source, overwrite, transform) {
		      for (var key in source) {
		        if (overwrite || typeof target[key] === 'undefined') {
		          target[key] = transform ? transform(source[key]) :  source[key];
		        }
		      }
		      return target;
		    },

		    /**
		     * Create a namespaced object.
		     *
		     * @param name {String} full qualified name ('Util.foo', etc.)
		     * @param value {Object} value to set. Default value is {}. [Optional]
		     * @return {Object} The created object
		     */
		    create: function(name, value) {
		      var node = window.ML, 
		      nameParts = name ? name.split('.') : [],
		      c = nameParts.length;
		      for (var i = 0; i < c; i++) {
		        var part = nameParts[i];
		        var nso = node[part];
		        if (!nso) {
		          nso = (value && i + 1 == c) ? value : {};
		          node[part] = nso;
		        }
		        node = nso;
		      }
		      return node;
		    },

		    /**
		     * Copy stuff from one object to the specified namespace that
		     * is ML.<target>.
		     * If the namespace target doesn't exist, it will be created automatically.
		     *
		     * @access private
		     * @param target    {Object|String}  the target object to copy into
		     * @param source    {Object}         the source object to copy from
		     * @param overwrite {Boolean}        indicate if we should overwrite
		     * @return {Object} the *same* target object back
		     */
		    provide: function(target, source, overwrite) {
		      // a string means a dot separated object that gets appended to, or created
		      return ML.copy(
		        typeof target == 'string' ? ML.create(target) : target,
		        source,
		        overwrite
		      );
		    },

		    /**
		     * Logs a message for the developer if logging is on.
		     *
		     * @param args {Object} the thing to log
		     */
		    log: function(args) {
		      if (ML._logging) {
		       if (window.console) {
		          window.console.log(args);
		        }
		      }
		      // fire an event if the event system is available
		      if (ML.Event) {
		        ML.Event.fire('ml.log', args);
		      }
		    },

		}
	}

	return window.ML;

})
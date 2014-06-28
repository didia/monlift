
/**
*Function to init the ML object
*
*/

define(['prelude'], function(){
	
	ML.provide('', 
	{
		/**
		 *
		 * Initialise the Library
		 */
		init:function(options){
			options = ML.copy(options || {}, {
				logging:true
			});
			
		}

	})

	return ML.init ;
})
'use strict';

// Class definition
var KTImageInputDemo = function() {
	// Private functions
	var initDemos = function() {

		var avataAdd = new KTImageInput('avatar-add');
		var avataEdit = new KTImageInput('avatar-edit');

	}

	return {
		// public functions
		init : function() {
			initDemos();
		}
	};
}();

KTUtil.ready(function() {
	KTImageInputDemo.init();
});


/**
 * @Functions for the samplecontainer
 */

/**
 * Public Shindig namespace with samplecontainer object
 */

var sktopensocial = sktopensocial || {};
sktopensocial.group = {};

/**
 * Hide our functions and variables from other javascript
 */



/**
 * Private Variables
 */

// TODO: This is gross, it needs to use the config just like the gadget js does
var socialDataPath = document.location.protocol + "//" + document.location.host
  + "/social/rest/group/";


function sendRequestToServer(url, method, opt_postParams, opt_callback) {
	// TODO: Should re-use the jsoncontainer code somehow
	opt_postParams = opt_postParams || {};

	var makeRequestParams = {
			"CONTENT_TYPE" : "JSON",
			"METHOD" : method,
			"POST_DATA" : opt_postParams};


		url = socialDataPath + url;


	gadgets.io.makeNonProxiedRequest(url,
			function(data) {
		data = data.data;
		if (opt_callback) {
			opt_callback(data);
		}
	},
	makeRequestParams
	);
};



sktopensocial.group.addCategory = function(viewerId, groupName) {
	
	sendRequestToServer(viewerId + "/" + groupName, 'GET', null, 
		function(data) {
			if (!data) {
				alert("Test request has been sent.");
			}
		}
	);

};

sktopensocial.group.deleteCategory = function(viewerId, groupName) {
	sendRequestToServer(viewerId + "/" + groupName, 'DELETE', null,
		function(data) {
			if (!data) {
				alert("Test request has been sent.");
			}
		}
	);
};

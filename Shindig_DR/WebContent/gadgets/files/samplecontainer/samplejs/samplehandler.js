
/**
 * @Functions for the samplecontainer
 */

/**
 * Public Shindig namespace with samplecontainer object
 */

var sktopensocial = sktopensocial || {};
sktopensocial.samplehandler = {};

/**
 * Hide our functions and variables from other javascript
 */

(function(){

  /**
   * Private Variables
  */

  var parentUrl = document.location.href;
  var baseUrl = parentUrl.substring(0, parentUrl.indexOf('samplecontainer.html'));

  // TODO: This is gross, it needs to use the config just like the gadget js does
  var socialDataPath = document.location.protocol + "//" + document.location.host
    + "/social/rest/samplehandler/";

  var gadgetUrlMatches = /[?&]url=((?:[^#&]+|&amp;)+)/.exec(parentUrl);
  var gadgetUrl = (gadgetUrlMatches)
      ? gadgetUrlMatches[1]
      : baseUrl + 'examples/SocialHelloWorld.xml';

  var gadgetUrlCookie = 'sampleContainerGadgetUrl';

  var stateFileUrl = baseUrl + '../sampledata/canonicaldb.json';
  var stateFileUrlCookie = 'sampleContainerStateFileUrl';

  var useCaja;
  var useCache;
  var useDebug;
  var doEvil;
  var gadget;

  var viewerId = "john.doe";
  var ownerId = "john.doe";

  var viewMatches = /[?&]view=((?:[^#&]+|&amp;)+)/.exec(parentUrl);
  var current_view = (viewMatches)
      ? viewMatches[1]
      : "default";

  /**
   * Public Variables
   */

  /**
   * Private Functions
   */

  function generateSecureToken() {
    // TODO: Use a less silly mechanism of mapping a gadget URL to an appid
    var appId = 0;
    for (var i = 0; i < gadgetUrl.length; i++) {
      appId += gadgetUrl.charCodeAt(i);
    }
    var fields = [ownerId, viewerId, appId, "shindig", gadgetUrl, "0", "default"];
    for (var i = 0; i < fields.length; i++) {
      // escape each field individually, for metachars in URL
      fields[i] = escape(fields[i]);
    }
    return fields.join(":");
  }


  function sendRequestToServer(url, method, opt_postParams, opt_callback, opt_excludeSecurityToken) {
	    // TODO: Should re-use the jsoncontainer code somehow
	    opt_postParams = opt_postParams || {};

	    var makeRequestParams = {
	      "CONTENT_TYPE" : "JSON",
	      "METHOD" : method,
	      "POST_DATA" : opt_postParams};

	    if (!opt_excludeSecurityToken) {
	      url = socialDataPath + url + "?st=" + escape(generateSecureToken());
	    }

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
	  
  sktopensocial.samplehandler.dumpStateFile = function() {
    sendRequestToServer('dumpstate', 'GET', null,
      function(data) {
        if (!data) {
          alert("Could not dump the current state.");
        }
      }
    );
  };
  

})();

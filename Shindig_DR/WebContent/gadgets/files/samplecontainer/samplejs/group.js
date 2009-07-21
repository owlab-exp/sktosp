
/**
 * @Functions for the samplecontainer
 */

/**
 * Public Shindig namespace with samplecontainer object
 */


/**
 * Base interface for all activity objects.
 *
 * Private, see opensocial.createActivity() for usage.
 *
 * @param 
 * @private
 * @constructor
 */
opensocial.Group = function() {

};

/**
 * @static
 * @class
 * All of the fields that activities can have.
 *
 * <p>It is only required to set one of TITLE_ID or TITLE. In addition, if you
 * are using any variables in your title or title template,
 * you must set TEMPLATE_PARAMS.</p>
 *
 * <p>Other possible fields to set are: URL, MEDIA_ITEMS, BODY_ID, BODY,
 * EXTERNAL_ID, PRIORITY, STREAM_TITLE, STREAM_URL, STREAM_SOURCE_URL,
 * and STREAM_FAVICON_URL.</p>
 *
 * <p>Containers are only required to use TITLE_ID or TITLE, they may ignore
 * additional parameters.</p>
 *
 *
 * @name 
 */
opensocial.Group.Field = {
  /**
   * @member 
   */
  NAME : 'name',


  /**
   * A string specifying the
   * URL that represents this activity.
   * @member opensocial.Activity.Field
   */
  MEMBERS : 'members'
};




/**
 * Gets an ID that can be permanently associated with this activity.
 *
 * @return {String} The ID
 * @member 
 */
opensocial.Group.getName = function() {
  return this.getField(opensocial.Activity.Field.ID);
};

/**
 * Gets the activity data that's associated with the specified key.
 *
 * @param {String} key The key to get data for;
 *   see the <a href="opensocial.Activity.Field.html">Field</a> class
 * for possible values
 * @param {Map.&lt;opensocial.DataRequest.DataRequestFields, Object&gt;}
 *  opt_params Additional
 *    <a href="opensocial.DataRequest.DataRequestFields.html">params</a>
 *    to pass to the request.
 * @return {String} The data
 * @member opensocial.Activity
 */
opensocial.Activity.prototype.getField = function(key, opt_params) {
  return opensocial.Container.getField(this.fields_, key, opt_params);
};



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
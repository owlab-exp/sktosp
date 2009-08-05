package com.skt.opensocial.common;

import java.util.HashMap;

public class GadgetRegisterTypeMap extends HashMap<String, String> {
	
	public GadgetRegisterTypeMap() {
		super();
		put(GadgetRegisterTypeConstants.SRC, "소스 등록");
		put(GadgetRegisterTypeConstants.URL_MULTI, " 다중 URL 등록");
		put(GadgetRegisterTypeConstants.URL, "URL 등록");
		
		
	}

}

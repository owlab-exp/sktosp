package com.skt.opensocial.common;

import java.util.HashMap;

/**
 * JSP 페이지에 가젯 등록 유형을 나열하기 위한 맵 클래스
 * @author Ernest Lee
 *
 */
public class GadgetRegisterTypeMap extends HashMap<String, String> {
	

	/**
	 * 오브젝트 생성 시, 등록유형들이 맵에 삽입된다.
	 */
	public GadgetRegisterTypeMap() {
		super();
		put(GadgetRegisterTypeConstants.SRC, "소스 등록");
		put(GadgetRegisterTypeConstants.URL_MULTI, " 다중 URL 등록");
		put(GadgetRegisterTypeConstants.URL, "URL 등록");
		
		
	}

}

package com.skt.opensocial.common;

/**
 * 시스템에 사용되는 각종 상수들을 정의하는 변수들이다.
 * @author Ernest Lee
 *
 */
public class SKTOpenSocialSupportConstants {
	/**
	 * 사용자 ID를 세션에 저장하고 질의하기 위한 키값
	 */
	public static final String USER = "USER";
	/**
	 * 로긴하지 않은 사용자를 나타내기 위한 키값
	 */
	public static final String ANONYMOUS = "ANONYMOUS";
	/**
	 * 세션에 가젯 ID를 저장하기 위한 키값
	 */
	public static final String GADGETID = "GADGETID";
	/**
	 * OWNER ID를 세션에 저장하기 위한 키값
	 */
	public static final Object OWNERID = "OWNERID";
	/**
	 * 등록시의 에러를 나타내기 위한 키값
	 */
	public static final Object REGISTRATIONERROR = "REGISTRATIONERROR";
	
	/**
	 * 사용자 ID 중복 에러를 나타내기 위한 키값
	 */
	public static final String USERIDDUPLICATIONERROR = "USERIDDUPLICATIONERROR";
	/**
	 * 사용자 ID의 부재 에러를 나타내기 위한 키값
	 */
	public static final String USERIDABSENCEERROR = "USERIDABSENCEERROR";
	/**
	 * 패스워드 불일치 에러를 나타내기 위한 키값
	 */
	public static final String PASSWORDERROR = "PASSWORDERROR";
	/**
	 * 사용자 이름 없음 에러를 나타내기 위한 키값
	 */
	public static final String USERNAMEABSENCEERROR = "USERNAMEABSENCEERROR";
	/**
	 * 사용자 이메일이 없음 에러를 나타내기 위한 키값
	 */
	public static final String EMAILABSENCEERROR = "EMAILABSENCEERROR";
	
}

package com.skt.opensocial.common;

/**
 * 가젯의 상태를 나타내는 상수들
 * @author Ernest Lee
 *
 */
public class GadgetStatusConstants {
	
	/**
	 * 가젯이 저장되었으나 등록되지 않은 상태
	 */
	public static final String NOT_REGISTERED = "nr";
	/**
	 * 가젯의 등록이 완료된 상태
	 */
	public static final String REGISTERED = "rg";
	/**
	 * 가젯 발행이 요청된 상태
	 */
	public static final String PUBLISH_REQUESTED = "pr";
	/**
	 * 가젯이 발행된 상태
	 */
	public static final String PUBLISHED = "pg";
	/**
	 * 가젯 발행이 거절된 상태
	 */
	public static final String PUBLISH_DENIED = "pd";

}

package com.skt.opensocial.developer;

/**
 * ValidateGadgetXMLAction에서 사용되는 메시지 오브젝트를 만들기 위한 클래스이다
 * @author Ernest Lee
 *
 */
public class ValidationMessage {
	/**
	 * 가젯 XML이 올바른지를 나타내기 위한 프로퍼티
	 */
	private boolean isValid = false;
	/**
	 * 가젯 XML 체크의 결과를 넣기 위한 문자열 프로퍼티
	 */
	private String message;
	/**
	 * 가젯 XML이 올바른지를 질의
	 * @return true 또는 false
	 */
	public boolean isValid() {
		return isValid;
	}
	/**
	 * 가젯 XML이 올바른지 여부를 셋팅
	 * @param isValid
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	/**
	 * 가젯 XML 체크 결과를 가져옴
	 * @return 체크 결과 메시지
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 가젯 XML 체크 결과를 셋팅
	 * @param message 가젯 체크 결과 메시지
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

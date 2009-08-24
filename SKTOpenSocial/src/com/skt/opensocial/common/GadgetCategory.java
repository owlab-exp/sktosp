package com.skt.opensocial.common;

/**
 * 가젯의 분류를 위한 카테고리를 만들 때 사용되는 클래스
 * 하나의 카테고리
 * @author Ernest Lee
 *
 */
public class GadgetCategory {
	/**
	 *  카테고리 ID
	 */
	private String id;
	/**
	 * 카테고리 이름
	 */
	private String name;
	
	/**
	 * 생성자, 카테고리 ID와 이름을 파라미터로 하여 생성한다
	 * @param id 카테고리의 키값
	 * @param name 카테고리 이름
	 */
	public GadgetCategory(String id, String name) {
		this.id  = id;
		this.name = name;
	}
	
	/**
	 * 카테고리 ID를 가져온다
	 * @return 카테고리 ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 카테고리 ID를 셋팅한다
	 * @param id 카테고리 ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 카테고리 이름을 가져온다
	 * @return 카테고리 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 카테고리 이름을 셋팅한다
	 * @param name 카테고리 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}

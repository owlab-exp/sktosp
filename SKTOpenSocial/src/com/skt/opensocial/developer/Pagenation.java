package com.skt.opensocial.developer;

import java.util.List;

/**
 * 웹 페이지에 출력될 목록(테이블)이 큰 경우,
 * 여러 페이지에 나누어 출력하기 위한 인터페이스이다.
 * @author Ernest Lee
 *
 */
public interface Pagenation {
	
	
	/**
	 * 요청된 페이지 숫자를 가져온다
	 * @return current page, used by JSP
	 */
	public int getRequestedPage();
	
	/**
	 * 요청된 페이지 숫자를 셋팅한다
	 * @param requestedPage	set the requested page number, called in JSP
	 */
	public void setRequestedPage(int requestedPage);
	
	/**
	 * 전체 페이지 숫자를 가져온다
	 * @return total number of pages including invisible, called in JSP
	 */
	public int getMaxPage();
	
	/**
	 * 전체 페이지 숫자를 셋팅한다.
	 * @param maxPage set total pages number, usually not called in JSP
	 */
	public void setMaxPage(int maxPage);
	
	/**
	 * 페이지 목록을 가져온다
	 * @return page number list, e.g., 1,2,3,4,5,6, .., called in JSP
	 */
	public List<Integer> getPageList();
	
	/**
	 * 페이지 목록을 셋팅한다.
	 * @param pageList, usually not called in JSP
	 */
	public void setPageList(List<Integer> pageList);

}

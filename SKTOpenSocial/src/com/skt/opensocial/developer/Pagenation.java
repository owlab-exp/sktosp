package com.skt.opensocial.developer;

import java.util.List;

public interface Pagenation {
	
	
	/**
	 * @return current page, used by JSP
	 */
	public int getRequestedPage();
	
	/**
	 * @param requestedPage	set the requested page number, called in JSP
	 */
	public void setRequestedPage(int requestedPage);
	
	/**
	 * @return total number of pages including invisible, called in JSP
	 */
	public int getMaxPage();
	
	/**
	 * @param maxPage set total pages number, usually not called in JSP
	 */
	public void setMaxPage(int maxPage);
	
	/**
	 * @return page number list, e.g., 1,2,3,4,5,6, .., called in JSP
	 */
	public List<Integer> getPageList();
	
	/**
	 * @param pageList, usually not called in JSP
	 */
	public void setPageList(List<Integer> pageList);

}

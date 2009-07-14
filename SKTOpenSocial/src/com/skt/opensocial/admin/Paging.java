package com.skt.opensocial.admin;

import java.util.ArrayList;
import java.util.List;

public class Paging {
	static int pagescale	= 10;
	static int listscale	= 10;
	int currentpage = 1;
	int totalcount	= 0;
	List<Integer> paging;
	int	prepage	= 0;	// 이전 가기
	int postpage	= 0;	// 다음 가기
	int firstresult	= 0;
	static private boolean debug = false; 
	
	public Paging () {
	}	
	public Paging (int pagescale, int listscale) {
		this.pagescale	= pagescale;
		this.listscale	= listscale;
	}	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public List<Integer> getPaging() {
		paging	= new ArrayList<Integer>();
		
		Integer startpage	= this.getStartpage();
		if (debug) System.out.println("startpage" + startpage);
				
		for (Integer pi = startpage; pi < startpage + this.pagescale + 1; pi++)
		{
			paging.add(pi);
			if (debug) System.out.println("pi = " + pi.toString());
			
			if (pi * this.listscale >= this.totalcount) 
			{
				break;
			}
		}
		return paging;
	}
	public void setPaging(List<Integer> paging) {
		this.paging = paging;
	}
	public int getPrepage() {
		Integer startpage	= this.getStartpage();
		if(startpage > 1) {
			this.prepage	= startpage - 1;
		}
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getPostpage() {
		Integer endpage	= this.getStartpage() + this.pagescale - 1 ;
		if(endpage * this.listscale < this.totalcount) {
			this.postpage	= endpage + 1;
		}
		return postpage;
	}
	public void setPostpage(int postpage) {
		this.postpage = postpage;
	}
	public int getFirstresult() {
		this.firstresult	= (this.currentpage - 1) * this.listscale;
		if (debug) System.out.println("getFirstresult" + firstresult);
		
		return firstresult;
	}
	public void setFirstresult(int firstresult) {
		this.firstresult = firstresult;
	}
	public static int getPagescale() {
		return pagescale;
	}
	public static void setPagescale(int pagescale) {
		Paging.pagescale = pagescale;
	}
	public static int getListscale() {
		return listscale;
	}
	public static void setListscale(int listscale) {
		Paging.listscale = listscale;
	}
	private Integer getStartpage() {
		Integer startpage	= (Integer)((this.currentpage - 1) / this.pagescale) * this.pagescale + 1;
		if (debug) System.out.println("startpage" + startpage);
		return startpage;
	}
}

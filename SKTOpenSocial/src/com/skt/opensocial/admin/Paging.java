package com.skt.opensocial.admin;

import java.util.ArrayList;
import java.util.List;

public class Paging {
	int scale	= 5;
	int currentpage = 1;
	int totalcount	= 0;
	List<Integer> paging;
	
	public Paging () {		
	}
	public Paging (int scale) {
		this.scale	= scale;
	}	
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
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
		Integer p	= this.currentpage;
		Integer pi = (p > this.scale/2) ? p - this.scale/2: 1;
		for (pi = pi; pi < this.totalcount/this.scale + 1; pi++)
		{
			paging.add(pi);
			System.out.println("pi = " + pi.toString());

		}
		return paging;
	}
	public void setPaging(List<Integer> paging) {
		this.paging = paging;
	}
}

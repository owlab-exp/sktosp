package com.skt.opensocial.admin;

import java.util.*;

public class DeveloperList {
	
	private List<Developer> developerlist;
	private String developerlistStr;
		
	public String execute() {
		List<Developer> list	= new ArrayList<Developer>();
		
		Developer developer	= new Developer("¿Ã»∆¿Á", "hjlee");
		developer.setEmail("hjlee@andrew.cmu.edu");
		developer.setPhone("011-222-3333");
		developer.setRegDate("2009-05-06");
		developer.setStatus("»∞º∫");

		setDeveloperlist(list);
		setDeveloperlistStr(list.toString());

		return "SUCCESS";
	}

	public List<Developer> getDeveloperlist() {
		return developerlist;
	}

	public void setDeveloperlist(List<Developer> developerlist) {
		this.developerlist = developerlist;
	}

	public String getDeveloperlistStr() {
		return developerlistStr;
	}

	public void setDeveloperlistStr(String gadgetlistStr) {
		this.developerlistStr = gadgetlistStr;
	}


	

}

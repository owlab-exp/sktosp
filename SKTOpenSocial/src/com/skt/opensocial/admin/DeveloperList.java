package com.skt.opensocial.admin;

import java.util.*;

public class DeveloperList {
	
	private List<Developer> developerlist;
	private String developerlistStr;
		
	public String execute() {
		List<Developer> list	= new ArrayList<Developer>();
		
		Developer developer	= new Developer("������", "hjlee");
		developer.setEmail("hjlee@andrew.cmu.edu");
		developer.setPhone("011-222-3333");
		developer.setRegDate("2009-05-06");
		developer.setStatus("Ȱ��");
		list.add(developer);
		
		developer	= new Developer("������", "sjoh");
		developer.setEmail("sejoono@andrew.cmu.edu");
		developer.setPhone("010-555-9999");
		developer.setRegDate("2009-05-06");
		developer.setStatus("��Ȱ��");
		list.add(developer);

		developer	= new Developer("�Ӽ���", "sylim");
		developer.setEmail("seyongl@andrew.cmu.edu");
		developer.setPhone("010-222-1111");
		developer.setRegDate("2009-05-23");
		developer.setStatus("Ȱ��");
		list.add(developer);

		developer	= new Developer("��θ�", "drkim");
		developer.setEmail("durik@andrew.cmu.edu");
		developer.setPhone("010-666-7777");
		developer.setRegDate("2009-02-23");
		developer.setStatus("Ȱ��");
		list.add(developer);

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

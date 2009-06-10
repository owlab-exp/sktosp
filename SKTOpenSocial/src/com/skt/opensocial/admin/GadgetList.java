package com.skt.opensocial.admin;

import java.util.*;

public class GadgetList {
	
	private List<Gadget> gadgetlist;
	private String gadgetlistStr;
		
	public String execute() {
		List<Gadget> list	= new ArrayList<Gadget>();
		
		Gadget gadget	= new Gadget("가젯1", "이훈재");
		gadget.setCreatedDate("2009-06-03");
		gadget.setDesc("이훈재의 가젯입니다.");
		gadget.setNumRegUsers("10");
		gadget.setStatus("발행요청중");
		list.add(gadget);

		gadget	= new Gadget("가젯2", "임성용");
		gadget.setCreatedDate("2009-05-01");
		gadget.setDesc("임성용의 가젯입니다.");
		gadget.setNumRegUsers("13");
		gadget.setStatus("활성");
		list.add(gadget);
		
		gadget	= new Gadget("가젯3", "오세준");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("오세준 가젯입니다.");
		gadget.setNumRegUsers("19");
		gadget.setStatus("비활성");
		list.add(gadget);


		gadget	= new Gadget("가젯4", "김두리");
		gadget.setCreatedDate("2009-01-01");
		gadget.setDesc("김두리의 가젯입니다.");
		gadget.setNumRegUsers("29");
		gadget.setStatus("발행요청중");
		list.add(gadget);

		setGadgetlist(list);
		setGadgetlistStr(list.toString());
				
		return "SUCCESS";
	}

	public List<Gadget> getGadgetlist() {
		return gadgetlist;
	}

	public void setGadgetlist(List<Gadget> gadgetlist) {
		this.gadgetlist = gadgetlist;
	}

	public String getGadgetlistStr() {
		return gadgetlistStr;
	}

	public void setGadgetlistStr(String gadgetlistStr) {
		this.gadgetlistStr = gadgetlistStr;
	}


	

}

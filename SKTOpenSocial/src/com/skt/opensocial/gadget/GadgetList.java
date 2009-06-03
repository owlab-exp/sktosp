package com.skt.opensocial.gadget;

import java.util.*;

public class GadgetList {
	
	private List<Gadget> gadgetlist;
	private String gadgetlistStr;
		
	public String execute() {
		List<Gadget> list	= new ArrayList<Gadget>();
		
		Gadget gadget	= new Gadget("����1", "������");
		gadget.setCreatedDate("2009-06-03");
		gadget.setDesc("�������� �����Դϴ�");
		gadget.setNumRegUsers("10");
		gadget.setStatus("�����û��");
		list.add(gadget);

		gadget	= new Gadget("����2", "�Ӽ���");
		gadget.setCreatedDate("2009-05-01");
		gadget.setDesc("�Ӽ����� �����Դϴ�");
		gadget.setNumRegUsers("13");
		gadget.setStatus("��Ȱ��");
		list.add(gadget);
		
		gadget	= new Gadget("����3", "������");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("�������� �����Դϴ�");
		gadget.setNumRegUsers("19");
		gadget.setStatus("Ȱ��");
		list.add(gadget);


		gadget	= new Gadget("����4", "��θ�");
		gadget.setCreatedDate("2009-01-01");
		gadget.setDesc("��θ��� �����Դϴ�");
		gadget.setNumRegUsers("29");
		gadget.setStatus("�����û��");
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

package com.skt.opensocial.gadget;

public class GadgetDetail {
	
	private Gadget gadget;
		
	public String execute() {
		gadget	= new Gadget("����3", "������");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("�������� �����Դϴ�");
		gadget.setNumRegUsers("19");
		gadget.setStatus("Ȱ��");
		gadget.setImagepath("../images/logo.jpg");

		setGadget(gadget);
				
		return "SUCCESS";
	}

	public Gadget getGadget() {
		return gadget;
	}

	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}



	

}

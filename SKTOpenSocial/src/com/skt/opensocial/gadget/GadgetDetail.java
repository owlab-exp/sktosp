package com.skt.opensocial.gadget;

public class GadgetDetail {
	
	private Gadget gadget;
		
	public String execute() {
		gadget	= new Gadget("가젯3", "오세준");
		gadget.setCreatedDate("2009-03-01");
		gadget.setDesc("오세준의 가젯입니다");
		gadget.setNumRegUsers("19");
		gadget.setStatus("활성");
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

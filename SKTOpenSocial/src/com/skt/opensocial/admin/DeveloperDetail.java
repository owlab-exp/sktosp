package com.skt.opensocial.admin;

public class DeveloperDetail {
	
	private Developer gadget;
		
	public String execute() {
		gadget	= new Developer("∞°¡¨3", "ø¿ºº¡ÿ");
		
		setGadget(gadget);
				
		return "SUCCESS";
	}

	public Developer getGadget() {
		return gadget;
	}

	public void setGadget(Developer gadget) {
		this.gadget = gadget;
	}



	

}

package com.skt.opensocial.admin;

public class DeveloperDetail {
	
	private Developer gadget;
		
	public String execute() {
		Developer developer	= new Developer("오세준", "sjoh");
		developer.setEmail("sejoono@andrew.cmu.edu");
		developer.setPhone("010-555-9999");
		developer.setRegDate("2009-05-06");
		developer.setStatus("활성");
		developer.setAddress("카이스트 ICC");
		developer.setImagepath("../images/logo.jpg");
		
		setGadget(developer);
				
		return "SUCCESS";
	}

	public Developer getGadget() {
		return gadget;
	}

	public void setGadget(Developer gadget) {
		this.gadget = gadget;
	}



	

}

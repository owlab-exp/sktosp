package com.skt.opensocial.persistence;

public class GadgetCategory {
	private String id;
	private String name;
	
	public GadgetCategory(){
		
	}
	public GadgetCategory(String id, String name){
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

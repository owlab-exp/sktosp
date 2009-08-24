package com.skt.opensocial.persistence;

import java.sql.Blob;

public class GadgetIcon implements java.io.Serializable {

	private Long id;
	private String name;
	private String contentType;
	private Blob content;
	private Gadget gadget;
	
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public Gadget getGadget() {
		return gadget;
	}
	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}
	

}

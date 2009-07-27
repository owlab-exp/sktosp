/**
 * 
 */
package com.skt.opensocial.developer;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class RegisterGadgetAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String registerType;// = "source"; //source, url, multiple_url
	private String gagdetId;
	private String gadgetName;
	private String gadgetCategory;
	private String gadgetIntro;
	private String gadgetSource;
	
	private String gadgetStatus;
	
	public String execute(){
		System.out.println(">>>>>>>>>>>>>>>>>>>> registerType=" + registerType);
		if(registerType.equals("source")){
			return "REGISTER_SOURCE";
		} else if(registerType.equals("url")){
			return "REGISTER_URL";
		}else if(registerType.equals("multiple_url")){
			return "REGISTER_MULTIPLE_URL";
		}
		return "REGISTER_SOURCE";
	}
	
	public String getGadgetStatus() {
		return this.gadgetStatus;
	}
	
	public void setGadgetStatus(String gadgetStatus){
		this.gadgetStatus = gadgetStatus;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getGagdetId() {
		return gagdetId;
	}

	public void setGagdetId(String gagdetId) {
		this.gagdetId = gagdetId;
	}

	public String getGadgetName() {
		return gadgetName;
	}

	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}

	public String getGadgetCategory() {
		return gadgetCategory;
	}

	public void setGadgetCategory(String gadgetCategory) {
		this.gadgetCategory = gadgetCategory;
	}

	public String getGadgetIntro() {
		return gadgetIntro;
	}

	public void setGadgetIntro(String gadgetIntro) {
		this.gadgetIntro = gadgetIntro;
	}

	public String getGadgetSource() {
		return gadgetSource;
	}

	public void setGadgetSource(String gadgetSource) {
		this.gadgetSource = gadgetSource;
	}
	
	
	
}

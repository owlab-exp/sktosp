/**
 * 
 */
package com.skt.opensocial.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.skt.opensocial.common.GadgetStatusConstants;

/**
 * @author Ernest Lee
 *
 */
//public class ListGadgetsAction extends ActionSupport implements RequestAware {
public class ListGadgetsAction extends ActionSupport {
	
	//Map<String, Object> request;
	List<GadgetInfoData> gadgets;
	
	public String execute(){
		//ListGadgetInfoData gadgets = new ListGadgetInfoData();
		this.gadgets = new ArrayList<GadgetInfoData>();
		
		// dummy
		for(int i = 0; i < 5; i++) {
			GadgetInfoData gadget = new GadgetInfoData();
			gadget.setGadgetId(i+1000);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISHED);
			gadget.setNumberOfUsers(i+500);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("2009/06/01");
			gadgets.add(gadget);
		}
		for(int i = 0; i < 5; i++) {
			GadgetInfoData gadget = new GadgetInfoData();
			gadget.setGadgetId(i+1000);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.REGISTERED);
			//gadget.setNumberOfUsers(i+500+5);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgets.add(gadget);
		}
		for(int i = 0; i < 3; i++) {
			GadgetInfoData gadget = new GadgetInfoData();
			gadget.setGadgetId(i+1000+9);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISH_REQUESTED);
			//gadget.setNumberOfUsers(i+500+5);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgets.add(gadget);
		}
		for(int i = 0; i < 2; i++) {
			GadgetInfoData gadget = new GadgetInfoData();
			gadget.setGadgetId(i+1000+20);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISH_DENIED);
			//gadget.setNumberOfUsers();
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgets.add(gadget);
		}
		//request.put("gadgetInfoListData", gadgets);

		return Action.SUCCESS;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.RequestAware#setRequest(java.util.Map)
	 */
	/*@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		//this.request = request;

	}*/

	public List<GadgetInfoData> getGadgets() {
		return gadgets;
	}

	public void setGadgets(List<GadgetInfoData> gadgets) {
		this.gadgets = gadgets;
	}

	
}

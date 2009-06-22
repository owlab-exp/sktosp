package com.skt.opensocial.developer;

import java.util.HashMap;

import com.skt.opensocial.common.GadgetStatusConstants;

public class GadgetDataList {
	//private static ArrayList<GadgetInfoData> gadgetInfoList = new ArrayList<GadgetInfoData>();
	private static HashMap<String, GadgetData> gadgetMap= new HashMap<String, GadgetData>();
	
	public GadgetDataList(){
		for(int i = 0; i < 5; i++) {
			GadgetData gadget = new GadgetData();
			gadget.setGadgetId(""+ i+100);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISHED);
			gadget.setNumberOfUsers(i+500);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("2009/06/01");
			gadgetMap.put(gadget.getGadgetId(), gadget);
		}
		for(int i = 0; i < 5; i++) {
			GadgetData gadget = new GadgetData();
			gadget.setGadgetId(""+i+1000);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.REGISTERED);
			//gadget.setNumberOfUsers(i+500+5);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgetMap.put(gadget.getGadgetId(), gadget);
		}
		for(int i = 0; i < 3; i++) {
			GadgetData gadget = new GadgetData();
			gadget.setGadgetId(""+i+1000+9);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISH_REQUESTED);
			//gadget.setNumberOfUsers(i+500+5);
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgetMap.put(gadget.getGadgetId(), gadget);
		}
		for(int i = 0; i < 2; i++) {
			GadgetData gadget = new GadgetData();
			gadget.setGadgetId(""+i+1000+20);
			gadget.setGadgetName("Gadget" + i);
			gadget.setGadgetStatus(GadgetStatusConstants.PUBLISH_DENIED);
			//gadget.setNumberOfUsers();
			gadget.setRegisterDate("2009/05/31");
			gadget.setPublishDate("");
			gadgetMap.put(gadget.getGadgetId(), gadget);
		}
	}
	
	public HashMap<String, GadgetData> getGadgetMap(){
		return gadgetMap;
	}
	
	public void setGadgetMap(HashMap<String, GadgetData> aGadgetMap) {
		gadgetMap = aGadgetMap;
	}
	
	public void addNewGadgetData(String id, GadgetData gadgetData) {
		if(gadgetMap.get(id) == null) {
			gadgetMap.put(id, gadgetData);
		} else {
			System.out.println("Gadget ID already exists.");
		}
	}
	
	public void replaceGadgetData(String id, GadgetData gadgetData) {
		if(gadgetMap.get(id) != null) {
			gadgetMap.put(id, gadgetData);
		} else {
			System.out.println("Gadget ID does not exist.");
		}
	}
	
	public boolean isExistId(String id) {
		return gadgetMap.containsKey(id);
	}
	
	public GadgetData getGadget(String id) {
		return gadgetMap.get(id);
	}
	
	public void removeGadget(String id) {
		gadgetMap.remove(id);
	}
}

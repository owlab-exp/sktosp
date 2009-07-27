package com.skt.opensocial.user;

import java.util.ArrayList;

public class ListGadgetInfoData {
	private ArrayList<GadgetInfoData> gadgetInfoList = new ArrayList<GadgetInfoData>();
	
	public void setGadgetInfoList(ArrayList<GadgetInfoData> gadgetInfoList){
		this.gadgetInfoList = gadgetInfoList;
	}
	
	public ArrayList<GadgetInfoData> getGadgetInfoList(){
		return this.gadgetInfoList;
	}
	
	public void addGadgetInfoData(GadgetInfoData gadgetInfoData){
		this.gadgetInfoList.add(gadgetInfoData);
	}
	
	public boolean removeGadgetInfoData(GadgetInfoData gadgetInfoData){
		return this.gadgetInfoList.remove(gadgetInfoData);
	}

}

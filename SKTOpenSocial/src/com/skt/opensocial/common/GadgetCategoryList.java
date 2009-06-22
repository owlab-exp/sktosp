package com.skt.opensocial.common;

import java.util.ArrayList;

public class GadgetCategoryList extends ArrayList<GadgetCategory>{
	
	public GadgetCategoryList(){
		super();
		add(new GadgetCategory("communication","Communication"));
		add(new GadgetCategory("dating","Dating"));
		add(new GadgetCategory("events","Events"));
		add(new GadgetCategory("finance","Finance"));
		add(new GadgetCategory("food_and_drinks","Food&Drink"));
		add(new GadgetCategory("games_and_fun","Fun&Game"));
		add(new GadgetCategory("lifestyle","Life Style"));
		add(new GadgetCategory("movies_and_tv","Movie&TV"));
		add(new GadgetCategory("music","Music"));
		add(new GadgetCategory("news","News"));
		add(new GadgetCategory("politics","Politics"));
		add(new GadgetCategory("sports","Sports"));
		add(new GadgetCategory("tools","Tools"));
		add(new GadgetCategory("travel","Travel"));
		add(new GadgetCategory("video","Video"));
	}

}

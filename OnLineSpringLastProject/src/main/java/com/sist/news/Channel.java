package com.sist.news;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	private List<Item> item=new ArrayList<>();

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}

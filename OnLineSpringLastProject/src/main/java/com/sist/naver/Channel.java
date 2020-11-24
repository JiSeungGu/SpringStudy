package com.sist.naver;
import java.util.*;
/*
 * 	jaxb => XML => Java	, Java => XML  (xml을 자바로 , 자바를 xml로 파싱) ==> bind
 * 			- 언마샬 		   마샬
 * 	jaxp => dom,sax (파싱방법)
 * 
 */
public class Channel {
	private List<Item> item = new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
}

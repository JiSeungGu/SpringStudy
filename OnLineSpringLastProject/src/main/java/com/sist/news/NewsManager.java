package com.sist.news;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.util.*;
import java.net.*;

import org.springframework.stereotype.Component;

import com.sist.news.*;

@Component
public class NewsManager {
	public List<Item> newsAllData(String fd)
	{
		List<Item> list=new ArrayList<>();
		try{
			String strUrl="newssearch.naver.com/search.naver?where=rss&query="
					+URLEncoder.encode(fd,"UTF-8");
			URL url = new URL(strUrl);
			JAXBContext jb=JAXBContext.newInstance(Rss.class);
			//최상위 태그
			// XML = > java class 화  
			Unmarshaller un = jb.createUnmarshaller();
			// <rss> => Rss
			// <channel> => Channel
			// <title>aa</title> => String title
			Rss rss= (Rss)un.unmarshal(url);
			list = rss.getChannel().getItem();
			
		}catch (Exception e) {}
		return list;
	}
}

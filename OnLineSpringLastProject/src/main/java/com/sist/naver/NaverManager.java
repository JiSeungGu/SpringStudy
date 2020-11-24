package com.sist.naver;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.util.*;
/*
 *  Json 파일은 { 으로 시작하면 object
 *  	[ 으로 시작하면 ARRAY이다
 */
@Component
public class NaverManager {
	public void naverData(String fd) {
		ApiExamSearchBlog api = new ApiExamSearchBlog();
		String json=api.naverFindData(fd);
		System.out.println(json);
		try{
			JSONParser jp = new JSONParser();
			JSONObject root = (JSONObject)jp.parse(json);
			System.out.println(root);
			
			JSONArray arr = (JSONArray)root.get("items"); //items에 데이터가 배열로 잡혀있는상태
			String result="";
			
			for(int i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i);
//				System.out.println(obj.get("description"));
				result+=obj.get("description")+"\r\n";
			}
			result=result.replace("<", "");
			result=result.replace(">", "");
			result=result.replace("/", "");
			result=result.replace("#", "");
			result=result.replace(".", "");
			result=result.replaceAll("[0-9]", "");
			result=result.replaceAll("[A-Za-z]", "");
			
			FileWriter fw = new FileWriter("c:\\upload\\naver.txt");
			fw.write(result);
			fw.close();
		}catch (Exception e) {

		}
		//XML처리방식
		/*
		try{
			JAXBContext jb = JAXBContext.newInstance(Rss.class); //Rss에서부터 값을 채워 나간다
			Unmarshaller un = jb.createUnmarshaller();
			Rss rss= (Rss)un.unmarshal(new File("c:\\upload\\naver.xml"));
			List<Item> list = rss.getChannel().getItem();
			for(Item i:list)
			{
				String s = i .getDescription();
//				s = s.replaceAll("[^가-힣]","");
				
				s = s.replace("<", "");
				s = s.replace(">", "");
				s = s.replace(";", "");
				s = s.replace("#", "");
				s = s.replace("/", "");
				s = s.replaceAll("[0-9]","");
				s = s.replaceAll("[A-Za-z]","");
				System.out.println(s);
			}
		}catch (Exception e) {}
		*/
		
	}
}

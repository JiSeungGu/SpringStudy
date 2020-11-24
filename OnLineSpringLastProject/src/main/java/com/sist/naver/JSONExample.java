package com.sist.naver;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JSONExample {
	
	public static void main(String[] args) {
		
	String json="{\"sawon\":[{\"name\":\"홍길동\",\"sex\":\"남자\",\"age\":30},"
			+ "{\"name\":\"ㅇㅇㅇ\",\"sex\":\"외계인\",\"age\":20},"
			+ "{\"name\":\"ㄹㄹㄹ\",\"sex\":\"여자\",\"age\":10},"
			+ "{\"name\":\"ㄱㄱㄱ\",\"sex\":\"남자\",\"age\":80},"
			+ "{\"name\":\"ㄷㄷㄷ\",\"sex\":\"여자\",\"age\":60}]}";
	try{
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject)jp.parse(json);
		JSONArray arr = (JSONArray)root.get("sawon");
		for(int i=0;i<arr.size();i++)
		{
			JSONObject obj=(JSONObject)arr.get(i);
			System.out.println(obj.get("name"));
			System.out.println(obj.get("sex"));
			System.out.println(obj.get("age"));
			System.out.println("=================");
		}
		
	}catch (Exception e) {}
	
	//=================================================================
	/*
	String json="[{\"name\":\"홍길동\",\"sex\":\"남자\",\"age\":30},"
			+ "{\"name\":\"ㅇㅇㅇ\",\"sex\":\"외계인\",\"age\":20},"
			+ "{\"name\":\"ㄹㄹㄹ\",\"sex\":\"여자\",\"age\":10},"
			+ "{\"name\":\"ㄱㄱㄱ\",\"sex\":\"남자\",\"age\":80},"
			+ "{\"name\":\"ㄷㄷㄷ\",\"sex\":\"여자\",\"age\":60}]";
	try{
		JSONParser jp = new JSONParser();
		JSONArray arr = (JSONArray)jp.parse(json);
		for(int i=0;i<arr.size();i++)
		{
			JSONObject obj=(JSONObject)arr.get(i);
			System.out.println(obj.get("name"));
			System.out.println(obj.get("sex"));
			System.out.println(obj.get("age"));
			System.out.println("=================");
		}
	}catch (Exception e) {}
	//=================================================================
	*/
//	try{
//			JSONParser jp = new JSONParser();
//			JSONObject info = (JSONObject) jp.parse(json);
//			System.out.println(info);
//			JSONObject data = (JSONObject)info.get("info");
//			System.out.println(data.get("name"));
//			System.out.println(data.get("sex"));
//			System.out.println(data.get("age"));
//	}catch (Exception e) {}
	}
}

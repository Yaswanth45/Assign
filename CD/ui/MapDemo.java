package com.cts.CD.ui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		Map<String,String> hm=new HashMap<>();
		hm.put("Java", "Language");
		hm.put("dotnet", "Framework");
		hm.put("C#", "Language");
		for(String key:hm.keySet()) {
			System.out.printf("%s:%s\n",key,hm.get(key));
		}
		System.out.println("--------------------------");
		Map<String,String> hc=new LinkedHashMap<>();
		hc.put("Java", "Language");
		hc.put("dotnet", "Framework");
		hc.put("C#", "Language");
		for(String key:hc.keySet()) {
			System.out.printf("%s:%s\n",key,hc.get(key));
		}
		System.out.println("--------------------------");
		Map<String,String> hb=new TreeMap<>();
		hb.put("Java", "Language");
		hb.put("dotnet", "Framework");
		hb.put("C#", "Language");
		for(String key:hb.keySet()) {
			System.out.printf("%s:%s\n",key,hb.get(key));
		}
	}
}

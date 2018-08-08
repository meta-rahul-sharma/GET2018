/*package com.metacube.json;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.metacube.nestedinteger.NestedList;
import com.metacube.nestedinteger.NestedListException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static java.util.Arrays.asList;

public class JsonNestedList implements NestedList {
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public int sum(Object object) throws NestedListException {
		int sum = 0;
		if(object instanceof Integer) {
			sum = (Integer) object;
		} else if(object instanceof List) {
			for(Object iterator: (List)object) {
				sum += sum(iterator);
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return sum;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int largestValue(Object object) throws NestedListException {
		int largestValue = 0;
		boolean flag = false;
		if(object instanceof Integer) {
			largestValue = (Integer) object;
		} else if(object instanceof List) {
			for(Object iterator: (List)object) {
				if(!flag) {
					largestValue = largestValue(iterator);
					flag = true;
				}
				largestValue = Math.max(largestValue, largestValue(iterator));
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return largestValue;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean search(Object object, int value) throws NestedListException {
		boolean search = false;
		if(object instanceof Integer) {
			System.out.println((Integer) object);
			if((Integer) object == value)
			search = true;
		} else if(object instanceof List) {
			for(Object iterator: (List)object) {
				if(!search && search(iterator, value)) {
					search = true;
				}
			}
		} else {
			throw new NestedListException("Wrong object Type");
		}
		return search;
	}

	public void addToList() throws NestedListException {
        File file = null;
        try {
            file = new File("C:/Users/User3/workspace/GET_2018_ALL/data.json");

            JSONParser parser = new JSONParser();

            JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
            JSONObject object = (JSONObject) obj.get("listData");          
            jsonParse(object);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File address is : " + file);
        }
	}
	
	public List<Object> jsonParse(Object list) {
		List<Object> nestedList = new ArrayList<Object>();
		int index = 0;
		while(index < list.size()) {
			JSONObject object = list.getJSONObject(index);
			if(object instanceof Integer) {
				nestedList.add(((ArrayList) list).get(index));
				System.out.println(((ArrayList) list).get(index));
			} else if(object instanceof List){
				nestedList.add(jsonParse(((ArrayList) list).get(index)));
			}
		}
		return nestedList;
	}
	
	public static void main(String args[]) {
		JsonNestedList object = new JsonNestedList();
		try {
			object.addToList();
		} catch (NestedListException e) {
			e.printStackTrace();
		}
	}

}
*/
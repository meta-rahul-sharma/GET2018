package com.metacube.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.metacube.nestedinteger.NestedListException;

/**
 * To generate data from json file and convert it into nested Integer list
 * @author Rahul Sharma
 * Creation Date: 9/8/2018
 */
public class Json {
	
	/**
	 * Nested List generation from json file
	 * @param fileName
	 * @return Nested List
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws NestedListException
	 */
	public List<Object> generateNestedListFromFile(String fileName)
			throws FileNotFoundException, IOException, ParseException, NestedListException {
		File file = new File(fileName);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
		JSONArray array = (JSONArray) obj.get("listData");
		List<Object> nestedList = parse(array);
		return nestedList;
	}

	/**
	 * json Parser for multilevel nested list parsing
	 * @param array
	 * @return multilevel nested list
	 * @throws NestedListException
	 */
	private List<Object> parse(JSONArray array) throws NestedListException {
		if (array.size() == 0) {
			throw new NestedListException("JSONArray Not Exist");
		}

		List<Object> parse = new ArrayList<Object>();
		for (int i = 0, j = array.size(); i < j; i++) {
			if (array.get(i) instanceof Number) {
				parse.add(Integer.parseInt(array.get(i) + ""));
			//If object is instance of JSONArray again parse it for Number
			} else if (array.get(i) instanceof JSONArray) {
				parse.add(parse((JSONArray) array.get(i)));
			} else {
				throw new NestedListException("Wrong object Type");
			}
		}
		return parse;
	}
}

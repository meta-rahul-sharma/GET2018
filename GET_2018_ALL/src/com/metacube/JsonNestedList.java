package q6_json;

import q5_nestedList.IList;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonNestedList implements IList {
    Node top;

    public JsonNestedList(String fileName) {
        top = null;

        File file = null;
        try {
            String location = "D:/GET_PROJECT_ASSIGNMENT/eclipse/DSA-2/src/q6_json";
            file = new File(location, "/" + fileName);

            JSONParser parser = new JSONParser();

            JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
            JSONArray array = (JSONArray) obj.get("listData");

            for (int i = 0; i < array.size(); i++) {
                Node node = new Node();
                JSONArray intArray = (JSONArray) array.get(i);

                for (int j = 0; j < intArray.size(); j++) {
                    node.list.add(Integer.parseInt(intArray.get(j) + ""));
                }

                node.nextLink = top;
                top = node;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File address is : " + file);
        }
    }

    @Override
    public int sum() {
        int sum = 0;
        Node pointer = top;
        while (pointer != null) {
            for (Integer value : pointer.list) {
                sum += value;
            }
            pointer = pointer.nextLink;
        }
        return sum;
    }

    @Override
    public int largestValue() {
        Integer largest = 0;
        Node pointer = top;
        while (pointer != null) {
            for (Integer value : pointer.list) {
                if (value > largest)
                    largest = value;
            }
            pointer = pointer.nextLink;
        }
        return Integer.parseInt(largest + "");
    }

    @Override
    public boolean search(int element) {
        Node pointer = top;
        while (pointer != null) {
            for (Integer value : pointer.list) {
                if (value == element)
                    return true;
            }
            pointer = pointer.nextLink;
        }
        return false;
    }

}

class Node {
    List<Integer> list;
    Node nextLink;

    public Node() {
        list = new ArrayList<>();
    }
}

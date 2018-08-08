package q6_json;

import static org.junit.Assert.*;
import org.junit.Test;

public class JsonNestedListTest {
    JsonNestedList listOfLists;

    public JsonNestedListTest() {
        listOfLists = new JsonNestedList("data.json");
    }

    @Test
    public void test_LargestValue() {
        assertEquals(12, listOfLists.largestValue());
    }

    @Test
    public void test_Search_IfElementIsFound_ReturnTrue() {
        assertEquals(true, listOfLists.search(4));
        assertEquals(true, listOfLists.search(10));
    }

    @Test
    public void test_Search_IfElementIsNotFound_ReturnFalse() {
        assertEquals(false, listOfLists.search(13));
        assertEquals(false, listOfLists.search(29));
    }

    @Test
    public void test_Sum() {
        assertEquals(76, listOfLists.sum());
    }
}

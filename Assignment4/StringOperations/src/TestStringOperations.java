/**
 * 
 * @author RAHUL SHARMA
 *
 */
public class TestStringOperations {
	public static void main(String args[]){
		StringMethods string = new StringMethods("shakalaka 99, b()m lakalakaa");
		System.out.println(string.isEquals("rahul sharma"));
		System.out.println(string.isEquals("shakalaka 99, b()m lakalakaa"));
		System.out.println(string.reverseString());
		System.out.println(string.viceVersa());
		System.out.println(string.largestWord());
		
	}
}

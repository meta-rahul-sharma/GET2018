
public class Palindrome {
	public static boolean isStringPalindromeUsingStack(String check_palindrome){
		STACK stack = new STACK();
		for(int i=0; i<check_palindrome.length(); i++) {
			stack.push(check_palindrome.charAt(i));
		}
		
		String reverse_string = "";
		while(!stack.isEmpty())
		{
			reverse_string+=stack.pop();
		}
		if(check_palindrome.equals(reverse_string))
			return true;
		else
			return false;
	}
	
	public static boolean isStringPalindromeUsingStackOfLinkedList(final String check_palindrome) {
		StackUsingLinkList stack = new StackUsingLinkList();
		for(int i=0; i<check_palindrome.length(); i++) {
			stack.push(check_palindrome.charAt(i));
		}
		
		String reverse_string = "";
		while(!stack.isEmpty())
		{
			reverse_string+=stack.pop();
		}
		if(check_palindrome.equals(reverse_string))
			return true;
		else
			return false;
	}
}

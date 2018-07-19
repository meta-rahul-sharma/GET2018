/**
 * 
 * @author RahulSharma
 *check of palindrome
 */
public class Palindrome {
	/**
	 * check palindrome using implementation of stackUsingArray
	 * @param checkPalindrome
	 * @return true if palindrome
	 */
	public boolean isStringPalindromeUsingStack(String checkPalindrome){
		Stack stack = new Stack();
		for(int i=0; i<checkPalindrome.length(); i++) {
			stack.push(checkPalindrome.charAt(i));
		}
		
		String reverseString = "";
		while(!stack.isEmpty())
		{
			reverseString+=stack.pop();
		}
		if(checkPalindrome.equals(reverseString))
			return true;
		else
			return false;
	}
	
	/**
	 * check palindrome using implementation of stackUsingLinkList
	 * @param checkPalindrome
	 * @return true if palindrome
	 */
	public boolean isStringPalindromeUsingStackOfLinkedList(String checkPalindrome) {
		StackUsingLinkList stack = new StackUsingLinkList();
		for(int i=0; i<checkPalindrome.length(); i++) {
			stack.push(checkPalindrome.charAt(i));
		}
		
		String reverseString = "";
		while(!stack.isEmpty())
		{
			reverseString+=stack.pop();
		}
		if(checkPalindrome.equals(reverseString))
			return true;
		else
			return false;
	}
}

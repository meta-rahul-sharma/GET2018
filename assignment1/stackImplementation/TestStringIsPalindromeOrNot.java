import java.util.Scanner;
/**
 * 
 * @author RahulSharma
 *testing part of palindrome class and both class implemented
 */
public class TestStringIsPalindromeOrNot {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string to check palindrome");
		String isPalindrome = in.nextLine();
		Palindrome palindrome = new Palindrome();
		if(palindrome.isStringPalindromeUsingStackOfLinkedList(isPalindrome) && 
				palindrome.isStringPalindromeUsingStack(isPalindrome)){//checked by both methods and then return boolean value
			System.out.println("string is palindrome");
		} else {
			System.out.println("string is not palindrome");
		}
		in.close();
	}
}

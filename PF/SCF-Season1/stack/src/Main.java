import java.util.Scanner;
public class Main {
	private static Scanner in;

	public static void main(String args[]) {
		in = new Scanner(System.in);
		System.out.println("Enter string to check palindrome");
		String is_palindrome = in.nextLine();
		if(Palindrome.isStringPalindromeUsingStackOfLinkedList(is_palindrome))
			System.out.println("string is palindrome");
		else
			System.out.println("string is not palindrome");
	}
}

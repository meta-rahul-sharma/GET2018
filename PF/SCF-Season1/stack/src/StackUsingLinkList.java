import java.util.LinkedList;
public class StackUsingLinkList {
	private static int top=-1;
	public static LinkedList<Character> stack_elements = new LinkedList<Character>();
	public void push(final char new_element) {
		top++;
		stack_elements.add(new_element);
		
	}
	
	public char pop() {
		if(top==-1) {
			System.out.println("stack is already empty");
			return 0;
		}
		else {
			top--;
			return stack_elements.removeLast();
		}
	}
	
	public int top() {
		return top;
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		else
			return false;
	}
}
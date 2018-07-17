
public class STACK{
	private static int top=-1;
	private static int max_stack=20;
	public static char[] elements_of_stack= new char[max_stack];
	public void push(final char new_element) {
		if(top<max_stack) {
			System.out.println("stack is already full");
		}
		else {
			elements_of_stack[++top]=new_element;
		}
	}
	
	public char pop() {
		if(top==-1) {
			System.out.println("stack is already empty");
			return 0;
		}
		else {
			return elements_of_stack[top--];
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

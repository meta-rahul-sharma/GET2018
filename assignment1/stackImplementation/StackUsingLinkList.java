import java.util.LinkedList;
/**
 * 
 * @author RahulSharma
 *implementation of stack using link list
 */
public class StackUsingLinkList {
	private int top = -1;
	private LinkedList <Character> stackElements = new LinkedList <Character> ();
	public void push(char newElement) {
		if(top==stackElements.size()) {
			System.out.println("stack is already full");
		}
		else {
			top++;
			stackElements.add(newElement);
		}
	}
	
	public char pop() {
		if(top == -1) {
			System.out.println("stack is already empty");
			return 0;
		}
		else {
			top--;
			return stackElements.removeLast();
		}
	}
	
	public int top() {
		return top;
	}
	
	/**
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty() {
		boolean isStackEmpty;
		if(top == -1){
			isStackEmpty = true;
		} else {
			isStackEmpty = false;
		}
		return isStackEmpty;
	}
}
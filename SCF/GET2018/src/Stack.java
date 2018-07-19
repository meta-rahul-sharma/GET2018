/**
 * 
 * @author RahulSharma
 *implementation of stack using link list
 */
public class Stack{
	private int top = -1;
	private int maxSizeOfStack = 20;
	public char[] stackElements= new char[maxSizeOfStack];
	
	public void push(char newElement) {
		if(top == stackElements.length) {
			System.out.println("stack is already full");
		}
		else {
			stackElements[++top] = newElement;
		}
	}
	
	public char pop() {
		if(top == -1) {
			System.out.println("stack is already empty");
			return 0;
		} else {
			return stackElements[top--];
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

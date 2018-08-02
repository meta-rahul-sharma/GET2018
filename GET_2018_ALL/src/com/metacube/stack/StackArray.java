package GET2018.DSA.DSSession1.Stack;

/**
 * This class describes the implementation of Stack using array.
 * 
 * @author Mohit Sharma
 *
 */
public class StackArray implements Stack {
	int topElement = -1;
	String stackArray[] = new String[5];

	@Override
	public boolean push(String newElement) {
		if (topElement == STACK_SIZE) {
			throw new ArrayIndexOutOfBoundsException(
					"Element can't be Add, Stack is Full");
		}
		topElement++;
		stackArray[topElement] = newElement;
		return true;
	}

	@Override
	public String pop() {
		String deletedItem;
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow");
		}
		deletedItem = stackArray[topElement];
		topElement--;
		return deletedItem;
	}

	@Override
	public boolean isEmpty() {
		return (topElement == -1 ? true : false);
	}

	@Override
	public String top() {
		if (topElement == -1) {
			throw new ArrayIndexOutOfBoundsException("Stack Underflow");
		} else {
			return stackArray[topElement];
		}
	}

}

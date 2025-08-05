import java.util.Stack;

class MinStack {

  private Stack<Integer> mainMinStack;
  private Stack<Integer> minimalMinStack;

  public MinStack() {
    mainMinStack = new Stack<>();
    minimalMinStack = new Stack<>();
  }

  public void push(int val) {
    mainMinStack.push(val);
    if (minimalMinStack.isEmpty()) minimalMinStack.push(val);
    else if (val <= minimalMinStack.peek()) minimalMinStack.push(val);
  }

  public void pop() {
    int poppedELe = mainMinStack.pop();
    if (minimalMinStack.peek() == poppedELe) minimalMinStack.pop();
  }

  public int top() {
    return mainMinStack.peek();
  }

  public int getMin() {
    return minimalMinStack.peek();
  }
}

public class _155_Min_Stack {

  public static void main(String[] args) {
    MinStack mS = new MinStack();
    mS.push(-2);
    mS.push(0);
    mS.push(-3);
    System.out.println(mS.getMin());
    mS.pop();
    System.out.println(mS.getMin());
  }
}

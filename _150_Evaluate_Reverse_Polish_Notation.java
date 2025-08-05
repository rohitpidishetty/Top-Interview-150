import java.util.Stack;

class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> S = new Stack<>();
    int recent = 0;
    int previous = 0;
    for (String o : tokens) {
      switch (o) {
        case "+":
          recent = S.pop();
          previous = S.pop();
          S.push(recent + previous);
          break;
        case "-":
          recent = S.pop();
          previous = S.pop();
          S.push(previous - recent);
          break;
        case "*":
          recent = S.pop();
          previous = S.pop();
          S.push(previous * recent);
          break;
        case "/":
          recent = S.pop();
          previous = S.pop();
          S.push(previous / recent);
          break;
        default:
          S.push(Integer.valueOf(o));
          break;
      }
    }
    return S.peek();
  }
}

public class _150_Evaluate_Reverse_Polish_Notation {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .evalRPN(
          new String[] {
            "10",
            "6",
            "9",
            "3",
            "+",
            "-11",
            "*",
            "/",
            "*",
            "17",
            "+",
            "5",
            "+",
          }
        )
    );
  }
}

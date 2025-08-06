import java.util.Stack;

class Solution {

  public int calculate(String s) {
    int n = s.length();
    int num = 0;
    Stack<Integer> S = new Stack<>();
    int result = 0;
    char prevOperation = '+';
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (Character.isWhitespace(ch)) continue;
      else if (Character.isDigit(ch)) num = (num * 10) + ch - '0';
      else if (ch == '-') {
        result += (prevOperation == '-' ? -num : num);
        prevOperation = '-';
        num = 0;
      } else if (ch == '+') {
        result += (prevOperation == '-' ? -num : num);
        prevOperation = '+';
        num = 0;
      } else if (ch == '(') {
        S.push(result);
        S.push(prevOperation == '-' ? -1 : 1);
        result = 0;
        num = 0;
        prevOperation = '+';
      } else if (ch == ')') {
        // First pop for sign, second pop for previously computed value.
        result += (prevOperation == '-' ? -num : num);
        result *= S.pop();
        result += S.pop();
        num = 0;
      }
    }
    result += (prevOperation == '-' ? -num : num);
    return result;
  }
}

public class _224_Basic_Calculator {

  public static void main(String[] args) {
    System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
  }
}

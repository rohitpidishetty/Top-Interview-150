import java.util.Stack;

class Solution {

  public boolean isValid(String s) {
    Stack<Character> S = new Stack<>();
    int n = s.length();
    int i = 0;
    for (; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '[') S.push(']');
      if (ch == '{') S.push('}');
      if (ch == '(') S.push(')');

      if (ch == ']' || ch == '}' || ch == ')') {
        if (!S.isEmpty() && S.pop() != ch) return false;
      }
    }
    return S.isEmpty();
  }
}

public class _20_Valid_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().isValid("([)]"));
  }
}

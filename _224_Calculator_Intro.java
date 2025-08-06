import java.util.Stack;

class Solution {

  public int calculate(String s) {
    int previouslySeenOperator = 1;
    int n = s.length();

    int num = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '+') {
        num = previouslySeenOperator * num;
        System.out.println(num);
        previouslySeenOperator = 1; // Setting the 'preiouslySeenOperator' to newly seen operators.
        num = 0;
      } else if (ch == '-') {
        num = previouslySeenOperator * num;
        System.out.println(num);
        previouslySeenOperator = -1; // Setting the 'preiouslySeenOperator' to newly seen operators.
        num = 0;
      } else {
        num = (num * 10) + (ch - '0'); // Cumulating the numbers together.
      }
    }
    System.out.println(previouslySeenOperator * num); // Last number
    return 0;
  }
  /**
   * 223+-132+365+-52
   * This equation has been transformed to
   * +------------------------+
   * | 223 | -132 | 365 | -52 |
   * +------------------------+
   */
}

public class _224_Basic_Calculator {

  public static void main(String[] args) {
    System.out.println(new Solution().calculate("223+-132+365+-52"));
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] plusOne(int[] digits) {
    int carryForward = 0;
    Stack<Integer> buffer = new Stack<>();
    int plusOne = 1;
    for (int i = digits.length - 1; i > -1; i--) {
      int res = carryForward + digits[i] + ((plusOne--) == 1 ? 1 : 0);
      carryForward = 0;
      if (res < 10) buffer.push(res);
      else {
        buffer.push(res % 10);
        carryForward = 1;
      }
    }
    if (carryForward == 1) buffer.push(1);
    int[] res = new int[buffer.size()];
    int idx = 0;
    while (!buffer.isEmpty()) res[idx++] = buffer.pop();
    return res;
  }
}

public class _66_Plus_One {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().plusOne(new int[] { 9, 9, 9 }))
    );
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private void solve(
    char[][] dialPad,
    String digits,
    StringBuilder buffer,
    int index,
    int boundary,
    List<String> returnBuffer
  ) {
    if (index >= boundary) {
      returnBuffer.add(buffer.toString());
      return;
    }
    int digit = digits.charAt(index) - 48;
    char[] chars = dialPad[digit - 1];
    for (int i = 0; i < chars.length; i++) {
      buffer.append(chars[i]);
      solve(dialPad, digits, buffer, index + 1, boundary, returnBuffer);
      buffer.deleteCharAt(buffer.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()) return new ArrayList<>();
    char[][] dialPad = {
      {},
      { 'a', 'b', 'c' },
      { 'd', 'e', 'f' },
      { 'g', 'h', 'i' },
      { 'j', 'k', 'l' },
      { 'm', 'n', 'o' },
      { 'p', 'q', 'r', 's' },
      { 't', 'u', 'v' },
      { 'w', 'x', 'y', 'z' },
    };
    int n = digits.length();
    List<String> returnBuffer = new ArrayList<>();
    solve(dialPad, digits, new StringBuilder(), 0, n, returnBuffer);
    return returnBuffer;
  }
}

public class _17_Letter_Combinations_of_a_Phone_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().letterCombinations(""));
  }
}

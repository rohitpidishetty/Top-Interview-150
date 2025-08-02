import java.util.Arrays;

class Solution {

  public String reverseWords(String s) {
    String[] tokens = s.trim().split(" ");
    for (int i = 0; i < tokens.length / 2; i++) {
      String temp = tokens[tokens.length - 1 - i].trim();
      tokens[tokens.length - 1 - i] = tokens[i].trim();
      tokens[i] = temp;
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      if (!tokens[i].isEmpty()) result
        .append(tokens[i])
        .append(i < tokens.length - 1 ? " " : "");
    }
    return result.toString();
  }
}

public class _151_Reverse_Words_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("the sky is blue"));
  }
}

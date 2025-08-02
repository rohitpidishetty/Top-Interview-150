class Solution {

  public String longestCommonPrefix(String[] strs) {
    int minLength = Integer.MAX_VALUE;
    for (String word : strs) minLength = Math.min(word.length(), minLength);
    int i = 0;
    while (i < minLength) {
      boolean lastMatchingChar = false;
      for (int j = 1; j < strs.length; j++) if (
        strs[j].charAt(i) != strs[0].charAt(i)
      ) lastMatchingChar = true;
      if (lastMatchingChar) break;
      i++;
    }
    return strs[0].substring(0, i);
  }
}

public class _14_Longest_Common_Prefix {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .longestCommonPrefix(new String[] { "dog", "racecar", "car" })
    );
  }
}

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    int max = 0;
    int start = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        start = Math.max(start, map.get(ch) + 1);
      }
      max = Math.max(max, i - start + 1);
      map.put(ch, i);
    }
    return max;
  }
}

public class _3_Longest_Substring_Without_Repeating_Characters {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abba"));
  }
}

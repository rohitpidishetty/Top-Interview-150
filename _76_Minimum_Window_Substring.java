import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public String minWindow(String s, String t) {
    Map<Character, Integer> m = new HashMap<>();
    String result = new String();
    int n = t.length();
    for (int idx = 0; idx < n; idx++) {
      char ch = t.charAt(idx);
      m.put(ch, m.getOrDefault(ch, 0) + 1);
    }
    int wordCount = n;
    int starting = 0;
    int minWin = Integer.MAX_VALUE;
    int ending = 0;
    int START = 0;
    int ENDING = 0;
    n = s.length();
    while (ending < n) {
      char ch = s.charAt(ending);
      m.put(ch, m.getOrDefault(ch, 0) - 1);
      if (m.get(ch) >= 0) wordCount--;
      while (wordCount == 0) {
        System.out.println(starting + " " + ending);
        if (ending - starting + 1 < minWin) {
          minWin = ending - starting + 1;
          START = starting;
          ENDING = ending;
        }
        // Shrink the window towards right.
        char offset = s.charAt(starting);
        m.put(offset, m.get(offset) + 1);
        // Pushing out a valid character out of the window.
        if (m.get(offset) > 0) {
          System.out.println(offset);
          wordCount++;
        }
        starting++;
      }
      ending++;
    }
    return s.substring(START, ENDING + 1);
  }
}

public class _76_Minimum_Window_Substring {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }
}

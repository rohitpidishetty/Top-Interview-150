import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.sound.sampled.BooleanControl;

class Solution {

  private Map<String, Boolean> buffer;
  private Map<String, Boolean> memo;

  private boolean solve(String s, int startingIndex, int str_len) {
    if (s.isEmpty()) {
      return true;
    }
    if (memo.get(s) != null) return memo.get(s);
    for (int i = startingIndex; i <= str_len; i++) {
      String consider = s.substring(0, i);
      String remaining = s.substring(i, str_len);
      if (
        buffer.containsKey(consider) && solve(remaining, 0, remaining.length())
      ) {
        memo.put(s, true);
        return true;
      }
    }
    memo.put(s, false);
    return false;
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    buffer = new HashMap<>();
    memo = new HashMap<>();
    for (String word : wordDict) buffer.put(word, false);
    return solve(s, 0, s.length());
  }
}

public class _139_Word_Break {

  public static void main(String[] args) {
    System.out.println(
      new Solution().wordBreak("leetcode", Arrays.asList("leet", "code"))
    );
  }
}

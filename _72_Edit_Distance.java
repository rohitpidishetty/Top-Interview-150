import java.util.HashMap;
import java.util.Map;

class Solution {

  private Map<String, Integer> memo;

  private int solve(String w1, String w2) {
    if (w1.length() == 0) return w2.length();
    if (w2.length() == 0) return w1.length();
    String key = w1 + "-" + w2;
    if (memo.containsKey(key)) return memo.get(key);

    int w1p = w1.length() - 1;
    int w2p = w2.length() - 1;
    String sw1 = w1 + w2.charAt(w2p); // Insert
    String sw2 = w1.substring(0, w1p); // Delete
    String sw3 = sw1.substring(0, w1p) + w2.charAt(w2p); // Replace
    if (w1.charAt(w1p) == w2.charAt(w2p)) {
      int ans = 0;
      ans = solve(
        w1p == 0 ? new String() : w1.substring(0, w1p),
        w2p == 0 ? new String() : w2.substring(0, w2p)
      );
      memo.put(key, ans);
      return ans;
    }

    memo.put(
      key,
      1 + Math.min(Math.min(solve(sw1, w2), solve(sw2, w2)), solve(sw3, w2))
    );
    return memo.get(key);
  }

  public int minDistance(String word1, String word2) {
    memo = new HashMap<>();
    return solve(word1, word2);
  }
}

public class _72_Edit_Distance {

  public static void main(String[] args) {
    System.out.println(new Solution().minDistance("horse", "ros"));
  }
}

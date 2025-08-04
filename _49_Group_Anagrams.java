import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> group = new HashMap<>();
    for (String wrd : strs) {
      char[] tkns = wrd.toCharArray();
      Arrays.sort(tkns);
      String key = new String(tkns);
      if (group.get(key) == null) {
        group.put(key, new ArrayList<>());
      }
      group.get(key).add(wrd);
    }
    return new ArrayList<>(group.values());
  }
}

public class _49_Group_Anagrams {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .groupAnagrams(
          new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }
        )
    );
  }
}

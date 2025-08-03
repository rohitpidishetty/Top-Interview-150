import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  private List<Integer> solve(
    String s,
    Map<String, Integer> freqMap,
    int l,
    int wl,
    int sl,
    int n
  ) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    while (i <= sl - l) {
      Map<String, Integer> f = new HashMap<>(freqMap);
      int sub_string_end = i + l;
      // String subString = s.substring(i, sub_string_end);
      int starting = i;
      // System.out.println(s.substring(i, i + l) + " starting @ " + i);
      int j = starting;
      while (j < sub_string_end) {
        String sub = s.substring(j, j + wl);
        if (!f.containsKey(sub) || f.get(sub) == 0) {
          break;
        }
        f.put(sub, f.get(sub) - 1);
        j += wl;
      }
      if (j == sub_string_end) result.add(starting);

      i++;
    }
    return result;
  }

  public List<Integer> findSubstring(String s, String[] words) {
    int n = words.length;
    int subStringLength = words[0].length() * n;
    Map<String, Integer> freq = new HashMap<>();
    for (String wrd : words) freq.put(wrd, freq.getOrDefault(wrd, 0) + 1);

    return solve(s, freq, subStringLength, subStringLength / n, s.length(), n);
  }
}

public class _30_Substring_with_Concatenation_of_All_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findSubstring("barfoothefoobarman", new String[] { "bar", "foo" })
    );
  }
}

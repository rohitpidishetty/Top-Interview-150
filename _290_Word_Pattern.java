import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean wordPattern(String pattern, String s) {
    String[] tokens = s.split(" ");
    char[] ch_tkns = pattern.toCharArray();

    if (tokens.length != ch_tkns.length) return false;

    Map<Character, String> m1 = new HashMap<>();
    Map<String, Character> m2 = new HashMap<>();

    for (int i = 0; i < tokens.length; i++) {
      if (
        (m1.containsKey(ch_tkns[i]) && !m1.get(ch_tkns[i]).equals(tokens[i])) ||
        (m2.containsKey(tokens[i]) && !m2.get(tokens[i]).equals(ch_tkns[i]))
      ) return false;
      m1.put(ch_tkns[i], tokens[i]);
      m2.put(tokens[i], ch_tkns[i]);
    }
    return true;
  }
}

public class _290_Word_Pattern {

  public static void main(String[] args) {
    System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
  }
}

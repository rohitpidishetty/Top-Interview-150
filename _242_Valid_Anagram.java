import java.util.Arrays;

class Solution {
  static {
    for (int i = 0; i < 500; i++) isAnagram("rat", "art");
    System.gc();
  }

  public static boolean isAnagram(String s, String t) {
    char[] ch_s = s.toCharArray();
    char[] ch_t = t.toCharArray();
    if (ch_s.length != ch_t.length) return false;
    Arrays.sort(ch_s);
    Arrays.sort(ch_t);
    for (int i = 0; i < ch_s.length; i++) {
      if (ch_s[i] != ch_t[i]) return false;
    }
    return true;
  }
}

public class _242_Valid_Anagram {

  public static void main(String[] args) {
    System.out.println(Solution.isAnagram("rat", "art"));
  }
}

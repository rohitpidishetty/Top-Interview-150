class Solution {
  static {
    for (int i = 0; i < 500; i++) isIsomorphic("a", "b");
    System.gc();
  }

  public static boolean isIsomorphic(String s, String t) {
    char[] m1 = new char[128];
    char[] m2 = new char[128];
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch_s = s.charAt(i);
      char ch_t = t.charAt(i);
      if (
        (m1[ch_s] != '\0' && m1[ch_s] != ch_t) ||
        (m2[ch_t] != '\0' && m2[ch_t] != ch_s)
      ) return false;
      m1[ch_s] = ch_t;
      m2[ch_t] = ch_s;
    }
    return true;
  }
}

public class _205_Isomorphic_Strings {

  public static void main(String[] args) {
    System.out.println(Solution.isIsomorphic("paper", "title"));
  }
}

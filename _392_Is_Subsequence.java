class Solution {

  public boolean isSubsequence(String s, String t) {
    int ptr1 = 0;
    int ptr2 = 0;
    int s_len = s.length();
    int t_len = t.length();
    while (ptr1 < t_len) {
      if (t.charAt(ptr1) == s.charAt(ptr2)) {
        ptr1++;
        ptr2++;
        if (ptr2 >= s_len) return true;
      } else ptr1++;
    }
    return ptr2 == s_len;
  }
}

public class _392_Is_Subsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsequence("b", "abc"));
  }
}

class Solution {

  protected boolean isPalindrome(String stream) {
    if (stream.isEmpty()) return false;
    int i = 0, j = stream.length() - 1;
    if (j == 0) return true;
    while (i <= j) {
      if (stream.charAt(i) != stream.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  private String solve(String s) {
    int max = Integer.MIN_VALUE;
    String lps = new String();
    int n = s.length();
    for (int i = 0; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        String ss = s.substring(i, j);
        int len = ss.length();
        if (isPalindrome(ss) && len > max) {
          max = len;
          lps = ss;
        }
      }
    }
    return lps;
  }

  public String longestPalindrome(String s) {
    return solve(s);
  }
}

public class _5_Longest_Palindromic_Substring {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("aacabdkacaa"));
    // System.out.println(new Solution().isPalindrome("aacabdkacaa"));
  }
}

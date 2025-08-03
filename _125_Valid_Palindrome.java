class Solution {

  public boolean isPalindrome(String s) {
    String word = s.toLowerCase().trim();
    int idx = 0;
    StringBuilder newString = new StringBuilder();
    int n = word.length();
    while (idx < n) {
      char ch = word.charAt(idx);
      if ((ch >= 97 && ch <= 122) || (ch >= '0' && ch <= '9')) newString.append(
        ch
      );
      idx++;
    }
    int i = 0;
    int j = newString.length() - 1;
    // System.out.println(newString);
    while (i < j) {
      if (newString.charAt(i) != newString.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }
}

public class _125_Valid_Palindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome("0p"));
  }
}

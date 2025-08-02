class Solution {

  public int lengthOfLastWord(String s) {
    int n = s.length() - 1;
    while (n >= 0 && s.charAt(n) == 32) n--;
    int i = n;
    while (i >= 0 && s.charAt(i) != 32) i--;
    return n - i;
  }
}

public class _58_Length_of_Last_Word {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLastWord(new String("")));
  }
}

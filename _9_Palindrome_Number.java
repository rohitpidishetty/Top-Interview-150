class Solution {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int N = x;
    int newNum = 0;
    while (N > 0) {
      newNum = (newNum * 10) + (N % 10);
      N /= 10;
    }
    return newNum == x;
  }
}

public class _9_Palindrome_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(121));
  }
}

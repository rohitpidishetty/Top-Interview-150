class Solution {

  public int trailingZeroes(int n) {
    int zeros = 0;
    while ((n % 5 )== 0) {
      zeros++;
      n /= 5;
    }
    return zeros;
  }
}

public class _172_Factorial_Trailing_Zeroes {

  public static void main(String[] args) {
    System.out.println(new Solution().trailingZeroes(453));
  }
}

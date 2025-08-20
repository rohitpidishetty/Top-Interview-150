import java.util.Arrays;

class Solution {

  private int[] dp;

  private int solve(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (dp[n] != -1) return dp[n];
    int n1 = solve(n - 1) + solve(n - 2);
    dp[n] = n1;
    return n1;
  }

  public int climbStairs(int n) {
    dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return solve(n);
  }
}

public class _70_Climbing_Stairs {

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(3));
  }
}

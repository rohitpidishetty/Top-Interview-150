import java.util.Arrays;

class Solution {

  private int[] memo;

  private int solve(int amount, int[] coins) {
    if (amount < 0) return Integer.MAX_VALUE;
    if (amount == 0) return 0;
    if (memo[amount] != -1) return memo[amount];
    int depth = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = solve(amount - coin, coins);
      if (res != Integer.MAX_VALUE) depth = Math.min(depth, 1 + res);
    }
    memo[amount] = depth;
    return depth;
  }

  public int coinChange(int[] coins, int amount) {
    memo = new int[amount + 1];
    Arrays.fill(memo, -1);
    int res = solve(amount, coins);
    return res != Integer.MAX_VALUE ? res : -1;
  }
}

public class _322_Coin_Change {

  public static void main(String[] args) {
    System.out.println(new Solution().coinChange(new int[] { 1, 2, 5 }, 11));
  }
}

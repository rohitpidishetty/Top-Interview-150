import java.util.ArrayList;

class Solution {

  private Integer[][][] memo;

  private int solve(int s, int[] prices, int T, int state, Integer[][][] memo) {
    if (s > prices.length - 1 || T == 0) return 0;
    if (memo[s][T][state] != null) return memo[s][T][state];

    // skip
    int skip = solve(s + 1, prices, T, state, memo);

    // buy
    if (state == 1) {
      int take = -prices[s] + solve(s + 1, prices, T, 0, memo);
      memo[s][T][state] = Math.max(take, skip);
      return memo[s][T][state];
    }
    // sell
    else {
      int sell = prices[s] + solve(s + 1, prices, T - 1, 1, memo);
      memo[s][T][state] = Math.max(sell, skip);
      return memo[s][T][state];
    }
  }

  public int maxProfit(int[] prices) {
    int T = 2; // Number of transactions
    int state = 1; // buy & 0 sell
    memo = new Integer[prices.length][3][2];
    return solve(0, prices, T, state, memo);
  }
}

public class _123_Best_Time_to_Buy_and_Sell_Stock_III {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 })
    );
  }
}

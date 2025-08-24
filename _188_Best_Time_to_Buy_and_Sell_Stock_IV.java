class Solution {

  private Integer[][][] memo;

  private int solve(int k, int[] prices, int state, int idx) {
    if (k == 0 || idx > prices.length - 1) return 0;
    if (memo[idx][state][k] != null) return memo[idx][state][k];
    int skip = solve(k, prices, state, idx + 1);
    int profit = 0;
    // Buy
    if (state == 1) {
      int buy = -prices[idx] + solve(k, prices, 0, idx + 1);
      profit = Math.max(buy, skip);
    }
    // Sell
    else {
      int sell = prices[idx] + solve(k - 1, prices, 1, idx + 1);
      profit = Math.max(sell, skip);
    }
    memo[idx][state][k] = profit;
    return profit;
  }

  public int maxProfit(int k, int[] prices) {
    memo = new Integer[prices.length][3][k + 1];
    int state = 1;
    return solve(k, prices, state, 0);
  }
}

public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 })
    );
  }
}

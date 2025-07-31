class Solution {

  public int maxProfit(int[] prices) {
    int p2 = prices.length - 1;
    int p1 = prices.length - 1;
    int profit = 0;
    while (p1 > 0 && p2 > 0) {
      while (p2 > 1 && prices[p2] < prices[p2 - 1]) p2--;
      p1 = p2 - 1;
      while (p1 > 1 && prices[p1] > prices[p1 - 1]) p1--;
      if (prices[p2] > prices[p1]) profit += prices[p2] - prices[p1];
      p2 = p1;
    }
    return profit;
  }
}

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] { 1, 2, 3, 4, 5 }));
  }
}

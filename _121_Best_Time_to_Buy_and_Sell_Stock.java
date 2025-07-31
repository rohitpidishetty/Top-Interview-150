import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

  public int maxProfit(int[] prices) {
    /**
     * Lets make use of Monotonic stack to solve this problem.
     */
    Stack<Integer> bestBuy = new Stack<>();
    Stack<Integer> bestSell = new Stack<>();
    int n = prices.length;
    int[] bestBuyOn = new int[n];
    int[] bestSellOn = new int[n];
    for (int i = 0; i < n; i++) {
      while (!bestBuy.isEmpty() && prices[i] < bestBuy.peek()) bestBuy.pop();
      if (bestBuy.isEmpty() || prices[i] < bestBuy.peek()) bestBuy.push(
        prices[i]
      );
      bestBuyOn[i] = bestBuy.isEmpty() ? prices[0] : bestBuy.peek();
    }

    for (int i = n - 1; i >= 0; i--) {
      while (!bestSell.isEmpty() && prices[i] > bestSell.peek()) bestSell.pop();
      if (bestSell.isEmpty() || prices[i] > bestSell.peek()) bestSell.push(
        prices[i]
      );
      bestSellOn[i] = bestSell.isEmpty() ? prices[n - 1] : bestSell.peek();
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) max = Math.max(
      bestSellOn[i] - bestBuyOn[i],
      max
    );
    return max;
  }
}

public class _121_Best_Time_to_Buy_and_Sell_Stock {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] { 7, 6, 4, 3, 1 }));
  }
}

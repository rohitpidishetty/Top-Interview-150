import java.util.Arrays;
import java.util.List;

class Solution {

  // Top-down DP
  // private int[][] memo;

  // private int solve(List<List<Integer>> triangle, int col, int row, int limit) {
  //   if (memo[row][col] != -1) return memo[row][col];
  //   if (row == limit - 1) return triangle.get(row).get(col);
  //   int ret =
  //     triangle.get(row).get(col) +
  //     Math.min(
  //       solve(triangle, col, row + 1, limit),
  //       solve(triangle, col + 1, row + 1, limit)
  //     );
  //   memo[row][col] = ret;
  //   return ret;
  // }

  // public int minimumTotal(List<List<Integer>> triangle) {
  //   int row = 0;
  //   int col = 0;
  //   int n = triangle.size();
  //   memo = new int[n][n];
  //   for (int[] mem : memo) Arrays.fill(mem, -1);
  //   return solve(triangle, col, row, n);
  // }

  // Bottom-up DP
  public int minimumTotal(List<List<Integer>> triangle) {
    int mag = triangle.size();
    int dp[][] = new int[mag][mag];
    List<Integer> m = triangle.get(mag - 1);
    int M = m.size();
    for (int j = 0; j < M; j++) dp[mag - 1][j] = m.get(j);

    for (int n = mag - 2; n >= 0; n--) {
      int x = triangle.get(n).size();
      for (int j = 0; j < x; j++) dp[n][j] =
        triangle.get(n).get(j) + Math.min(dp[n + 1][j], dp[n + 1][j + 1]);
    }
    return dp[0][0];
  }
}

public class _120_Triangle {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minimumTotal(
          Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
          )
        )
    );
  }
}

import java.util.Arrays;

class Solution {

  public int minPathSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] dp = new int[n][m];
    dp[0][0] = grid[0][0];
    for (int j = 1; j < m; j++) dp[0][j] = grid[0][j] + dp[0][j - 1];
    for (int i = 1; i < n; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
    for (int i = 1; i < n; i++) for (int j = 1; j < m; j++) dp[i][j] =
      grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
    return dp[n - 1][m - 1];
  }
}

public class _64_Minimum_Path_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } })
    );
  }
}

import java.util.Arrays;

class Solution {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    int[][] dp = new int[n][m];

    dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

    for (int j = 1; j < m; j++) dp[0][j] = obstacleGrid[0][j] == 1
      ? 0
      : dp[0][j - 1];
    for (int i = 1; i < n; i++) dp[i][0] = obstacleGrid[i][0] == 1
      ? 0
      : dp[i - 1][0];

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[n - 1][m - 1];
  }
}

public class _63_Unique_Paths_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } })
    );
  }
}

class Solution {

  public int maximalSquare(char[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) dp[i][j] = 1;
          else dp[i][j] =
            Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) +
            1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max * max;
  }
}

public class _221_Maximal_Square {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maximalSquare(
          new char[][] {
            { '1', '0', '1', '0', '0' },
            { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' },
            { '1', '0', '0', '1', '0' },
          }
        )
    );
  }
}

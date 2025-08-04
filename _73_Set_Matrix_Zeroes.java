class Solution {

  public void setZeroes(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    boolean[] zero_row = new boolean[n];
    boolean[] zero_col = new boolean[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          zero_row[i] = true;
          zero_col[j] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (zero_col[j] == true || zero_row[i] == true) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}

public class _73_Set_Matrix_Zeroes {

  public static void main(String[] args) {
    new Solution()
      .setZeroes(
        new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } }
      );
  }
}

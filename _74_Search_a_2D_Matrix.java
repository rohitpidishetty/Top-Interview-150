class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int row_start = 0;
    int col_len = matrix[0].length - 1;
    int row_end = matrix.length - 1;
    while (row_start <= row_end) {
      int mid_row = (row_start + row_end) / 2;
      if (matrix[mid_row][0] == target) return true;
      else if (matrix[mid_row][0] > target) row_end = mid_row - 1;
      else if (
        matrix[mid_row][0] < target && matrix[mid_row][col_len] < target
      ) row_start = mid_row + 1;
      else {
        int i = 0;
        int j = col_len;
        while (i <= j) {
          int mid = (i + j) / 2;
          if (matrix[mid_row][mid] == target) return true;
          else if (matrix[mid_row][mid] > target) j = mid - 1;
          else if (matrix[mid_row][mid] < target) i = mid + 1;
        }

        return false;
      }
    }
    return false;
  }
}

public class _74_Search_a_2D_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .searchMatrix(
          new int[][] {
            { 1, 3, 5, 7 },
            { 10, 11, 16, 20 },
            { 23, 30, 34, 60 },
          },
          2
        )
    );
  }
}

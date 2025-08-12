// import java.util.Arrays;

// class Solution {

//   private boolean isNorthSafe(int i, int j, char[][] board) {
//     for (int row = i; row > -1; row--) if (board[row][j] == 'q') return false;
//     return true;
//   }

//   private boolean isTopRightDiagonalSafe(int i, int j, char[][] board) {
//     while (i >= 0 && j < board.length) {
//       if (board[i][j] == 'q') return false;
//       i--;
//       j++;
//     }
//     return true;
//   }

//   private boolean isTopLeftDiagonalSafe(int i, int j, char[][] board) {
//     while (i > -1 && j > -1) {
//       if (board[i][j] == 'q') return false;
//       i--;
//       j--;
//     }
//     return true;
//   }

//   private boolean placeable(int i, int j, char[][] board) {
//     return (
//       isNorthSafe(i, j, board) &&
//       isTopLeftDiagonalSafe(i, j, board) &&
//       isTopRightDiagonalSafe(i, j, board)
//     );
//   }

//   private boolean solve(int row, char[][] board) {
//     if (row >= board.length) return true;
//     int col = 0;
//     for (; col < board.length; col++) {
//       if (placeable(row, col, board)) {
//         board[row][col] = 'q';
//         if (solve(row + 1, board)) return true;
//         board[row][col] = '\0';
//       }
//     }
//     return false;
//   }

//   public int totalNQueens(int n) {
//     char[][] board;
//     int count = 0;
//     board = new char[n][n];
//     for (char[] brd : board) Arrays.fill(brd, '\0');
//     if (solve(0, board)) {
//       System.out.println(Arrays.deepToString(board));
//     }

//     return count;
//   }
// }

// public class _52_N_Queens_II {

//   public static void main(String[] args) {
//     System.out.println(new Solution().totalNQueens(4));
//   }
// }

import java.util.Arrays;

class Solution {

  private boolean isNorthSafe(int i, int j, char[][] board) {
    for (int row = i; row >= 0; row--) if (board[row][j] == 'Q') return false;
    return true;
  }

  private boolean isTopRightDiagonalSafe(int i, int j, char[][] board) {
    for (
      int row = i, col = j;
      row >= 0 && col < board.length;
      row--, col++
    ) if (board[row][col] == 'Q') return false;
    return true;
  }

  private boolean isTopLeftDiagonalSafe(int i, int j, char[][] board) {
    for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) if (
      board[row][col] == 'Q'
    ) return false;
    return true;
  }

  private boolean placeable(int i, int j, char[][] board) {
    return (
      isNorthSafe(i, j, board) &&
      isTopLeftDiagonalSafe(i, j, board) &&
      isTopRightDiagonalSafe(i, j, board)
    );
  }

  private int solve(int row, char[][] board) {
    if (row == board.length) return 1;
    int count = 0;
    for (int col = 0; col < board.length; col++) {
      if (placeable(row, col, board)) {
        board[row][col] = 'Q';
        count += solve(row + 1, board);
        board[row][col] = '.';
      }
    }
    return count;
  }

  public int totalNQueens(int n) {
    char[][] board = new char[n][n];
    for (char[] row : board) Arrays.fill(row, '.');
    return solve(0, board);
  }
}

public class _52_N_Queens_II {

  public static void main(String[] args) {
    System.out.println(new Solution().totalNQueens(4));
  }
}

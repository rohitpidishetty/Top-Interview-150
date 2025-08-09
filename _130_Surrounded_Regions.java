import java.util.Arrays;

class Solution {

  protected void spread(int i, int j, char[][] board) {
    if (
      i < 0 ||
      i > board.length - 1 ||
      j < 0 ||
      j > board[0].length - 1 ||
      board[i][j] == 'A' ||
      board[i][j] == 'X'
    ) return;
    board[i][j] = 'A';
    spread(i - 1, j, board);
    spread(i + 1, j, board);
    spread(i, j + 1, board);
    spread(i, j - 1, board);
  }

  public void solve(char[][] board) {
    if (board == null || board[0].length == 1) return;
    int n = board.length - 1;
    int m = board[0].length - 1;
    for (int j = 0; j <= m; j++) {
      if (board[0][j] == 'O') spread(0, j, board);
    }
    for (int j = 0; j <= m; j++) {
      if (board[n][j] == 'O') spread(n, j, board);
    }
    for (int i = 0; i <= n; i++) {
      if (board[i][0] == 'O') spread(i, 0, board);
    }
    for (int i = 0; i <= n; i++) {
      if (board[i][m] == 'O') spread(i, m, board);
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) if (board[i][j] == 'O') board[i][j] = 'X';
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) if (board[i][j] == 'A') board[i][j] = 'O';
    }
    // System.out.println(Arrays.deepToString(board));
  }
}

public class _130_Surrounded_Regions {

  public static void main(String[] args) {
    char[][] board = {
      { 'X', 'X', 'X', 'X' },
      { 'X', 'O', 'O', 'X' },
      { 'X', 'X', 'O', 'X' },
      { 'X', 'O', 'X', 'X' },
    };

    new Solution().solve(board);
  }
}

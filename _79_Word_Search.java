class Solution {

  private boolean solve(int i, int j, char[][] board, String word, int idx) {
    if (idx == word.length()) return true;
    if (
      i > board.length - 1 ||
      j > board[0].length - 1 ||
      i < 0 ||
      j < 0 ||
      board[i][j] == '*' ||
      board[i][j] != word.charAt(idx)
    ) return false;
    char save = board[i][j];

    board[i][j] = '*';
    boolean r1 = solve(i - 1, j, board, word, idx + 1);
    boolean r2 = solve(i + 1, j, board, word, idx + 1);
    boolean r3 = solve(i, j - 1, board, word, idx + 1);
    boolean r4 = solve(i, j + 1, board, word, idx + 1);
    board[i][j] = save;

    return r1 || r2 || r3 || r4;
  }

  private boolean search(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (solve(i, j, board, word, 0)) return true;
      }
    }
    return false;
  }

  public boolean exist(char[][] board, String word) {
    return search(board, word);
  }
}

public class _79_Word_Search {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .exist(
          new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' },
          },
          "CCEE"
        )
    );
  }
}

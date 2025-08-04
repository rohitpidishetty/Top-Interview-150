import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public boolean isValidSudoku(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    // Row scanning
    for (int i = 0; i < n; i++) {
      List<Character> s = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '.') continue;
        if (s.contains(board[i][j])) return false;
        else s.add(board[i][j]);
      }
    }

    // Col scanning
    for (int j = 0; j < n; j++) {
      List<Character> s = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        if (board[i][j] == '.') continue;
        if (s.contains(board[i][j])) return false;
        else s.add(board[i][j]);
      }
    }

    // Grid scanning
    Map<String, List<Character>> grid = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '.') continue;
        String grid_id = (i / 3) + "," + (j / 3);
        if (grid.get(grid_id) == null) grid.put(grid_id, new ArrayList<>());
        if (grid.get(grid_id).contains(board[i][j])) return false;
        grid.get(grid_id).add(board[i][j]);
      }
    }
    return true;
  }
}

public class _36_Valid_Sudoku {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isValidSudoku(
          new char[][] {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '.', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '2', '7', '9' },
          }
        )
    );
  }
}

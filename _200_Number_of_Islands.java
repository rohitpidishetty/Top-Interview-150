class Solution {

  private int islands;

  private void spread(int i, int j, char[][] grid) {
    if (
      i < 0 ||
      i > grid.length - 1 ||
      j < 0 ||
      j > grid[0].length - 1 ||
      grid[i][j] == '0'
    ) return;
    grid[i][j] = '0';
    spread(i - 1, j, grid);
    spread(i + 1, j, grid);
    spread(i, j + 1, grid);
    spread(i, j - 1, grid);
  }

  public int numIslands(char[][] grid) {
    if(grid == null) return 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          islands++;
          spread(i, j, grid);
        }
      }
    }
    return islands;
  }
}

public class _200_Number_of_Islands {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .numIslands(
          new char[][] {
            { '1', '1', '0', '0', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' },
          }
        )
    );
  }
}

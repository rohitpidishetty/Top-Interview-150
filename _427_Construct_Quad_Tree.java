class Node {

  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {
    this.val = false;
    this.isLeaf = false;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(boolean val, boolean isLeaf) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = null;
    this.topRight = null;
    this.bottomLeft = null;
    this.bottomRight = null;
  }

  public Node(
    boolean val,
    boolean isLeaf,
    Node topLeft,
    Node topRight,
    Node bottomLeft,
    Node bottomRight
  ) {
    this.val = val;
    this.isLeaf = isLeaf;
    this.topLeft = topLeft;
    this.topRight = topRight;
    this.bottomLeft = bottomLeft;
    this.bottomRight = bottomRight;
  }
}

class Solution {

  private Node solve(int row, int col, int mag, int[][] grid) {
    if (mag == 1) 
      return new Node(grid[row][col] == 1, true);
    
    int sample = grid[row][col];
    int count = 0;
    for (int i = row; i < row + mag; i++) {
      for (int j = col; j < col + mag; j++) if (grid[i][j] == sample) count++;
    }
    if (mag * mag == count) return new Node(sample == 1, true);

    Node Q = new Node(false, false);
    int lim = mag / 2;
    Q.topLeft = solve(row, col, lim, grid);
    Q.topRight = solve(row, col + lim, lim, grid);
    Q.bottomLeft = solve(row + lim, col, lim, grid);
    Q.bottomRight = solve(row + lim, col + lim, lim, grid);
    return Q;
  }

  public Node construct(int[][] grid) {
    int row = 0;
    int col = 0;
    int mag = grid.length;
    return solve(row, col, mag, grid);
  }
}

public class _427_Construct_Quad_Tree {

  public static void main(String[] args) {
    Node x = new Solution()
      .construct(
        new int[][] {
          { 1, 1, 1, 1, 0, 0, 0, 0 },
          { 1, 1, 1, 1, 0, 0, 0, 0 },
          { 1, 1, 1, 1, 1, 1, 1, 1 },
          { 1, 1, 1, 1, 1, 1, 1, 1 },
          { 1, 1, 1, 1, 0, 0, 0, 0 },
          { 1, 1, 1, 1, 0, 0, 0, 0 },
          { 1, 1, 1, 1, 0, 0, 0, 0 },
          { 1, 1, 1, 1, 0, 0, 0, 0 },
        }
      );
    System.out.println(x);
    System.out.println(x.topLeft.isLeaf);
  }
}

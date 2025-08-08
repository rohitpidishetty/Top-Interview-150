import java.util.ArrayList;
import java.util.List;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  private int SUM;

  private void solve(TreeNode r, int n) {
    if (r == null) return;
    if (r.left == null && r.right == null) {
      n = (n * 10) + r.val;
      SUM += n;
      return;
    }
    n = (n * 10) + r.val;
    solve(r.left, n);
    solve(r.right, n);
  }

  public int sumNumbers(TreeNode root) {
    if (root == null) return 0;
    SUM = 0;
    solve(root, 0);
    return SUM;
  }
}

public class _129_Sum_Root_to_Leaf_Numbers {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .sumNumbers(
          new TreeNode(
            4,
            new TreeNode(
              9,
              new TreeNode(5, null, null),
              new TreeNode(1, null, null)
            ),
            new TreeNode(0, null, null)
          )
        )
    );
  }
}

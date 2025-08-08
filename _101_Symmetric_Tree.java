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

  private boolean solve(TreeNode l, TreeNode r) {
    if ((l == null && r != null) || (l != null && r == null)) return false;
    if (l == null && r == null) return true;
    if ((l != null && r != null) && l.val != r.val) return false;
    return (
      solve(l == null ? null : l.left, r == null ? null : r.right) &&
      solve(l == null ? null : l.right, r == null ? null : r.left)
    );
  }

  public boolean isSymmetric(TreeNode root) {
    return solve(root.left, root.right);
  }
}

public class _101_Symmetric_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isSymmetric(
          new TreeNode(
            1,
            new TreeNode(
              2,
              new TreeNode(3, null, null),
              new TreeNode(4, null, null)
            ),
            new TreeNode(
              2,
              new TreeNode(4, null, null),
              new TreeNode(3, null, null)
            )
          )
        )
    );
  }
}

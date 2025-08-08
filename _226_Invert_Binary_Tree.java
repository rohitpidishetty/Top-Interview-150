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

  private TreeNode solve(TreeNode r) {
    if (r == null) return null;
    if (r.left == null && r.right == null) return r;

    TreeNode L = solve(r.left);
    TreeNode R = solve(r.right);
    r.left = R;
    r.right = L;
    return r;
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    return solve(root);
  }
}

public class _226_Invert_Binary_Tree {

  public static void main(String[] args) {
    new Solution()
      .invertTree(
        new TreeNode(
          4,
          new TreeNode(
            2,
            new TreeNode(1, null, null),
            new TreeNode(3, null, null)
          ),
          new TreeNode(
            7,
            new TreeNode(6, null, null),
            new TreeNode(9, null, null)
          )
        )
      );
  }
}

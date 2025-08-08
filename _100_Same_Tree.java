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

  private boolean solve(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if ((a == null && b != null) || (a != null && b == null)) return false;
    if (a.val != b.val) return false;
    return solve(a.left, b.left) && solve(a.right, b.right);
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    return solve(p, q);
  }
}

public class _100_Same_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isSameTree(
          new TreeNode(
            1,
            new TreeNode(2, null, null),
            new TreeNode(3, null, null)
          ),
          new TreeNode(
            1,
            new TreeNode(2, null, null),
            new TreeNode(3, null, null)
          )
        )
    );
  }
}

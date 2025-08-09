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

  private boolean solve(TreeNode r, long upperBound, long lowerBound) {
    if (r == null) return true;
    if (lowerBound >= r.val || r.val >= upperBound) return false;
    // System.out.println(upperBound + " > " + r.val + " > " + lowerBound);
    return (
      solve(r.left, r.val, lowerBound) && solve(r.right, upperBound, r.val)
    );
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return solve(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }
}

public class _98_Validate_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isValidBST(
          new TreeNode(
            5,
            new TreeNode(1),
            new TreeNode(4, new TreeNode(3), new TreeNode(6))
          )
        )
    );
  }
}

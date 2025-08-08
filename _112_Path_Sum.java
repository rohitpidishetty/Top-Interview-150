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

  private boolean solve(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (
      root.left == null && root.right == null && root.val - targetSum == 0
    ) return true;
    return (
      solve(root.left, targetSum - root.val) ||
      solve(root.right, targetSum - root.val)
    );
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    return solve(root, targetSum);
  }
}

public class _112_Path_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .hasPathSum(
          new TreeNode(
            5,
            new TreeNode(
              4,
              new TreeNode(11, new TreeNode(7), new TreeNode(2)),
              null
            ),
            new TreeNode(
              8,
              new TreeNode(13),
              new TreeNode(4, null, new TreeNode(1))
            )
          ),
          22
        )
    );
  }
}

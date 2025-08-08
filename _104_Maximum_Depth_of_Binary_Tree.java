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

  private int solve(TreeNode r) {
    if(r == null) return 0;
    return 1 + Math.max(solve(r.left), solve(r.right));
  }

  public int maxDepth(TreeNode root) {
    return solve(root);
  }
}

public class _104_Maximum_Depth_of_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxDepth(
          new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(
              20,
              new TreeNode(15, null, null),
              new TreeNode(7, null, null)
            )
          )
        )
    );
  }
}

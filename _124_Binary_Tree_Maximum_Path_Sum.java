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

  private int max;

  private int solve(TreeNode r) {
    if (r == null) return 0;
    int left = Math.max(0, solve(r.left));
    int right = Math.max(0, solve(r.right));

    // L + R + root

    int a = left + right + r.val;

    // max(L, R) + root
    int b = Math.max(left, right) + r.val;

    // Only root val
    int c = r.val;

    max = Math.max(max, Math.max(a, Math.max(b, c)));
    // We can return the max non-converged path from either 'b' or 'c'. i.e., max(b, c) can still have a chance to be converged with some value at the top,
    // We can not return 'a' as it is convereged already.
    return Math.max(b, c);
  }

  public int maxPathSum(TreeNode root) {
    max = Integer.MIN_VALUE;
    solve(root);
    return max;
  }
}

public class _124_Binary_Tree_Maximum_Path_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxPathSum(
          new TreeNode(
            -10,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
          )
        )
    );
  }
}

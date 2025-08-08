class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {

  private TreeNode solve(TreeNode r, TreeNode p, TreeNode q) {
    if (r == null) return null;
    if (r == p || r == q) return r;

    TreeNode lx = solve(r.left, p, q);
    TreeNode rx = solve(r.right, p, q);

    if (lx != null && rx != null) return r;

    return lx == null ? rx : lx;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    return solve(root, p, q);
  }
}

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    Solution sol = new Solution();
    TreeNode p = root.left; // Node 5
    TreeNode q = root.left.right.right; // Node 4
    TreeNode lca = sol.lowestCommonAncestor(root, p, q);
  }
}

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
    if (r == null) return 0;
    return solve(r.left) + solve(r.right) + 1;
  }

  public int countNodes(TreeNode root) {
    if(root == null) return 0;
    return solve(root);
  }
}

public class _222_Count_Complete_Tree_Nodes {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .countNodes(
          new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null)
          )
        )
    );
  }
}

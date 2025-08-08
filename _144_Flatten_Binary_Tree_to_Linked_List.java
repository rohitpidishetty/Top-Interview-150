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

  private TreeNode something = null;

  private void preOrderTraversal(TreeNode root) {
    if (root == null) return;
    preOrderTraversal(root.right);
    preOrderTraversal(root.left);
    root.right = something;
    something = root;
    root.left = null;
  }

  public void flatten(TreeNode root) {
    // Pre-order
    preOrderTraversal(root);
  }
}

public class _144_Flatten_Binary_Tree_to_Linked_List {

  public static void main(String[] args) {
    new Solution()
      .flatten(
        new TreeNode(
          1,
          new TreeNode(
            2,
            new TreeNode(3, null, null),
            new TreeNode(4, null, null)
          ),
          new TreeNode(5, null, new TreeNode(6, null, null))
        )
      );
  }
}

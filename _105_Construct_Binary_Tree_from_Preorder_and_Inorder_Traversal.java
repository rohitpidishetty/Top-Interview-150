import java.util.HashMap;
import java.util.Map;

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

  private int[] preOrd;
  private int globalRootPointer = 0;

  private TreeNode build(Map<Integer, Integer> hm, int S, int E) {
    if (S > E) return null;
    int X = hm.get(preOrd[globalRootPointer]);
    TreeNode node = new TreeNode(preOrd[globalRootPointer]);
    globalRootPointer++; // Go to next root.
    node.left = build(hm, S, X - 1);
    node.right = build(hm, X + 1, E);
    return node;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> hm = new HashMap<>();
    preOrd = preorder;
    for (int i = 0; i < inorder.length; i++) hm.put(inorder[i], i);
    return build(hm, 0, inorder.length - 1);
  }
}

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

  public static void main(String[] args) {
    new Solution()
      .buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
  }
}

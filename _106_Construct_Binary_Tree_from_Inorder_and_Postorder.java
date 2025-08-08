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

  private int[] postOrd;
  private int globalRootPointer = 0;

  private TreeNode build(Map<Integer, Integer> hm, int S, int E) {
    if (S > E) return null;
    int X = hm.get(postOrd[globalRootPointer]);
    // System.out.println(postOrd[globalRootPointer] + " @");
    TreeNode node = new TreeNode(postOrd[globalRootPointer]);
    globalRootPointer--; // Go to next root.
    node.right = build(hm, X + 1, E);
    node.left = build(hm, S, X - 1);
    return node;
  }

  public TreeNode buildTree(int[] iord, int[] pord) {
    int n = iord.length - 1;
    globalRootPointer = n;
    Map<Integer, Integer> hm = new HashMap<>();
    postOrd = pord;
    for (int i = 0; i <= n; i++) hm.put(iord[i], i);
    return build(hm, 0, n);
  }
}

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder {

  public static void main(String[] args) {
    new Solution()
      .buildTree(new int[] { 9, 15, 7, 20, 3 }, new int[] { 9, 3, 15, 20, 7 });
  }
}

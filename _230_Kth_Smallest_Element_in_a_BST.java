import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

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

  private PriorityQueue<Integer> pQ;

  private void solve(TreeNode r, int k) {
    if (r == null) return;
    solve(r.left, k);
    if (pQ.size() < k) pQ.offer(r.val);
    solve(r.right, k);
  }

  public int kthSmallest(TreeNode root, int k) {
    if(root == null) return 0;
    pQ = new PriorityQueue<>(Collections.reverseOrder());
    solve(root, k);
    return pQ.poll();
  }
}

public class _230_Kth_Smallest_Element_in_a_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .kthSmallest(
          new TreeNode(
            5,
            new TreeNode(
              3,
              new TreeNode(2, new TreeNode(1), null),
              new TreeNode(4)
            ),
            new TreeNode(6)
          ),
          3
        )
    );
  }
}

import java.util.ArrayList;
import java.util.List;

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

  private List<Integer> buf;

  private void solve(TreeNode r) {
    if (r == null) return;
    solve(r.left);
    buf.add(r.val);
    solve(r.right);
  }

  public int getMinimumDifference(TreeNode root) {
    if(root == null) return 0;
    buf = new ArrayList<>();
    solve(root);
    int mag = buf.size();

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < mag; i++) {
      int c = 0;
      for (int j = i + 1; j < mag && c < mag; j++, c++) min = Math.min(
        min,
        Math.abs(buf.get(i) - buf.get(j))
      );
    }
    return min;
  }
}

public class _530_Minimum_Absolute_Difference_in_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .getMinimumDifference(
          new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(48, new TreeNode(12), new TreeNode(49))
          )
        )
    );
  }
}

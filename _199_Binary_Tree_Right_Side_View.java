import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

  private static class order {

    protected int level;
    protected TreeNode node;

    public order(int level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
  }

  private List<Integer> solve(TreeNode r) {
    Queue<order> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new order(0, r));
    List<Integer> buf = new ArrayList<>();
    while (!bfsQ.isEmpty()) {
      order o = bfsQ.poll();
      while (buf.size() <= o.level) buf.add(0);
      buf.set(o.level, o.node.val);
      if (o.node.left != null) {
        bfsQ.offer(new order(o.level + 1, o.node.left));
      }
      if (o.node.right != null) {
        bfsQ.offer(new order(o.level + 1, o.node.right));
      }
    }
    return buf;
  }

  public List<Integer> rightSideView(TreeNode root) {
    if(root == null) return null;
    return solve(root);
  }
}

public class _199_Binary_Tree_Right_Side_View {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .rightSideView(
          new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(5)),
            new TreeNode(3, null, new TreeNode(4))
          )
        )
    );
  }
}

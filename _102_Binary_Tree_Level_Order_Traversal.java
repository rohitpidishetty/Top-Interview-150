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

  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    Queue<order> bfsQ = new ArrayDeque<>();
    List<List<Integer>> buffer = new ArrayList<>();
    bfsQ.offer(new order(0, root));
    while (!bfsQ.isEmpty()) {
      order o = bfsQ.poll();
      while (buffer.size() <= o.level) buffer.add(new ArrayList<>());
      buffer.get(o.level).add(o.node.val);
      if (o.node.left != null) bfsQ.offer(new order(o.level + 1, o.node.left));
      if (o.node.right != null) bfsQ.offer(
        new order(o.level + 1, o.node.right)
      );
    }
    return buffer;
  }
}

public class _102_Binary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .levelOrder(
          new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
          )
        )
    );
  }
}

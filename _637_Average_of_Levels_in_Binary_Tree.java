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

    protected TreeNode node;
    protected int level;

    public order(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<order> bfsQ = new ArrayDeque<>();
    List<List<Integer>> buf = new ArrayList<>();
    bfsQ.offer(new order(root, 0));
    while (!bfsQ.isEmpty()) {
      order o = bfsQ.poll();
      while (buf.size() <= o.level) buf.add(new ArrayList<>());
      buf.get(o.level).add(o.node.val);
      if (o.node.left != null) bfsQ.offer(new order(o.node.left, o.level + 1));
      if (o.node.right != null) bfsQ.offer(
        new order(o.node.right, o.level + 1)
      );
    }
    List<Double> ret = new ArrayList<>();
    for (List<Integer> buffer : buf) {
      int mag = buffer.size();
      double sum = 0;
      if (mag > 1) {
        for (int v : buffer) sum += v;
        sum /= mag;
      } else sum = buffer.get(0);
      ret.add(sum);
    }
    return ret;
  }
}

public class _637_Average_of_Levels_in_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .averageOfLevels(
          new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
          )
        )
    );
  }
}

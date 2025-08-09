import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      LinkedList<Integer> level = new LinkedList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();

        if (leftToRight) level.addLast(node.val);
        else level.addFirst(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      res.add(level);
      leftToRight = !leftToRight;
    }

    return res;
  }
}

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .zigzagLevelOrder(
          new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
          )
        )
    );
  }
}

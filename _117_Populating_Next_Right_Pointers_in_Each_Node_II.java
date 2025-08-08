import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

class Solution {

  private static class level {

    protected int level;
    protected Node node;

    public level(int level, Node node) {
      this.level = level;
      this.node = node;
    }
  }

  private void levelOrder(Node root, int level) {
    Queue<level> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new level(level, root));
    List<List<Node>> ords = new ArrayList<>();
    while (!bfsQ.isEmpty()) {
      level buffer = bfsQ.poll();
      while (ords.size() <= buffer.level) ords.add(new ArrayList<>());
      if (buffer.node != null) {
        List<Node> BUFF = ords.get(buffer.level);
        int mag = BUFF.size();
        if (mag == 0) buffer.node.next = null;
        else BUFF.get(mag - 1).next = buffer.node;
        BUFF.add(buffer.node);
      }
      if (buffer.node != null) bfsQ.offer(
        new level(buffer.level + 1, buffer.node.left)
      );
      if (buffer.node != null) bfsQ.offer(
        new level(buffer.level + 1, buffer.node.right)
      );
    }
  }

  public Node connect(Node root) {
    // Level order
    levelOrder(root, 0);
    return root;
  }
}

public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .connect(
          new Node(
            1,
            new Node(
              2,
              new Node(4, null, null, null),
              new Node(5, null, null, null),
              null
            ),
            new Node(3, null, new Node(7, null, null, null), null),
            null
          )
        )
    );
  }
}

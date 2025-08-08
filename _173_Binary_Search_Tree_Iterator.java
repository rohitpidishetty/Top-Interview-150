import java.util.ArrayDeque;
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

class BSTIterator {

  private void offerQ(TreeNode r) {
    if (r == null) return;
    offerQ(r.left);
    buffer.offer(r.val);
    offerQ(r.right);
  }

  private Queue<Integer> buffer;

  public BSTIterator(TreeNode root) {
    buffer = new ArrayDeque<>();
    offerQ(root);
  }

  public int next() {
    return buffer.poll();
  }

  public boolean hasNext() {
    return buffer.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class _173_Binary_Search_Tree_Iterator {

  public static void main(String[] args) {
    BSTIterator obj = new BSTIterator(
      new TreeNode(
        7,
        new TreeNode(3),
        new TreeNode(15, new TreeNode(9), new TreeNode(20))
      )
    );
  }
}

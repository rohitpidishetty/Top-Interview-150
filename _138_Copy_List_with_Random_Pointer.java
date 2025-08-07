class Node {

  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {

  public Node copyRandomList(Node head) {
    Node temp = head;
    while (temp != null) {
      Node next = temp.next;
      temp.next = new Node(temp.val);
      temp.next.next = next;
      temp = next;
    }
    temp = head;

    while (temp != null) {
      if (temp.random == null) temp.next.random = null;
      else temp.next.random = temp.random.next;
      temp = temp.next.next;
    }

    // Original should be as it is.

    Node deepCopy = new Node(0);
    Node dcpy = deepCopy;

    Node t = head;
    while (t != null) {
      deepCopy.next = t.next;
      deepCopy = deepCopy.next;
      t.next = t.next.next;
      t = t.next;
    }

    return dcpy.next;
  }
}

public class _138_Copy_List_with_Random_Pointer {

  public static void main(String[] args) {
    Node n1 = new Node(7);
    Node n2 = new Node(13);
    Node n3 = new Node(11);
    Node n4 = new Node(10);
    Node n5 = new Node(1);

    // Config
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n2.random = n1;
    n4.random = n3;
    n5.random = n1;
    n1.random = null;

    Node n = new Solution().copyRandomList(n1);
    while (n != null) {
      System.out.println(n.val);
      n = n.next;
    }
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {

  public boolean hasCycle(ListNode head) {
    ListNode fp = head;
    ListNode sp = head;
    do {
      sp = sp.next;
      fp = fp.next.next;
    } while (sp.next != null && fp != null && fp.next != null && sp != fp);
    return sp == fp;
  }
}

public class _141_Linked_List_Cycle {

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    ListNode ln2 = new ListNode(2);
    ListNode ln3 = new ListNode(0);
    ListNode ln4 = new ListNode(-4);

    // Config
    head.next = ln2;
    ln2.next = ln3;
    ln3.next = ln4;
    ln4.next = null;

    System.out.println(new Solution().hasCycle(head));
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  private ListNode dummy;

  private ListNode toUnitNode(ListNode head) {
    if (head.next == null) return head;
    ListNode temp = head;
    ListNode fp = temp;
    ListNode sp = temp;
    ListNode mid = null;

    do {
      mid = sp;
      sp = sp.next;
      fp = fp.next.next;
    } while (fp != null && fp.next != null);

    ListNode nextBatch = mid.next;
    mid.next = null;

    ListNode left = toUnitNode(head);
    ListNode right = toUnitNode(nextBatch);

    ListNode buffer = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        buffer.next = left;
        left = left.next;
      } else {
        buffer.next = right;
        right = right.next;
      }
      buffer = buffer.next;
    }
    if (left == null) buffer.next = right;
    if (right == null) buffer.next = left;
    return dummy.next;
  }

  public ListNode sortList(ListNode head) {
    if(head == null) return null;
    dummy = new ListNode(Integer.MIN_VALUE);
    dummy = toUnitNode(head);
    return dummy;
  }
}

public class _148_Sort_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(
      4,
      new ListNode(2, new ListNode(1, new ListNode(3)))
    );
    head = new Solution().sortList(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

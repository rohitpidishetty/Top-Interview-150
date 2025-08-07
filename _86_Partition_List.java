import java.util.List;

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

  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode ptr1 = new ListNode(Integer.MIN_VALUE);
    ListNode pt1 = ptr1;
    ListNode ptr2 = new ListNode(Integer.MIN_VALUE);
    ListNode pt2 = ptr2;
    while (head != null) {
      ListNode next = head.next;
      if (head.val < x) {
        ptr1.next = head;
        ptr1 = ptr1.next;
      } else {
        ptr2.next = head;
        ptr2 = ptr2.next;
      }
      head.next = null;
      head = next;
    }
    ptr1.next = pt2.next;
    return pt1.next;
  }
}

public class _86_Partition_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);
    head = new Solution().partition(head, 3);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

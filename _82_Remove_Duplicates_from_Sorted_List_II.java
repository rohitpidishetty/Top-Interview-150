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

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode i = dummy;
    ListNode j = dummy.next;
    ListNode prev = null;
    while (j != null) {
      if (i.val != j.val) {
        prev = i;
        i = i.next;
        j = j.next;
      } else {
        while (j != null && i.val == j.val) {
          j = j.next;
        }
        prev.next = j;
        if (j == null) break;
        i = j;
        j = i.next;
      }
    }
    return dummy.next;
  }
}

public class _82_Remove_Duplicates_from_Sorted_List_II {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next = new ListNode(5);

    head = new Solution().deleteDuplicates(head);

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

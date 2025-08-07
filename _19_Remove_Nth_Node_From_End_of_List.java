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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 0;
    ListNode h = head;
    while (h != null) {
      len++;
      h = h.next;
    }

    h = head;
    ListNode prev = null;
    while (h != null) {
      if (len == n) {
        if (prev == null) return h.next;
        prev.next = h.next;
      }
      prev = h;
      h = h.next;
      len--;
    }

    return head;
  }
}

public class _19_Remove_Nth_Node_From_End_of_List {

  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);

    ListNode head = new Solution().removeNthFromEnd(list, 2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

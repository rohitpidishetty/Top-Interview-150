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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode r = result;
    int cf = 0;
    while (l1 != null && l2 != null) {
      int res = l1.val + l2.val + cf;
      result.next = new ListNode(res % 10);
      cf = res / 10;
      l1 = l1.next;
      l2 = l2.next;
      result = result.next;
    }
    while (l1 != null) {
      int res = cf + l1.val;
      result.next = new ListNode(res % 10);
      cf = res / 10;
      result = result.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int res = cf + l2.val;
      result.next = new ListNode(res % 10);
      cf = res / 10;
      result = result.next;
      l2 = l2.next;
    }

    if (cf != 0) {
      result.next = new ListNode(1);
      result = result.next;
    }

    return r.next;
  }
}

public class _2_Add_Two_Numbers {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(2);
    n1.next = new ListNode(4);
    n1.next.next = new ListNode(3);
    n1.next.next.next = new ListNode(1);
    ListNode n2 = new ListNode(5);
    n2.next = new ListNode(6);
    n2.next.next = new ListNode(4);
    ListNode res = new Solution().addTwoNumbers(n1, n2);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}

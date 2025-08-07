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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    if (k == 0) return head;
    int len = 0;
    // Reverse the list
    ListNode temp = head;

    ListNode rev = null;
    while (temp != null) {
      ListNode next = temp.next;
      temp.next = rev;
      rev = temp;
      len++;
      temp = next;
    }

    k %= len;
    temp = rev;
    ListNode restOftheList = null;
    int idx = 1;
    while (temp != null) {
      if (idx == k) {
        restOftheList = temp.next;
        temp.next = null;
        break;
      }
      temp = temp.next;
      idx++;
    }
    ListNode rotl_rev = null;
    while (restOftheList != null) {
      ListNode save = restOftheList.next;
      restOftheList.next = rotl_rev;
      rotl_rev = restOftheList;
      restOftheList = save;
    }
    ListNode revable = null;
    while (rev != null) {
      ListNode save = rev.next;
      rev.next = revable;
      revable = rev;
      rev = save;
    }
    ListNode ret = revable;
    while (revable.next != null) revable = revable.next;
    revable.next = rotl_rev;
    return ret;
  }
}

public class _61_Rotate_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head = new Solution().rotateRight(head, 2);
    while (head != null) {
      System.err.println(head.val);
      head = head.next;
    }
  }
}

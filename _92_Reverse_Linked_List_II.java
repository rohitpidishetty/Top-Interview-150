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

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (right <= left) return head;
    /**
     * Algorithm:
     * 1. Reach to the (left) node's prior node and break the link by saving next.
     * 2. Traverse through and reach to the (right) node and break the link by saving next.
     * 3. Reverse the broken chain and re-wire it to the two other lists.
     */

    if (left == 1) {
      // 1,2,4 (1, 3)

      ListNode chainOne = head;
      ListNode prev = null;
      int idx = 1;

      while (chainOne != null) {
        ListNode next = chainOne.next;
        if (idx <= right) {
          chainOne.next = prev;
          prev = chainOne;
          if (next == null) return prev;
        } else break;
        idx++;
        chainOne = next;
      }
      ListNode ret = prev;
      while (prev.next != null) {
        prev = prev.next;
      }
      prev.next = chainOne;
      return ret;
    }

    ListNode chainOne = head;

    ListNode chainTwo = null;
    ListNode reversable = null;
    ListNode chainOnePrev = null;
    int index = 1;
    ListNode pointer = head;
    ListNode chainOneLinkPoint = null;
    while (pointer != null) {
      ListNode next = pointer.next;
      chainOnePrev = pointer;
      if (index == left - 1) {
        chainOneLinkPoint = chainOnePrev;
        reversable = chainOnePrev.next;
        chainOnePrev.next = null;
        next = reversable;
      }
      if (index == right) {
        chainTwo = pointer.next;
        pointer.next = null;
        break;
      }
      pointer = next;
      index++;
    }

    ListNode revable = reversable;
    ListNode next = null;
    ListNode lastNode = null;
    ListNode revLast = null;
    while (revable != null) {
      if (lastNode == null) revLast = revable;
      next = revable.next;
      revable.next = lastNode;
      lastNode = revable;
      revable = next;
    }

    chainOneLinkPoint.next = lastNode;
    revLast.next = chainTwo;

    return chainOne;
  }
}

public class _92_Reverse_Linked_List_II {

  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    list.next.next.next = new ListNode(4);
    // list.next.next.next.next = new ListNode(5);
    // list.next.next.next.next.next = new ListNode(6);
    ListNode head = new Solution().reverseBetween(list, 1, 3);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

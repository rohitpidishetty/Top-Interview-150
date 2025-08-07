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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    else if (list2 == null) return list1;
    ListNode buffer = new ListNode(0);
    ListNode merged = buffer;
    while (list1 != null && list2 != null) {
      int l1_val = list1.val;
      int l2_val = list2.val;
      if (l1_val <= l2_val) {
        buffer.next = new ListNode(list1.val);
        list1 = list1.next;
        buffer = buffer.next;
      } else {
        buffer.next = new ListNode(list2.val);
        list2 = list2.next;
        buffer = buffer.next;
      }
    }
    while (list1 != null) {
      buffer.next = new ListNode(list1.val);
      list1 = list1.next;
      buffer = buffer.next;
    }
    while (list2 != null) {
      buffer.next = new ListNode(list2.val);
      list2 = list2.next;
      buffer = buffer.next;
    }
    return merged.next;
  }
}

public class _21_Merge_Two_Sorted_Lists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode merged = new Solution().mergeTwoLists(l1, l2);
    while (merged != null) {
      System.out.println(merged.val);
      merged = merged.next;
    }
  }
}

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

  private void solve(ListNode[] lists, ListNode dummy) {
    int minValue = Integer.MAX_VALUE;
    ListNode minNode = null;
    int index = 0;
    int mutatedIndex = 0;
    // Comparing head ptrs of all the lists.
    for (ListNode ptr : lists) {
      if (ptr != null && ptr.val < minValue) {
        minNode = ptr;
        mutatedIndex = index;
        minValue = ptr.val;
      }
      index++;
    }

    if (minNode == null) return;

    ListNode save = minNode.next;
    minNode.next = null;

    // Chain to dummy node
    dummy.next = minNode;
    dummy = dummy.next;

    lists[mutatedIndex] = save;

    solve(lists, dummy);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    solve(lists, dummy);
    return dummy.next;
  }
}

public class _23_Merge_k_Sorted_Lists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    ListNode head = new Solution().mergeKLists(new ListNode[] { l1, l2, l3 });
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

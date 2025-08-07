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

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head == null) return head;

    ListNode previouslyUpdate = new ListNode(0);
    ListNode newHead = previouslyUpdate;
    ListNode ret = previouslyUpdate;
    ListNode temp = head;
    int count = 1;
    ListNode buffer = null;
    ListNode tempHead = null;

    while (temp != null) {
      ListNode next = temp.next;
      ListNode newBuff = new ListNode(temp.val);
      newBuff.next = buffer;
      if (buffer == null) tempHead = temp;
      buffer = newBuff;
      if (count == k) {
        previouslyUpdate.next = buffer;
        while (buffer.next != null) buffer = buffer.next;
        previouslyUpdate = buffer;
        buffer = null;
        count = 0;
        tempHead = null;
      }
      temp = next;
      count++;
    }

    while (newHead.next != null) newHead = newHead.next;
    if (tempHead != null) newHead.next = tempHead;

    return ret.next;
  }
}

public class _25_Reverse_Nodes_in_k_Group {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);
    ListNode list = new Solution().reverseKGroup(head, 3);
    while (list != null) {
      System.out.println(list.val);
      list = list.next;
    }
  }
}

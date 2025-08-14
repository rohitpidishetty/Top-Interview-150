import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

  public int findKthLargest(int[] nums, int k) {
    int i = 0;
    PriorityQueue<Integer> pQ = new PriorityQueue<>();

    while (i < nums.length) {
      pQ.add(nums[i]);
      if (pQ.size() > k) pQ.poll();
      i++;
    }
    return pQ.poll();
  }
}

public class _215_Kth_Largest_Element_in_an_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)
    );
  }
}

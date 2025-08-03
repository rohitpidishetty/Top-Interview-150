import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  // Let us use sliding window
  public int minSubArrayLen(int target, int[] nums) {
    Queue<Integer> slidingWindow = new ArrayDeque<>();
    int j = 0;
    int minSize = Integer.MAX_VALUE;
    int currentSum = 0;
    while (j < nums.length) {
      slidingWindow.add(j);
      currentSum += nums[j];
      while (!slidingWindow.isEmpty() && currentSum >= target) {
        minSize = Math.min(minSize, slidingWindow.size());
        int outOfBoundValue = nums[slidingWindow.poll()];
        currentSum -= outOfBoundValue;
      }
      j++;
    }
    return minSize == Integer.MAX_VALUE ? 0 : minSize;
  }
}

public class _209_Minimum_Size_Subarray_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 })
    );
  }
}

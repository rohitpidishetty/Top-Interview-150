class Solution {

  public int maxSubArray(int[] nums) {
    // O(n) solution
    int currentSum = nums[0];
    int maxSum = nums[0];
    int i = 1;
    while (i < nums.length) {
      if ((currentSum + nums[i]) > nums[i]) currentSum += nums[i]; // Benefitting by consuming the number
      else currentSum = nums[i]; // Resetting the window
      maxSum = Math.max(maxSum, currentSum);
      i++;
    }
    return maxSum;
  }
}

public class _53_Maximum_Subarray {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })
    );
  }
}

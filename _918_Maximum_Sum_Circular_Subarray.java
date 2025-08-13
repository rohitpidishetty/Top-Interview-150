// class Solution {

//   public int maxSubArray(int[] nums) {
//     // O(n) solution
//     int currentSum = nums[0];
//     int maxSum = nums[0];
//     int i = 1;
//     while (i < nums.length) {
//       // In if condition we are checking whether by consuming the next number are we benefitting by making huge number greater than the next.
//       if ((currentSum + nums[i]) > nums[i]) currentSum += nums[i]; // Benefitting by consuming the number
//       else currentSum = nums[i]; // Resetting the window
//       maxSum = Math.max(maxSum, currentSum);
//       i++;
//     }
//     return maxSum;
//   }

//   public int maxSubarraySumCircular(int[] nums) {
//     int max = Integer.MIN_VALUE;
//     for (int i = 0; i < nums.length; i++) {
//       int[] buffer = new int[nums.length];
//       int idx = 0;
//       for (int j = i; j < nums.length + i; j++) {
//         int currVal = nums[j % nums.length];
//         buffer[idx++] = currVal;
//       }
//       max = Math.max(max, maxSubArray(buffer));
//     }
//     return max;
//   }
// }

// public class _918_Maximum_Sum_Circular_Subarray {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().maxSubarraySumCircular(new int[] { 1, -2, 3, -2 })
//     );
//   }
// }

class Solution {

  private int maxSubArray(int[] nums) {
    int currSum = nums[0];
    int maxSum = nums[0];
    int i = 1;
    while (i < nums.length) {
      if (currSum + nums[i] > nums[i]) currSum += nums[i];
      else currSum = nums[i];
      maxSum = Math.max(maxSum, currSum);
      i++;
    }
    return maxSum;
  }

  private int minSubArray(int[] nums) {
    int currSum = nums[0];
    int minSum = nums[0];
    int i = 1;
    while (i < nums.length) {
      if (currSum + nums[i] < nums[i]) currSum += nums[i];
      else currSum = nums[i];
      minSum = Math.min(minSum, currSum);
      i++;
    }
    return minSum;
  }

  public int maxSubarraySumCircular(int[] nums) {
    int total = 0;
    for (int num : nums) total += num;
    int maxSum = maxSubArray(nums);
    if (maxSum < 0) 
      return maxSum;
    
    int minSum = minSubArray(nums);

    return Math.max(maxSum, total - minSum);
  }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {

//   private int sum1;
//   private int sum2;

//   private int solve(int idx, int magnitude, int[] nums, int sum) {
//     sum += nums[idx];
//     sum1 = Math.max(sum, sum1);
//     for (int i = idx + 2; i < magnitude; i++) {
//       solve(i, magnitude, nums, sum);
//     }
//     return sum1;
//   }

//   private int solve2(int idx, int magnitude, int[] nums, int sum) {
//     sum += nums[idx];
//     sum2 = Math.max(sum, sum2);
//     for (int i = idx + 2; i < magnitude; i++) {
//       solve2(i, magnitude, nums, sum);
//     }
//     return sum2;
//   }

//   public int rob(int[] nums) {
//     if (nums.length == 1) return nums[0];
//     sum1 = 0;
//     sum2 = 0;
//     return Math.max(
//       solve(0, nums.length, nums, 0),
//       solve2(1, nums.length, nums, 0)
//     );
//   }
// }

// public class _198_House_Robber {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution()
//         .rob(
//           new int[] {
//             114,
//             117,
//             207,
//             117,
//             235,
//             82,
//             90,
//             67,
//             143,
//             146,
//             53,
//             108,
//             200,
//             91,
//             80,
//             223,
//             58,
//             170,
//             110,
//             236,
//             81,
//             90,
//             222,
//             160,
//             165,
//             195,
//             187,
//             199,
//             114,
//             235,
//             197,
//             187,
//             69,
//             129,
//             64,
//             214,
//             228,
//             78,
//             188,
//             67,
//             205,
//             94,
//             205,
//             169,
//             241,
//             202,
//             144,
//             240,
//           }
//         )
//     );
//   }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int[] memo;

  private int solve(int idx, int[] nums) {
    if (idx >= nums.length) return 0;
    if (memo[idx] != -1) return memo[idx];
    // skip
    int skip = solve(idx + 1, nums);
    if (memo[idx] != -1) return memo[idx];
    // take
    int take = nums[idx] + solve(idx + 2, nums);
    memo[idx] = Math.max(take, skip);

    return memo[idx];
  }

  public int rob(int[] nums) {
    memo = new int[401];
    Arrays.fill(memo, -1);
    return solve(0, nums);
  }
}

public class _198_House_Robber {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 }));
  }
}

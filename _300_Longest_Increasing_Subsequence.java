// import java.util.ArrayList;
// import java.util.List;

// class Solution {

//   private int solve(int[] nums, int start, int le) {
//     if (start >= nums.length) return 0;
//     // take
//     // if and only if nums[start] > buffer.getLastElement()
//     int take = 0;
//     if (le == -1 || nums[le] < nums[start]) take =
//       1 + solve(nums, start + 1, start);

//     // skip
//     int skip = solve(nums, start + 1, le);

//     int ret = Math.max(skip, take);

//     return ret;
//   }

//   public int lengthOfLIS(int[] nums) {
//     int le = -1;
//     return solve(nums, 0, le);
//   }
// }

// public class _300_Longest_Increasing_Subsequence {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })
//     );
//   }
// }
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int[][] memo;

  private int solve(int[] nums, int start, int le) {
    if (start >= nums.length) return 0;
    if (le != -1 && memo[start][le] != -1) return memo[start][le];
    // take
    // if and only if nums[start] > buffer.getLastElement()
    int take = 0;
    if (le == -1 || nums[le] < nums[start]) take =
      1 + solve(nums, start + 1, start);

    // skip
    int skip = solve(nums, start + 1, le);

    int ret = Math.max(skip, take);
    if (le != -1) memo[start][le] = ret;
    return ret;
  }

  public int lengthOfLIS(int[] nums) {
    int le = -1;
    memo = new int[2501][2501];
    for (int[] mem : memo) Arrays.fill(mem, -1);
    return solve(nums, 0, le);
  }
}

public class _300_Longest_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })
    );
  }
}

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int longestConsecutive(int[] nums) {
    Set<Integer> m = new HashSet<>();
    int globalCount = 0;
    for (int i = 0; i < nums.length; i++) m.add(nums[i]);
    for (int i = 0; i < nums.length; i++) {
      if (m.contains(nums[i] - 1)) continue;
      int count = 1;
      int number = nums[i];
      while (m.contains(number)) {
        count++;
        number += 1;
      }
      globalCount = Math.max(globalCount, count);
    }
    return globalCount;
  }
}

public class _128_Longest_Consecutive_Sequence {

  public static void main(String[] args) {
    System.out.println(new Solution().longestConsecutive(new int[] { 0, 3 }));
  }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> ids = new HashMap<>();
    for (int i = 0; i < nums.length; i++) ids.put(nums[i], i);
    for (int i = 0; i < nums.length; i++) {
      if (
        ids.containsKey(target - nums[i]) && ids.get(target - nums[i]) != i
      ) return new int[] { i, ids.get(target - nums[i]) };
    }
    return null;
  }
}

public class _1_Two_Sum {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().twoSum(new int[] { 3, 2, 4 }, 6))
    );
  }
}

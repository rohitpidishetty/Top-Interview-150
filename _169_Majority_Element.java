import java.util.Arrays;

class Solution {

  public int majorityElement(int[] nums) {
    if (nums.length == 1) return nums[0];
    Arrays.sort(nums);
    int threshold = nums.length / 2;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) count++;
      else count = 1;
      if (count > threshold) return nums[i];
    }
    return 0;
  }
}

public class _169_Majority_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 })
    );
  }
}

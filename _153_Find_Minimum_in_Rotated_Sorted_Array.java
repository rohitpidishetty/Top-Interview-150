class Solution {

  public int findMin(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      int m = (i + j) / 2;
      if (nums[i] <= nums[m] && nums[j] < nums[m]) i = m + 1;
      else j = m;
    }
    return nums[i];
  }
}

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 3, 4, 5, 6, 2 }));
  }
}

class Solution {

  public int search(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      int m = (i + j) / 2;
      if (target == nums[m]) return m;
      else {
        if (nums[i] <= nums[m]) {
          // Left is sorted
          if (target >= nums[i] && target <= nums[m]) j = m - 1;
          else i = m + 1;
        } else {
          // Right could be sorted
          if (target <= nums[j] && target >= nums[m]) i = m + 1;
          else j = m - 1;
        }
      }
    }
    return -1;
  }
}

public class _33_Search_in_Rotated_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 10)
    );
  }
}

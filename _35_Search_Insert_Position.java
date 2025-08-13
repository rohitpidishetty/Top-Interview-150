class Solution {

  public int searchInsert(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    int at = Integer.MIN_VALUE;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (nums[mid] == target) {
        at = mid;
        return mid;
      } else if (nums[mid] > target) j = mid - 1;
      else if (nums[mid] < target) i = mid + 1;
    }
    return at == Integer.MIN_VALUE ? j + 1 : at;
  }
}

public class _35_Search_Insert_Position {

  public static void main(String[] args) {
    System.out.println(
      new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 6)
    );
  }
}

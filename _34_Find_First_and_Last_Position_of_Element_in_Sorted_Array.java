import java.util.Arrays;

class Solution {

  public int[] searchRange(int[] nums, int target) {
    if (nums.length < 1) return new int[] { -1, -1 };
    if (nums.length == 1 && nums[0] != target) return new int[] { -1, -1 };
    // Level 1
    int i = 0;
    int j = nums.length - 1;
    int firstOccurance = Integer.MAX_VALUE;
    while (i <= j) {
      int m = (i + j) / 2;
      if (nums[m] >= target) {
        firstOccurance = Math.min(firstOccurance, m);
        j = m - 1;
      } else i = m + 1;
    }
    if (
      firstOccurance != Integer.MAX_VALUE && nums[firstOccurance] != target
    ) firstOccurance = -1;
    // Level 2
    i = 0;
    j = nums.length - 1;
    int secondOccurane = Integer.MIN_VALUE;
    while (i <= j) {
      int m = (i + j) / 2;
      if (nums[m] <= target) {
        secondOccurane = Math.max(secondOccurane, m);
        i = m + 1;
      } else j = m - 1;
    }
    if (secondOccurane != Integer.MIN_VALUE && nums[secondOccurane] != target) secondOccurane = -1;

    return new int[] {
      firstOccurance == Integer.MAX_VALUE ? -1 : firstOccurance,
      secondOccurane == Integer.MIN_VALUE ? -1 : secondOccurane,
    };
  }
}

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)
      )
    );
  }
}

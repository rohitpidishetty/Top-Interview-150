import java.util.Arrays;

class Solution {

  public int removeDuplicates(int[] nums) {
    int pointer1 = 1;
    int uniqueElementIndex = 1;
    int counter = 1;
    while (pointer1 < nums.length) {
      if (nums[pointer1] == nums[pointer1 - 1]) counter++;
      else counter = 1;
      /**
       * When we find a new element that is unique obviously its
       * count will be <= 2 as we are resetting the counter as we move to a new element.
       * Now using this logic we will only move 'uniqueElementIndex' to next index
       * only when we find a new element and when its count <=  2.
       */
      if (counter <= 2) nums[uniqueElementIndex++] = nums[pointer1];
      pointer1++;
      // System.err.println(Arrays.toString(nums));
    }
    return uniqueElementIndex;
  }
}

public class _80_Remove_Duplicates_from_Sorted_Array_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 })
    );
  }
}

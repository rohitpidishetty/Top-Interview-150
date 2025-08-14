class Solution {

  public int findPeakElement(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      int m = (i + j) / 2;
      if (nums[m] < nums[m + 1]) i = m + 1;
      else j = m;
    }

    return j;
  }
}

public class _162_Find_Peak_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 })
    );
  }
}

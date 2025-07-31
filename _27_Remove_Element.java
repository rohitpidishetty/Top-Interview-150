import java.util.Arrays;

class Solution {

  public int removeElement(int[] nums, int val) {
    int i = 0, j = 0;
    while (i < nums.length) {
      if (nums[i] != val) nums[j++] = nums[i];

      i++;
    }
    return j;
  }
}

public class _27_Remove_Element {

  public static void main(String[] args) {
    System.out.println(
      new Solution().removeElement(new int[] { 3, 2, 2, 3 }, 3)
    );
  }
}

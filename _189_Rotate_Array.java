import java.util.Arrays;

class Solution {

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }
}

public class _189_Rotate_Array {

  public static void main(String[] args) {
    // 1,2,3,4,5,6,7 | k = 3
    // 5,6,7,1,2,3,4
    int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    new Solution().rotate(arr, 3);
  }
}

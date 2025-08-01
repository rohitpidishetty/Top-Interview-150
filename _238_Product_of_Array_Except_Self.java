import java.util.Arrays;

class Solution {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] leftProducts = new int[n];
    int[] rightProducts = new int[n];
    for (int i = 0; i < n; i++) {
      leftProducts[i] = (i == 0) ? nums[i] : leftProducts[i - 1] * nums[i];
    }
    for (int i = n - 1; i >= 0; i--) {
      rightProducts[i] = (i == n - 1)
        ? nums[i]
        : rightProducts[i + 1] * nums[i];
    }
    // System.out.println(Arrays.toString(leftProducts));
    // System.out.println(Arrays.toString(rightProducts));
    int[] result = new int[n];
    result[0] = rightProducts[1];
    result[n - 1] = leftProducts[n - 2];
    for (int i = 1; i < n - 1; i++) result[i] =
      leftProducts[i - 1] * rightProducts[i + 1];

    // System.out.println(Arrays.toString(result));
    return result;
  }
}

public class _238_Product_of_Array_Except_Self {

  public static void main(String[] args) {
    // 1,2,3,4
    System.out.println(
      new Solution().productExceptSelf(new int[] { 1, 2, 3, 4 })
    );
  }
}

import java.util.Arrays;

class Solution {

  public int trap(int[] height) {
    int n = height.length;
    int[] leftLimits = new int[n];
    int[] rightLimits = new int[n];

    int leftMax = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      leftLimits[i] = leftMax = Math.max(leftMax, height[i]);
    }

    int rightMax = Integer.MIN_VALUE;
    for (int i = n - 1; i > -1; i--) {
      rightLimits[i] = rightMax = Math.max(rightMax, height[i]);
    }
    // System.out.println(Arrays.toString(leftLimits));
    // System.out.println(Arrays.toString(rightLimits));
    int trappedWater = 0;
    for (int i = 1; i < n - 1; i++) {
      trappedWater += Math.min(leftLimits[i], rightLimits[i]) - height[i];
    }
    return trappedWater;
  }
}

public class _42_Trapping_Rain_Water {

  public static void main(String[] args) {
    System.out.println(new Solution().trap(new int[] { 4, 2, 0, 3, 2, 5 }));
  }
}

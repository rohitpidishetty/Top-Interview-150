class Solution {

  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int max = Integer.MIN_VALUE;
    int calculation = 0;
    while (i < j) {
      int distance = (j - i);
      if (height[i] < height[j]) {
        calculation = distance * height[i];
        if (calculation > max) max = calculation;
        i++;
      } else {
        calculation = distance * height[j];
        if (calculation > max) max = calculation;
        j--;
      }
    }
    return max;
  }
}

public class _11_Container_With_Most_Water {

  public static void main(String[] args) {
    System.out.println(new Solution().maxArea(new int[] { 1, 1 }));
  }
}

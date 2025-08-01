import java.util.Arrays;

class Solution {

  public int jump(int[] nums) {
    int i = 0;
    int jumps = 0;
    int start = 0;
    int farReachable = 0;
    while (i < nums.length - 1) {
      farReachable = Math.max(farReachable, i + nums[i]);
      System.out.println("start " + start + " , far " + farReachable + " @ i:" + i);
      if (i == start) {
        jumps++;
        start = farReachable;
      }
      i++;
    }
    return jumps;
  }
}

public class _45_Jump_Game_II {

  public static void main(String[] args) {
    System.out.println(new Solution().jump(new int[] { 2, 3, 0, 1, 4 }));
  }
}

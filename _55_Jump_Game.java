class Solution {

  public boolean canJump(int[] nums) {
    /**
     * The brute-force solution for this problem is simply a recursive solution.
     * But let us focus on optimizing the solution in linear time.
     * ALGO:
     *  1. start from the end and mark the end as the 'destinationPoint'.
     *  2. Traverse back in the array and find an index that can help us in reaching the current 'destinationPoint'.
     *  3. If we find an index that can help us to jump to 'destinationPoint', mark the current index as
     *     'destinationPoint' and repeat the process of finding another lower index that can get us to
     *     this current updated 'destinationPoint'.
     *  NOTE: We just need to reach the updated 'destinationPoint' because at
     *        this point we are anyway sure that if we can find an index that can get us
     *        to current point, then this current point will obviously take us to the last index.
     *    Ex: if 'a' has to reach 'c' and if we know that 'b' can reach 'c', then just check if 'a' can reach 'b'.
     */
    int i = nums.length - 1;
    int destinationPoint = i;
    while (i >= 0) {
      if (i + nums[i] >= destinationPoint) destinationPoint = i;
      i--;
    }
    return destinationPoint == 0;
  }
}

public class _55_Jump_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().canJump(new int[] { 2, 3, 1, 1, 4 }));
  }
}

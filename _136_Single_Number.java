class Solution {

  public int singleNumber(int[] nums) {
    int num = nums[0];
    int i = 1;
    while (i < nums.length) num ^= nums[i++];
    return num;
  }
}

public class _136_Single_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().singleNumber(new int[] { 2, 2, 1 }));
  }
}

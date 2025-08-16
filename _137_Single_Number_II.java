class Solution {

  public int singleNumber(int[] nums) {
    int zeros = 0;
    int ones = 0;
    int ls = 0;
    int distinct = 0;
    int shift = 0;

    while (ls < 32) {
      for (int num : nums) {
        if ((num & (1 << ls)) == 0) zeros++;
        else ones++;
      }
      distinct |= ((zeros % 3) == 0 ? 1 : 0) << (shift++);
      zeros = 0;
      ones = 0;
      ls++;
    }

    return distinct;
  }
}

public class _137_Single_Number_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().singleNumber(new int[] { 4, 2, 7, 7, 2, 4, 10, 7, 4, 2 })
    );
  }
}

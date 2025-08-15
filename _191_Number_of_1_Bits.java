class Solution {

  public int hammingWeight(int n) {
    int idx = 31;
    int ls = 0;
    int count = 0;
    while (idx-- > 0) if ((n & (1 << ls++)) != 0) count++;
    return count;
  }
}

public class _191_Number_of_1_Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().hammingWeight(11));
  }
}

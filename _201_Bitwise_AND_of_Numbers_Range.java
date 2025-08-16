class Solution {

  public int rangeBitwiseAnd_v0(int left, int right) {
    int res = 0;
    int shift = 0;
    int ls = 0;
    while (ls < 32) {
      int i = left;
      for (; i <= right; i++) {
        if (((i & (1 << ls)) == 0)) {
          res |= (0 << shift);
          break;
        }
      }
      if (i > right) res |= (1 << shift);
      shift++;
      ls++;
    }
    return res;
  }

  public int rangeBitwiseAnd(int left, int right) {
    while (right > left) 
      right = right & (right - 1);
    
    return right;
  }
}

public class _201_Bitwise_AND_of_Numbers_Range {

  public static void main(String[] args) {
    System.out.println(new Solution().rangeBitwiseAnd(5, 7));
  }
}

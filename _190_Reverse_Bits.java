class Solution {

  public int reverseBits(int n) {
    int i = 0;
    int bit = 1;
    int reversed = 0;
    int ls = 0;
    int j = 31;
    while (i++ < 31) 
      reversed |= ((n & (1 << (j--))) == 0 ? 0 : 1) << (ls++);
    
    return reversed;
  }
}

public class _190_Reverse_Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseBits(43261596));
  }
}

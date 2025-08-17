class Solution {

  public int mySqrt(int x) {
    if(x < 2) return 1;
    int left = 1;
    int right = x / 2;
    while (left <= right) {
      int mid = (left + right) / 2;
      long sqrRoot = (long) mid * mid;
      if (sqrRoot == x) return mid;
      else if (sqrRoot > x) right = mid - 1;
      else left = mid + 1;
    }
    return right;
  }
}

public class _69_Sqrt_x_ {

  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(81));
  }
}

class Solution {

  public double myPow_v0(double x, int n) {
    double res = 1;
    if ((x > 0 && n > 0) || (x < 0 && n > 0)) {
      double result = x;
      while (n > 0) {
        res *= result;
        n--;
      }
    } else if (x > 0 && n < 0) {
      double result = 1 / x;
      n *= -1;
      while (n > 0) {
        res *= result;
        n--;
      }
    } else if (x < 0 && n < 0) {
      double result = x;
      n *= -1;
      while (n > 0) {
        res *= result;
        n--;
      }
      res = 1 / res;
    }
    return res;
  }

  private double solve(double x, long n) {
    if (n == 0) return 1;
    if (n < 0) return solve(1 / x, -n);
    if (n % 2 == 0) return solve(x * x, n / 2);
    return x * solve(x * x, (n - 1) / 2);
  }

  public double myPow(double x, int n) {
    return solve(x, (long) n);
  }
}

public class _50_Pow_x_n_ {

  public static void main(String[] args) {
    System.out.println(new Solution().myPow(-2.00, -2));
  }
}

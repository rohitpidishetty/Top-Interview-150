import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public boolean isHappy(int n) {
    // Code

    int num = n;
    Set<Integer> prods = new HashSet<>();
    while (num > 0) {
      int newNum = 0;
      while (num > 0) {
        int d = (num % 10);
        newNum += (d * d);
        num /= 10;
      }
      num = newNum;
      if (num == 1) return true;
      if (prods.contains(num)) return false;
      prods.add(num);
    }
    return false;
  }
}

public class _202_Happy_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(2));
  }
}

class Solution {

  public String addBinary(String a, String b) {
    int n = a.length();
    int m = b.length();
    if (n > m) return addBinary(b, a);
    int i = n - 1;
    int jx = m - 1;

    int carryForward = 0;
    StringBuilder sb = new StringBuilder();
    while (i >= 0) {
      char b1 = a.charAt(i);
      char b2 = b.charAt(jx);
      if (b1 == b2 && b1 == '0') {
        if (carryForward == 1) {
          sb.append('1');
          carryForward = 0;
        } else sb.append('0');
      } else if (b1 != b2) {
        if (carryForward == 0) sb.append('1');
        else {
          sb.append('0');
          carryForward = 1;
        }
      } else {
        if (carryForward == 0) {
          sb.append('0');
          carryForward = 1;
        } else {
          sb.append('1');
          carryForward = 1;
        }
      }
      i--;
      jx--;
    }

    if (n != m) {
      int j = m - n - 1;
      while (j >= 0) {
        char b2 = b.charAt(j);
        if (b2 == '0' && carryForward == 0) sb.append('0');
        else if (b2 == '0' && carryForward == 1) {
          sb.append('1');
          carryForward = 0;
        } else if (b2 == '1' && carryForward == 0) sb.append('1');
        else if (b2 == '1' && carryForward == 1) {
          sb.append('0');
          carryForward = 1;
        }
        j--;
      }
    }
    if (carryForward == 0) return sb.reverse().toString();
    else return sb.append('1').reverse().toString();
  }
}

public class _67_Add_Binary {

  public static void main(String[] args) {
    System.out.println(new Solution().addBinary("101111", "10"));
  }
}

class Solution {

  public String convert(String s, int numRows) {
    int cols = s.length() - 1;
    if (cols + 1 < numRows) return s;
    int row = 0;
    StringBuilder[] res = new StringBuilder[numRows];
    boolean direction = true;
    int charIdx = 0;
    while (charIdx <= cols) {
      if (direction) {
        if (res[row] == null) res[row] = new StringBuilder();
        res[row].append(s.charAt(charIdx));
        row += 1;
        if (row == numRows) {
          row -= 1;
          direction = false;
        }
      } else {
        row -= 1;
        res[row].append(s.charAt(charIdx));
        if (row == 0) {
          row += 1;
          direction = true;
        }
      }
      charIdx++;
    }
    // System.out.println(Arrays.toString(res));
    StringBuilder word = new StringBuilder();
    for (StringBuilder sb : res) word.append(sb);
    return word.toString();
  }
}

public class _6_Zigzag_Conversion {

  public static void main(String[] args) {
    System.out.println(new Solution().convert("AB", 1));
  }
}

import java.util.Arrays;

class Solution {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    for (int i = 0; i < citations.length; i++) {
      int papers = (citations.length - i);
      if (citations[i] >= papers) return papers;
    }
    return 0;
  }
}

public class _274_H_Index {

  public static void main(String[] args) {
    System.out.println(new Solution().hIndex(new int[] { 1, 1, 3 }));
  }
}

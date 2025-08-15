import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int[][] CP = new int[capital.length][2];
    for (int i = 0; i < capital.length; i++) CP[i] = new int[] {
      capital[i],
      profits[i],
    };

    Arrays.sort(CP, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    int i = 0;
    while (k-- > 0) {
      while (i < capital.length && CP[i][0] <= w) pQ.offer(CP[i++]);
      if(pQ.size() == 0) break;
      w += pQ.poll()[1];
    }

    return w;
  }
}

public class _502_IPO {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findMaximizedCapital(
          3,
          0,
          new int[] { 1, 2, 3 },
          new int[] { 0, 1, 2 }
        )
    );
  }
}

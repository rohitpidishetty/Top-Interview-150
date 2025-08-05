import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    Stack<int[]> s = new Stack<>();
    for (int arr[] : intervals) {
      if (s.isEmpty()) s.push(arr);
      else if (s.peek()[1] >= arr[0]) {
        int[] temp = s.pop();
        s.push(new int[] { temp[0], Math.max(arr[1], temp[1]) });
      } else s.push(arr);
    }
    int[][] ret = new int[s.size()][2];
    int idx = 0;
    for (int[] d : s) ret[idx++] = d;
    return ret;
  }
}

public class _56_Merge_Intervals {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })
    );
  }
}

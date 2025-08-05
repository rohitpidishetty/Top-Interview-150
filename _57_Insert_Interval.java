import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (
      intervals.length == 0 ||
      (intervals.length > 0 && intervals[0].length == 0)
    ) return new int[][] { newInterval };
    if (newInterval.length == 0) return intervals;
    int[][] ret = new int[intervals.length + 1][2];
    int i = 0;
    int j = 0;
    int idx = 0;
    while (i < intervals.length && j < 1) {
      if (intervals[i][0] < newInterval[0]) {
        ret[idx++] = intervals[i];
        i++;
      } else {
        ret[idx++] = newInterval;
        j++;
      }
    }
    if (i >= intervals.length) ret[idx] = newInterval;
    while (i < intervals.length) ret[idx++] = intervals[i++];
    return merge(ret);
  }

  public int[][] merge(int[][] intervals) {
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

public class _57_Insert_Interval {

  public static void main(String[] args) {
    int[][] res = new Solution()
      .insert(new int[][] { { 2, 5 }, { 4, 6 } }, new int[] { 1, 1 });

    for (int[] r : res) {
      System.out.println(Arrays.toString(r));
    }
  }
}

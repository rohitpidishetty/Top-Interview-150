import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int maxPoints(int[][] points) {
    if(points.length < 1) return 0;
    if (points.length == 1) return 1;
    int maxPoints = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Float, Integer> alignment = new HashMap<>();
      for (int j = 0; j < points.length; j++) {
        if (j == i) continue;
        float den = (points[j][0] - points[i][0]);
        float slope = den == 0
          ? Float.MAX_VALUE
          : (float) (points[j][1] - points[i][1]) / den;
        alignment.put(slope, alignment.getOrDefault(slope, 0) + 1);
      }
      Object[] arr = alignment.values().toArray();
      Arrays.sort(arr);
      maxPoints = Math.max(maxPoints, (int) arr[arr.length - 1]);
    }
    return maxPoints + 1;
  }
}

public class _149_Max_Points_on_a_Line {

  public static void main(String[] args) {
    System.out.println(new Solution().maxPoints(new int[][] { { 1, 1 } }));
  }
}

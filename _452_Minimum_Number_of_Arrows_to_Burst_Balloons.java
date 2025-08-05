import java.util.Arrays;

class Solution {

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int arrows = 1;
    int previousEnd[] = points[0];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > previousEnd[1]) {
        arrows++;
        previousEnd = points[i];
      }
    }
    return arrows;
  }
}

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findMinArrowShots(
          new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } }
        )
    );
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

  public List<List<Integer>> kSmallestPairs_v0(
    int[] nums1,
    int[] nums2,
    int k
  ) {
    List<List<Integer>> buffer = new ArrayList<>();
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        pQ.add(new int[] { nums1[i], nums2[j], nums1[i] + nums2[j] });
      }
    }
    while (k-- > 0) {
      int[] buf = pQ.poll();
      buffer.add(Arrays.asList(buf[0], buf[1]));
    }
    return buffer;
  }

  public List<List<Integer>> kSmallestPairs_v1(
    int[] nums1,
    int[] nums2,
    int k
  ) {
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    boolean[][] visited = new boolean[nums1.length][nums2.length];
    // For (0,0) next min will be at either (0, 0+1) or (0+1, 0).
    pQ.offer(new int[] { 0, 0, nums1[0] + nums2[0] });
    visited[0][0] = true;
    List<List<Integer>> buffer = new ArrayList<>();
    while (k-- > 0 && !pQ.isEmpty()) {
      int min[] = pQ.poll();
      buffer.add(Arrays.asList(nums1[min[0]], nums2[min[1]]));
      if (min[1] + 1 < nums2.length && visited[min[0]][min[1] + 1] == false) {
        pQ.add(
          new int[] { min[0], min[1] + 1, nums1[min[0]] + nums2[min[1] + 1] }
        );
        visited[min[0]][min[1] + 1] = true;
      }
      if (min[0] + 1 < nums1.length && visited[min[0] + 1][min[1]] == false) {
        pQ.add(
          new int[] { min[0] + 1, min[1], nums1[min[0] + 1] + nums2[min[1]] }
        );
        visited[min[0] + 1][min[1]] = true;
      }
    }
    return buffer;
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> buffer = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    pq.offer(new int[] { 0, 0, nums1[0] + nums2[0] });

    while (k-- > 0 && !pq.isEmpty()) {
      int[] min = pq.poll();
      int i = min[0], j = min[1];
      buffer.add(Arrays.asList(nums1[i], nums2[j]));
      if (j + 1 < nums2.length) 
        pq.offer(new int[] { i, j + 1, nums1[i] + nums2[j + 1] });
      
      if (j == 0 && i + 1 < nums1.length) 
        pq.offer(new int[] { i + 1, 0, nums1[i + 1] + nums2[0] });
      
    }

    return buffer;
  }
}

public class _373_Find_K_Pairs_with_Smallest_Sums {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .kSmallestPairs(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }, 2)
    );
  }
}

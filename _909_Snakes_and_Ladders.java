import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  private Map<Integer, int[]> getCoordinates(int[][] board, int n, int n2) {
    int i = n - 1;
    int j = 0;
    boolean direction = true;
    Map<Integer, int[]> coords = new HashMap<>();
    int idx = 1;
    while (n2 > 0) {
      coords.put(idx++, new int[] { i, j });
      if (direction) {
        if (j == n - 1) {
          i--;
          direction = false;
        } else j++;
      } else {
        if (j == 0) {
          i--;
          direction = true;
        } else j--;
      }
      n2--;
    }
    return coords;
  }

  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int n2 = n * n;

    Map<Integer, int[]> coords = getCoordinates(board, n, n2);

    int ret = bfs(1, board, coords, n2);

    return ret;
  }

  private int bfs(
    int start,
    int[][] board,
    Map<Integer, int[]> coords,
    int goalState
  ) {
    Set<Integer> visited = new HashSet<>();

    Queue<Integer> bfsQ = new ArrayDeque<>();
    bfsQ.offer(1);
    visited.add(1);

    int steps = 0;

    while (!bfsQ.isEmpty()) {
      System.out.println(bfsQ);
      int size = bfsQ.size();
      while (size > 0) {
        // Get current coord and see all its reachables starting from (curr + 1 to curr + 6).
        int currentCoord = bfsQ.poll();

        if (currentCoord == goalState) return steps;

        // Neighbors
        for (
          int roll = currentCoord + 1;
          roll <= Math.min(goalState, currentCoord + 6);
          roll++
        ) {
          int coord[] = coords.get(roll);
          int v = board[coord[0]][coord[1]];
          if (v == -1) {
            if (!visited.contains(roll)) {
              bfsQ.add(roll);
              visited.add(roll);
            }
          } else {
            if (!visited.contains(v)) {
              bfsQ.offer(v);
              visited.add(v);
            }
          }
        }
        size--;
      }
      steps++;
    }
    return -1;
  }
}

class Solution2 {

  private static class order {

    protected int node;
    protected int level;

    public order(int node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  private Map<Integer, int[]> getCoordinates(int[][] board, int n, int n2) {
    int i = n - 1;
    int j = 0;
    boolean direction = true;
    Map<Integer, int[]> coords = new HashMap<>();
    int idx = 1;
    while (n2 > 0) {
      coords.put(idx++, new int[] { i, j });
      if (direction) {
        if (j == n - 1) {
          i--;
          direction = false;
        } else j++;
      } else {
        if (j == 0) {
          i--;
          direction = true;
        } else j--;
      }
      n2--;
    }
    return coords;
  }

  public int snakesAndLadders(int[][] board) {
    // BFS level order

    int n = board.length;
    int n2 = n * n;

    Map<Integer, int[]> coords = getCoordinates(board, n, n2);

    Set<Integer> visited = new HashSet<>();

    Queue<order> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new order(1, 0));
    visited.add(1);

    while (!bfsQ.isEmpty()) {
      order o = bfsQ.poll();
      if (o.node == n2) {
        return o.level;
      }
      for (
        int neighbor = o.node + 1;
        neighbor <= Math.min(n2, o.node + 6);
        neighbor++
      ) {
        int[] coord = coords.get(neighbor);
        int v = board[coord[0]][coord[1]];
        if (v == -1) {
          if (!visited.contains(neighbor)) {
            bfsQ.add(new order(neighbor, o.level + 1));
            visited.add(neighbor);
          }
        } else {
          if (!visited.contains(v)) {
            bfsQ.add(new order(v, o.level + 1));
            visited.add(v);
          }
        }
      }
    }
    return -1;
  }
}

public class _909_Snakes_and_Ladders {

  public static void main(String[] args) {
    // System.out.println(
    //   new Solution()
    //     .snakesAndLadders(
    //       new int[][] {
    //         { -1, -1, -1, -1, -1, -1 },
    //         { -1, -1, -1, -1, -1, -1 },
    //         { -1, -1, -1, -1, -1, -1 },
    //         { -1, 35, -1, -1, 13, -1 },
    //         { -1, -1, -1, -1, -1, -1 },
    //         { -1, 15, -1, -1, -1, -1 },
    //       }
    //     )
    // );
    System.out.println(
      new Solution2()
        .snakesAndLadders(
          new int[][] {
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, 35, -1, -1, 13, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, 15, -1, -1, -1, -1 },
          }
        )
    );
  }
}

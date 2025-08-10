import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

  protected boolean[] visited;
  protected boolean[] inPath;

  private boolean dfs(int starting, List<List<Integer>> graph) {
    visited[starting] = true;
    inPath[starting] = true;
    for (int neighbor : graph.get(starting)) {
      if (!visited[neighbor]) {
        if (dfs(neighbor, graph)) return true;
      } else if (inPath[neighbor]) return true;
    }
    inPath[starting] = false;
    return false;
  }

  private boolean hasCycle(List<List<Integer>> graph, int nodes) {
    for (int i = 0; i < nodes; i++) {
      visited = new boolean[nodes];
      inPath = new boolean[nodes];
      if (!visited[i] && dfs(i, graph)) return true;
    }

    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (
      prerequisites == null ||
      prerequisites.length == 0 ||
      (prerequisites.length != 0 && prerequisites[0].length == 0)
    ) return true;
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for (int[] adjNodes : prerequisites) {
      int start = adjNodes[0];
      int end = adjNodes[1];
      graph.get(end).add(start);
    }
    if (!hasCycle(graph, numCourses)) return true;
    return false;
  }
}

public class _207_Course_Schedule {

  public static void main(String[] args) {
    System.out.println(new Solution().canFinish(2, new int[][] { { 0, 1 } }));
  }
}

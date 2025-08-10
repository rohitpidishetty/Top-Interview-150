import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {

  private List<List<Integer>> buildGraph(int vertices, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());
    for (int[] edge : edges) {
      int U = edge[0];
      int V = edge[1];
      graph.get(V).add(U);
    }
    return graph;
  }

  private int[] topologicalSort(
    List<List<Integer>> graph,
    int nodes,
    int[] inDegrees
  ) {
    Queue<Integer> bfsQ = new ArrayDeque<>();
    int processed = 0;
    for (int i = 0; i < inDegrees.length; i++) {
      if (inDegrees[i] == 0) bfsQ.offer(i);
    }

    int[] order = new int[nodes];
    int idx = 0;

    while (!bfsQ.isEmpty()) {
      int currentNode = bfsQ.poll();
      order[idx++] = currentNode;
      processed++;
      for (int neighbor : graph.get(currentNode)) {
        if (inDegrees[neighbor] > 0) {
          inDegrees[neighbor]--;
          if (inDegrees[neighbor] == 0) {
            bfsQ.offer(neighbor);
          }
        }
      }
    }
    if (processed != nodes) return new int[] {};
    else return order;
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
    int inDegrees[] = new int[numCourses];
    for (List<Integer> g : graph) for (int v : g) inDegrees[v]++;
    return topologicalSort(graph, numCourses, inDegrees);
  }
}

public class _210_Course_Schedule_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })
    );
  }
}

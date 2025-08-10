import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
class Solution {

  public double[] calcEquation(
    List<List<String>> equations,
    double[] values,
    List<List<String>> queries
  ) {
    int idx = 0;
    // Let us solve this problem using weighted directed graph.

    Map<String, ArrayList<ArrayList<String>>> graph = new HashMap<>();
    for (List<String> l : equations) {
      String num = l.get(0);
      String den = l.get(1);
      double weight = values[idx++];
      double inverse = 1 / weight;

      if (graph.get(num) == null) graph.put(num, new ArrayList<>());
      if (graph.get(den) == null) graph.put(den, new ArrayList<>());
      graph
        .get(num)
        .add(new ArrayList<>(Arrays.asList(den, String.valueOf(weight))));
      graph
        .get(den)
        .add(new ArrayList<>(Arrays.asList(num, String.valueOf(inverse))));
    }

    // System.out.println(graph);

    List<Double> res = new ArrayList<>();
    queries.forEach(e -> {
      String num = e.get(0);
      String den = e.get(1);
      boolean[] reached = { false };
      if (graph.get(num) != null) {
        graph
          .get(num)
          .forEach(canReach -> {
            if (canReach.get(0).equals(den)) {
              res.add(Double.parseDouble(canReach.get(1)));
              reached[0] = true;
            }
          });
        if (!reached[0]) {
          if (num.equals(den)) res.add(1d);
          else if (!graph.containsKey(num) || !graph.containsKey(den)) res.add(
            -1d
          );
          else {
            visited.clear();
            P = -1.0;
            travel(graph, num, den, 1);
            res.add(P);
          }
        }
      } else res.add(-1d);
    });
    double[] ans = new double[res.size()];
    for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
    return ans;
  }

  private Set<String> visited = new HashSet<>();
  private double P;

  private void travel(
    Map<String, ArrayList<ArrayList<String>>> graph,
    String start,
    String end,
    double prod
  ) {
    if (start.equals(end)) {
      P = prod;
      return;
    }
    // neighbors
    for (ArrayList<String> neighbor : graph.get(start)) {
      if (visited.contains(neighbor.get(0)) || P != -1) continue;
      // visited.clear();
      visited.add(neighbor.get(0));
      travel(
        graph,
        neighbor.get(0),
        end,
        prod * Double.parseDouble(neighbor.get(1))
      );
    }
  }
}

public class _399_Evaluate_Division {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .calcEquation(
            Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
            new double[] { 2.0, 3.0 },
            Arrays.asList(
              Arrays.asList("b", "a"),
              Arrays.asList("a", "c"),
              Arrays.asList("a", "e"),
              Arrays.asList("a", "a"),
              Arrays.asList("x", "x")
            )
          )
      )
    );
  }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {

  private Map<Integer, Node> nodePointers;
  private Map<Integer, List<Integer>> hm;

  private void dfs(Node node) {
    if (nodePointers.containsKey(node.val)) return;
    nodePointers.put(node.val, new Node(node.val));
    for (Node n : node.neighbors) {
      if (hm.get(node.val) == null) hm.put(node.val, new ArrayList<>());
      hm.get(node.val).add(n.val);
      dfs(n);
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    nodePointers = new HashMap<>();
    hm = new HashMap<>();
    dfs(node);
    hm
      .entrySet()
      .forEach(e -> {
        for (int n : e.getValue()) nodePointers
          .get(e.getKey())
          .neighbors.add(nodePointers.get(n));
      });
    return nodePointers.get(node.val);
  }
}

public class _133_Clone_Graph {

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);
    node2.neighbors.add(node1);
    node2.neighbors.add(node3);
    node3.neighbors.add(node2);
    node3.neighbors.add(node4);
    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    Node cloned = new Solution().cloneGraph(node1);
  }
}

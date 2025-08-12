import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int n,
    int k,
    List<Integer> k_sized_buffer,
    int startingPoint,
    List<List<Integer>> buffer
  ) {
    if (k_sized_buffer.size() == k) {
      buffer.add(new ArrayList<>(k_sized_buffer));
      return;
    }
    for (int i = startingPoint; i <= n; i++) {
      k_sized_buffer.add(i);
      solve(n, k, k_sized_buffer, i + 1, buffer);
      k_sized_buffer.remove(k_sized_buffer.size() - 1);
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> buffer = new ArrayList<>();
    solve(n, k, new ArrayList<>(), 1, buffer);
    return buffer;
  }
}

public class _77_Combinations {

  public static void main(String[] args) {
    System.out.println(new Solution().combine(1, 1));
  }
}

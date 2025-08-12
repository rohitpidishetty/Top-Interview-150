import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int start,
    List<Integer> buffer,
    int[] candidates,
    int target,
    int currentSum,
    List<List<Integer>> buf
  ) {
    if (currentSum > target) return;
    if (currentSum == target) {
      buf.add(new ArrayList<>(buffer));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      buffer.add(candidates[i]);
      currentSum += candidates[i];
      solve(i, buffer, candidates, target, currentSum, buf);
      currentSum -= candidates[i];
      buffer.remove(buffer.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> buffer = new ArrayList<>();
    solve(0, new ArrayList<>(), candidates, target, 0, buffer);
    return buffer;
  }
}

public class _39_Combination_Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7)
    );
  }
}

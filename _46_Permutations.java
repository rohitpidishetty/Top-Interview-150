import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int startingPoint,
    int[] nums,
    List<Integer> buffer,
    List<List<Integer>> buff
  ) {
    if (startingPoint > nums.length) return;
    if (buffer.size() == nums.length) {
      buff.add(new ArrayList<>(buffer));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (buffer.contains(nums[i])) continue;
      buffer.add(nums[i]);
      solve(i + 1, nums, buffer, buff);
      buffer.remove(buffer.size() - 1);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    int startingPoint = 0;
    List<List<Integer>> buffer = new ArrayList<>();
    solve(startingPoint, nums, new ArrayList<>(), buffer);
    return buffer;
  }
}

public class _46_Permutations {

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] { 1, 2, 3 }));
  }
}

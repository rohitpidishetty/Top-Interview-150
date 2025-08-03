import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    int n = nums.length;
    Set<List<Integer>> buffer = new HashSet<>();
    while (i <= n - 3) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        i++;
        continue;
      }
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int result = nums[i] + nums[j] + nums[k];
        if (result == 0) {
          buffer.add(List.of(nums[i], nums[j], nums[k]));
          // Skipping duplicates
          while (j < k && nums[j] == nums[j + 1]) j++;
          while (j < k && nums[k] == nums[k - 1]) k--;
          k--;
        } else if (result > 0) k--;
        else if (result < 0) j++;
      }
      i++;
    }
    return new ArrayList<>(buffer);
  }
}

public class _15_3Sum {

  public static void main(String[] args) {
    System.out.println(
      new Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4 })
    );
  }
}

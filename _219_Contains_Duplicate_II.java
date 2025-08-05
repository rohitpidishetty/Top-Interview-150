import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    int i = 0;
    Set<Integer> window = new HashSet<>();
    while (i < nums.length) {
      if (window.contains(nums[i])) return true;
      window.add(nums[i]);
      if (window.size() > k) {
        window.remove(nums[i - k + 1]);
      }
      i++;
    }
    return false;
  }
}

public class _219_Contains_Duplicate_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2)
    );
  }
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, List<Integer>> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (m.get(nums[i]) == null) m.put(nums[i], new ArrayList<>());
      m.get(nums[i]).add(i);
    }
    for (Collection<Integer> arr : m.values()) {
      Object[] arr_x = arr.toArray();
      int i = 1;
      for (; i < arr_x.length; i++) {
        if ((int) arr_x[i] - (int) arr_x[i - 1] <= k) return true;
      }
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

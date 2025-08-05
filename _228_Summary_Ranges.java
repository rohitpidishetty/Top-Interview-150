import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<String> summaryRanges(int[] nums) {
    List<String> ret = new ArrayList<>();
    if (nums.length == 0) return ret;
    int start = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1] + 1) {
        if (start == nums[i - 1]) ret.add(String.valueOf(start));
        else ret.add(start + "->" + nums[i - 1]);
        start = nums[i];
      }
    }
    if (start == nums[nums.length - 1]) ret.add(String.valueOf(start));
    else ret.add(start + "->" + nums[nums.length - 1]);
    return ret;
  }
}

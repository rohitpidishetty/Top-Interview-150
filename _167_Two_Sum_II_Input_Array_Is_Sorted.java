import java.util.Arrays;

class Solution {

  public int[] twoSum(int[] numbers, int target) {
    int n = numbers.length;
    int i = 0;
    int j = n - 1;

    while (i < j) {
      int num = numbers[i] + numbers[j];
      if (num == target) return new int[] { i + 1, j + 1 };
      if (num > target) j--;
      else if (num < target) i++;
    }
    return null;
  }
}

public class _167_Two_Sum_II_Input_Array_Is_Sorted {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().twoSum(new int[] { -1, 0 }, -1))
    );
  }
}

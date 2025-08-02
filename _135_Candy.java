import java.util.Arrays;

class Solution {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int minimumCandies[] = new int[n];
    Arrays.fill(minimumCandies, 1); // As every child should have a minimum of 1 candy atleast.
    // Lets write a logic for children with high ratings to have more candies than neighbors.

    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) minimumCandies[i] =
        minimumCandies[i - 1] + 1;
    }
    System.out.println(Arrays.toString(minimumCandies));

    for (int j = n - 2; j >= 0; j--) {
      if (ratings[j] > ratings[j + 1]) minimumCandies[j] = Math.max(
        minimumCandies[j],
        minimumCandies[j + 1] + 1
      );
    }
    System.out.println(Arrays.toString(minimumCandies));

    int candies = 0;
    for (int i = 0; i < n; i++) candies += minimumCandies[i];
    return candies;
  }
}

public class _135_Candy {

  public static void main(String[] args) {
    System.out.println(new Solution().candy(new int[] { 1, 3, 4, 5, 2 }));
  }
}

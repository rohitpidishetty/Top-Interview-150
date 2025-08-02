import java.util.Arrays;

class Solution {

  // public int strStr(String haystack, String needle) {
  //   int n = haystack.length();
  //   int m = needle.length();
  //   int[][] matrix = new int[m + 1][n + 1];
  //   Arrays.fill(matrix[0], 0);
  //   int j = 0;
  //   for (int i = 0; i < m; i++) matrix[i][j] = 0;
  //   for (int i = 1; i < matrix.length; i++) {
  //     for (j = 1; j < matrix[i].length; j++) {
  //       if (haystack.charAt(j - 1) == needle.charAt(i - 1)) {
  //         matrix[i][j] = matrix[i - 1][j - 1] + 1;
  //         if (matrix[i][j] == m) return j - m;
  //       }
  //     }
  //   }
  //   for (j = 0; j < matrix[m].length; j++) if (matrix[m][j] == m) return j - m;
  //   return -1;
  // }

  public int strStr(String haystack, String needle) {
    int n = haystack.length();
    int m = needle.length();
    int i = 0;
    int j = 0;

    while (i < n) {
      if (haystack.charAt(i) == needle.charAt(j)) {
     
        i++;
        j++;
        if (j >= m) return i - m;
      } else {
        i -= (j - 1);
        j = 0;
      }
    }
    return -1;
  }
}

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().strStr("sadbutsad", "sad"));
  }
}

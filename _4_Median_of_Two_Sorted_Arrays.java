import java.util.ArrayList;
import java.util.List;

class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums2.length < nums1.length) return findMedianSortedArrays(
      nums2,
      nums1
    );
    int n1 = nums1.length;
    int n2 = nums2.length;
    int buffer_len = (n1 + n2);
    int left_half = (buffer_len + 1) / 2; // (n1 + n2 + 1) / 2
    int i = 0, j = nums1.length;
    while (i <= j) {
      int m1 = (i + j) / 2; // Mid point of first array.
      int m2 = left_half - m1; // Space left in left half of the final array, and this also acts as a boundary that tells us until which ele can we consider from the second array.

      int x1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
      int y1 = (m1 == n1) ? Integer.MAX_VALUE : nums1[m1];

      int x2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
      int y2 = (m2 == n2) ? Integer.MAX_VALUE : nums2[m2];

      if (x1 <= y2 && x2 <= y1) {
        if ((n1 + n2) % 2 == 1) {
          // Odd case
          return Math.max(x2, x1);
        }
        return (double) (Math.max(x1, x2) + Math.min(y1, y2)) / 2d;
      }
      if (x1 > y2) j = m1 - 1;
      else i = m1 + 1;
    }
    return -1;
  }
}

public class _4_Median_of_Two_Sorted_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findMedianSortedArrays(
          new int[] { 2, 4, 6, 9 },
          new int[] { 5, 8, 10, 12 }
        )
    );
  }
}

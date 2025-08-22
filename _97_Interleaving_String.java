class Solution {

  private Boolean[][][] memo;

  private boolean solve(
    char[] buffer1,
    char[] buffer2,
    int ptr1,
    int ptr2,
    char[] buffer3,
    int ptr3
  ) {
    if (
      ptr1 == buffer1.length && ptr2 == buffer2.length && ptr3 == buffer3.length
    ) return true;
    if (memo[ptr1][ptr2][ptr3] != null) return memo[ptr1][ptr2][ptr3];
    if (
      ptr1 < buffer1.length &&
      ptr2 < buffer2.length &&
      ptr3 < buffer3.length &&
      buffer1[ptr1] == buffer2[ptr2] &&
      buffer2[ptr2] == buffer3[ptr3]
    ) return (
      memo[ptr1][ptr2][ptr3] =
        solve(buffer1, buffer2, ptr1 + 1, ptr2, buffer3, ptr3 + 1) ||
        solve(buffer1, buffer2, ptr1, ptr2 + 1, buffer3, ptr3 + 1)
    );
    else if (
      ptr1 < buffer1.length &&
      ptr3 < buffer3.length &&
      buffer1[ptr1] == buffer3[ptr3]
    ) return (
      memo[ptr1][ptr2][ptr3] = solve(
        buffer1,
        buffer2,
        ptr1 + 1,
        ptr2,
        buffer3,
        ptr3 + 1
      )
    );
    else if (
      ptr2 < buffer2.length &&
      ptr3 < buffer3.length &&
      buffer2[ptr2] == buffer3[ptr3]
    ) return (
      memo[ptr1][ptr2][ptr3] = solve(
        buffer1,
        buffer2,
        ptr1,
        ptr2 + 1,
        buffer3,
        ptr3 + 1
      )
    );

    return false;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    char[] s1_tokens = s1.toCharArray();
    char[] s2_tokens = s2.toCharArray();
    char[] s3_tokens = s3.toCharArray();
    memo = new Boolean[201][201][201];
    return solve(s1_tokens, s2_tokens, 0, 0, s3_tokens, 0);
  }
}

public class _97_Interleaving_String {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac")
    );
  }
}

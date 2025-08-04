import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {

    char[] frq1 = new char[256];
    char[] frq2 = new char[256];
    int n = ransomNote.length();
    for (int idx = 0; idx < n; idx++) {
      char ch = ransomNote.charAt(idx);
      frq1[ch]++;
    }
    int m = magazine.length();
    for (int idx = 0; idx < m; idx++) {
      char ch = magazine.charAt(idx);
      frq2[ch]++;
    }
   
    // 1. Every char in freq1 should exist in freq2, and its freq1 <= freq2
    for (int idx = 0; idx < n; idx++) {
      char ch = ransomNote.charAt(idx);
      if (
        frq2[ch] == '\0' || (frq2[ch] != '\0' && frq1[ch] > frq2[ch])
      ) return false;
    }
    return true;
  }
}

public class _383_Ransom_Note {

  public static void main(String[] args) {
    System.out.println(new Solution().canConstruct("aabd", "aab"));
  }
}

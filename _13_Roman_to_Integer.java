import java.util.Arrays;

class Solution {

  private int[] romanMap;

  private void setRomanMap() {
    romanMap = new int[256];
    romanMap['I'] = 1;
    romanMap['V'] = 5;
    romanMap['X'] = 10;
    romanMap['L'] = 50;
    romanMap['C'] = 100;
    romanMap['D'] = 500;
    romanMap['M'] = 1000;
  }

  public int romanToInt(String s) {
    setRomanMap();
    int globalNumber = 0;
    int localNumber = 0;
    int n = s.length() - 1;
    int pointer = n;
    while (pointer >= 0) {
      localNumber = romanMap[s.charAt(pointer)];
      while (
        pointer > 0 &&
        romanMap[s.charAt(pointer)] > romanMap[s.charAt(pointer - 1)]
      ) {
        localNumber += (-romanMap[s.charAt(pointer - 1)]);
        pointer--;
      }
      globalNumber += localNumber;
      pointer--;
    }
    return globalNumber;
  }
}

public class _13_Roman_to_Integer {

  public static void main(String[] args) {
    System.out.println(new Solution().romanToInt("LVIII"));
  }
}

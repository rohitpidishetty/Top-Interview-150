import java.util.ArrayList;
import java.util.List;

class Solution {

  private String[] romanMap;
  private int denominations[] = new int[] {
    1000,
    900,
    500,
    400,
    100,
    90,
    50,
    40,
    10,
    9,
    5,
    4,
    1,
  };

  private List<Integer> getDenominations(
    int number,
    List<Integer> buffer,
    int start
  ) {
    // try {
    // Thread.sleep(2000);
    if (number == 0) {
      return new ArrayList<>(buffer);
    }
    for (int i = start; i < denominations.length; i++) {
      if (number < denominations[i]) continue;
      buffer.add(denominations[i]);
      return getDenominations(number - denominations[i], buffer, i);
    }
    // } catch (Exception e) {}
    return null;
  }

  private void loadRomanMap() {
    romanMap = new String[1001];
    romanMap[1] = "I";
    romanMap[4] = "IV";
    romanMap[5] = "V";
    romanMap[9] = "IX";
    romanMap[10] = "X";
    romanMap[40] = "XL";
    romanMap[50] = "L";
    romanMap[90] = "XC";
    romanMap[100] = "C";
    romanMap[400] = "CD";
    romanMap[500] = "D";
    romanMap[900] = "CM";
    romanMap[1000] = "M";
  }

  public String intToRoman(int num) {
    loadRomanMap();
    int temp = num;
    StringBuilder sb = new StringBuilder();
    int placeValue = 1;
    while (temp > 0) {
      int number = placeValue * (temp % 10);
      System.out.println(number);
      // Check if mapping is available, if yes then simply map. Else break the number into parts and then map individually.
      if (number < 1001 && romanMap[number] != null) sb.insert(
        0,
        romanMap[number]
      );
      else {
        List<Integer> denos = getDenominations(number, new ArrayList<>(), 0);
        StringBuilder denos_ = new StringBuilder();
        for (int den : denos) denos_.append(romanMap[den]);
        sb.insert(0, denos_);
      }
      placeValue *= 10;
      temp /= 10;
    }
    return sb.toString();
  }
}

public class _12_Integer_to_Roman {

  public static void main(String[] args) {
    System.out.println(new Solution().intToRoman(3749));
  }
}

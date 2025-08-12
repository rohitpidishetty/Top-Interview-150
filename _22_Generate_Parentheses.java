import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int openingBrackets,
    int closingBrackets,
    StringBuilder sb,
    int balancingFactor,
    List<String> buffer
  ) {
    if (
      openingBrackets == balancingFactor && closingBrackets == balancingFactor
    ) {
      buffer.add(sb.toString());
      return;
    }
    if (openingBrackets < balancingFactor) {
      sb.append('(');
      solve(openingBrackets + 1, closingBrackets, sb, balancingFactor, buffer);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (closingBrackets < openingBrackets) {
      sb.append(')');
      solve(openingBrackets, closingBrackets + 1, sb, balancingFactor, buffer);
      sb.deleteCharAt(sb.length() - 1);
    }
    return;
  }

  public List<String> generateParenthesis(int n) {
    List<String> buffer = new ArrayList<>();
    solve(0, 0, new StringBuilder(), n, buffer);
    return buffer;
  }
}

public class _22_Generate_Parentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().generateParenthesis(3));
  }
}

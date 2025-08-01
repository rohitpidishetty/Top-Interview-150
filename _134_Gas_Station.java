class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    // See if the trip is possible or not by adding all the values
    int moneyToSpend = 0;
    int moneyThatHasToBeSpend = 0;
    for (int i = 0; i < n; i++) {
      moneyToSpend += gas[i];
      moneyThatHasToBeSpend += cost[i];
    }
    if (moneyToSpend < moneyThatHasToBeSpend) return -1;
    // Lets try to use Greedy approach and solve this question.
    int startingPoint = 0;
    int currentGas = 0;
    for (int i = 0; i < n; i++) {
      int buy = gas[i];
      int spend = cost[i];
      currentGas = currentGas + (buy + (-spend));
      if (currentGas < 0) {
        currentGas = 0;
        // 'startingPoint' can never be anything from previous 'startingPoint' to current 'i', thus lets consider 'i+1'
        startingPoint = i + 1;
      }
    }
    return startingPoint;
  }
}

public class _134_Gas_Station {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .canCompleteCircuit(
          new int[] { 1, 2, 3, 4, 5 },
          new int[] { 3, 4, 5, 1, 2 }
        )
    );
  }
}

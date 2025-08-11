import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  private Set<String> valid;
  private Set<String> visited;
  private int gMuts;

  private int solveMutations(String startGene, String endGene, int steps) {
    if (startGene.equals(endGene)) return steps;
    char[] sGene = startGene.toCharArray();
    char mutations[] = { 'A', 'C', 'G', 'T' };
    int mutationPointer = 0;
    int res = Integer.MAX_VALUE;
    for (; mutationPointer < mutations.length; mutationPointer++) {
      for (int i = 0; i < 8; i++) {
        char buff = sGene[i];
        if (buff == mutations[mutationPointer]) continue;
        sGene[i] = mutations[mutationPointer];
        String gene = new String(sGene);
        if (gene.equals(endGene)) {
          return steps + 1;
        }
        if (valid.contains(gene) && !visited.contains(gene)) {
          visited.add(gene);
          res = Math.min(res, solveMutations(gene, endGene, steps + 1));
          visited.remove(gene);
        }
        sGene[i] = buff;
      }
    }
    return res;
  }

  public int minMutation(String startGene, String endGene, String[] bank) {
    if (bank.length == 0) return -1;
    valid = new HashSet<>();
    gMuts = Integer.MIN_VALUE;
    visited = new HashSet<>();
    for (String v : bank) valid.add(v);
    if (!valid.contains(endGene)) return -1;
    visited.add(startGene);
    int ans = solveMutations(startGene, endGene, 0);

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}

public class _433_Minimum_Genetic_Mutation {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" })
    );
  }
}

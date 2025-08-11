import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {

  private static class order {

    protected String word;
    protected int level;

    public order(String word, int level) {
      this.word = word;
      this.level = level;
    }
  }

  public int ladderLength(
    String beginWord,
    String endWord,
    List<String> wordList
  ) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
    int wordMag = beginWord.length();
    Set<Character> letterSet = new HashSet<>();
    for (String word : wordList) {
      for (char ch : word.toCharArray()) letterSet.add(ch);
    }
    Queue<order> bfsQ = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    bfsQ.offer(new order(beginWord, 0));
    visited.add(beginWord);

    // List<String> mutationBuff = new ArrayList<>();
    while (!bfsQ.isEmpty()) {
      order o = bfsQ.poll();
      if (o.word.equals(endWord)) return o.level + 1;
      // while (o.level >= mutationBuff.size()) mutationBuff.add(new String());
      // mutationBuff.set(o.level, o.word);
      char[] buffer = o.word.toCharArray();
      for (char ch : letterSet) {
        for (int i = 0; i < wordMag; i++) {
          char temp = buffer[i];
          if (ch == temp) continue;
          buffer[i] = ch;
          String mutation = new String(buffer);
          if (wordSet.contains(mutation) && visited.add(mutation)) {
            bfsQ.offer(new order(mutation, o.level + 1));
          }
          buffer[i] = temp;
        }
      }
    }
    return 0;
  }
}

public class _127_Word_Ladder {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .ladderLength(
          "hit",
          "cog",
          Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")
        )
    );
  }
}

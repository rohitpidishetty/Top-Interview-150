import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

  static class Phrase {

    protected List<StringBuilder> phrase;
    protected int spaces;

    public Phrase(List<StringBuilder> phrase, int spaces) {
      this.phrase = phrase;
      this.spaces = spaces;
    }
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    Queue<Integer> q = new ArrayDeque<>();
    int i = 1;
    int currentSum = 0;
    q.offer(0);
    int space = 1;
    List<Phrase> buffer = new ArrayList<>();
    currentSum += words[0].length();
    while (i < words.length - 1) {
      while ((currentSum + words[i].length() + space) <= maxWidth) {
        currentSum += space + words[i].length();
        q.offer(i);
        i++;
      }

      ArrayList<StringBuilder> collection = new ArrayList<>();
      while (!q.isEmpty()) collection.add(new StringBuilder(words[q.poll()]));
      buffer.add(new Phrase(collection, maxWidth - currentSum));
      q.add(i);
      currentSum = words[i].length();
      i++;
    }
    ArrayList<StringBuilder> collection = new ArrayList<>();
    // Remaining
    currentSum = 0;
    if (i < words.length) {
      i--;
      while (i < words.length) {
        currentSum += words[i].length() + space;
        collection.add(new StringBuilder(words[i]));
        i++;
      }
      buffer.add(new Phrase(collection, maxWidth - currentSum + 1));
    }
    i = 0;
    int x = buffer.size();
    for (i = 0; i < x; i++) {
      String justified = addSpaces(
        buffer.get(i).phrase,
        buffer.get(i).spaces,
        i == x - 1
      );
      System.out.println(justified + " - " + justified.length());
    }
    return null;
  }

  private String repeatSpace(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) sb.append(' ');
    return sb.toString();
  }

  private String addSpaces(
    List<StringBuilder> collection,
    int spaces,
    boolean isLastLine
  ) {
    System.out.println(collection + " " + spaces);
    if (!isLastLine) {
      int collSize = collection.size() - 1;
      if (collSize > 0) {
        int interpoleSpaces = spaces / (collection.size() - 1);
        StringBuilder resultString = collection.get(0);
        for (int i = 1; i <= collSize; i++) {
          resultString
            .repeat(' ', interpoleSpaces + 1)
            .append(collection.get(i));
        }
        return resultString.toString();
      } else return collection.get(0).repeat(' ', spaces).toString();
    } else {
      int collSize = collection.size() - 1;
      if (collSize > 0) {
        StringBuilder resultString = collection.get(0);
        for (int i = 1; i <= collSize; i++) {
          resultString.append(' ').append(collection.get(i));
        }
        resultString.repeat(' ', spaces);
        return resultString.toString();
      } else return collection.get(0).repeat(' ', spaces).toString();
    }
  }
}

public class _68_Text_Justification {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .fullJustify(
          new String[] {
            "Science",
            "is",
            "what",
            "we",
            "understand",
            "well",
            "enough",
            "to",
            "explain",
            "to",
            "a",
            "computer.",
            "Art",
            "is",
            "everything",
            "else",
            "we",
            "do",
          },
          20
        )
    );
  }
}

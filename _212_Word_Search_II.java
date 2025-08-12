import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {

  protected TrieNode[] buffer = new TrieNode[26];
  protected boolean isEOW;
  protected Set<String> words;
}

class TrieBuilder {

  private TrieNode trieNode;

  public TrieBuilder(String[] words) {
    trieNode = new TrieNode();

    for (String word : words) {
      int word_magnitude = word.length();
      TrieNode setter = trieNode;
      for (int i = 0; i < word_magnitude; i++) {
        int ch = (word.charAt(i) - 'a');
        if (setter.buffer[ch] == null) {
          setter.buffer[ch] = new TrieNode();
          setter = setter.buffer[ch];
        } else setter = setter.buffer[ch];
      }
      setter.isEOW = true;
      if (setter.words == null) setter.words = new HashSet<>();
      setter.words.add(word);
    }
  }

  protected TrieNode getRef() {
    return trieNode;
  }
}

class Solution {

  private Set<String> result;

  private void solve(
    char[][] board,
    int i,
    int j,
    StringBuilder sb,
    TrieNode trie
  ) {
    if (
      i < 0 ||
      j < 0 ||
      i > board.length - 1 ||
      j > board[0].length - 1 ||
      board[i][j] == '*'
    ) return;

    trie = trie.buffer[board[i][j] - 'a'];
    if (trie == null) return;

    sb.append(board[i][j]);
    if (trie.isEOW) result.addAll(trie.words);

    char save = board[i][j];
    board[i][j] = '*';
    solve(board, i - 1, j, sb, trie);
    solve(board, i + 1, j, sb, trie);
    solve(board, i, j - 1, sb, trie);
    solve(board, i, j + 1, sb, trie);

    board[i][j] = save;
    sb.deleteCharAt(sb.length() - 1);
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode trie = new TrieBuilder(words).getRef();
    result = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) solve(
        board,
        i,
        j,
        new StringBuilder(),
        trie
      );
    }

    return new ArrayList<>(result);
  }
}

public class _212_Word_Search_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findWords(
          new char[][] {
            { 'o', 'a', 'a', 'n' },
            { 'e', 't', 'a', 'e' },
            { 'i', 'h', 'k', 'r' },
            { 'i', 'f', 'l', 'v' },
          },
          new String[] { "oath", "pea", "eat", "rain" }
        )
    );
  }
}

class TrieNode {

  TrieNode[] children;
  boolean isEndOfWord;

  public TrieNode() {
    children = new TrieNode[26];
    isEndOfWord = false;
  }
}

class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  protected TrieNode getRoot() {
    return root;
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (node.children[index] == null) node.children[index] = new TrieNode();
      node = node.children[index];
    }
    node.isEndOfWord = true;
  }
}

class WordDictionary extends Trie {

  public WordDictionary() {}

  public void addWord(String word) {
    insert(word);
  }

  public boolean search(String word) {
    TrieNode tn = getRoot();

    if (word.indexOf('.') != -1) return solve(tn, word, 0);

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (tn.children[ch - 'a'] == null) return false;
      tn = tn.children[ch - 'a'];
    }
    return tn.isEndOfWord;
  }

  private boolean solve(TrieNode tn, String word, int idx) {
    if (idx == word.length()) return tn.isEndOfWord;

    char ch = word.charAt(idx);
    if (ch == '.') {
      for (int i = 0; i < 26; i++) {
        if (
          tn.children[i] != null && solve(tn.children[i], word, idx + 1)
        ) return true;
      }
      return false;
    } else {
      if (tn.children[ch - 'a'] == null) return false;
      TrieNode next = tn.children[ch - 'a'];
      return solve(next, word, idx + 1);
    }
  }
}

public class _211_Design_Add_and_Search_Words_Data_Structure {

  public static void main(String[] args) {
    WordDictionary obj = new WordDictionary();
    obj.addWord("a");
    obj.addWord("a");

    System.out.println(obj.search("."));
    System.out.println(obj.search("a"));
    System.out.println(obj.search("aa"));
    System.out.println(obj.search("a"));
    System.out.println(obj.search(".a"));
    System.out.println(obj.search("a."));
  }
}

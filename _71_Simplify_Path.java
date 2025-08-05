import java.util.*;
import java.util.Stack;

class Solution {

  public String simplifyPath(String path) {
    String[] pathTkns = path.split("/");
    Stack<String> S = new Stack<>();
    for (String tkn : pathTkns) {
      if (tkn.equals(".") || tkn.equals("")) continue;
      else if (tkn.equals("..")) {
        if (!S.isEmpty()) S.pop();
      } else S.push(tkn);
    }

    return "/" + String.join("/", S);
  }
}


public class _71_Simplify_Path {

  public static void main(String[] args) {
    // System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    System.out.println(new Solution().simplifyPath("/a/./b/./c/./d/"));

    System.out.println(new Solution().simplifyPath("/home//foo/"));
  }
}

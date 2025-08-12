class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  private TreeNode solve(int[] nums, int i, int j) {
    if (i >= j) return null;
    int m = (i + j) / 2;

    TreeNode root = new TreeNode(nums[m]);
    root.left = solve(nums, i, m);
    root.right = solve(nums, m + 1, j);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return solve(nums, 0, nums.length);
  }
}

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 })
    );
  }
}

/* 给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    // 设外部辅助变量，保存当前最大路径长度
    // 因为先序遍历先遍历子树，那么有可能子树拥有较大路径长度，先保存起来
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        // 返回辅助变量
        return ans;
    }
    
    // dfs 是返回普通的，从上往下的最大路径
    private int dfs(TreeNode root){
        if(root==null) return 0;

        // 左子树从上往下的最大路径，负数置0（这很重要）
        int l_value = Math.max(0, dfs(root.left));
        // 右子树从上往下的最大路径，负数置0
        int r_value = Math.max(0, dfs(root.right));

        // 比较原值，与经过该点的最长路径，即最长路径要不要经过该点
        ans = Math.max(ans, l_value + root.val + r_value);
        return Math.max(l_value, r_value) + root.val;
    }
}
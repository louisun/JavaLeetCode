// 日期: 2019-01-13 23:17:52


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int cnt = 0;
    private int e;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return e;
    }
    
    public void inOrder(TreeNode root, int k){
        if(root==null) return;
        if(root.left != null){
            inOrder(root.left, k);
        }
        
        cnt++;
        if(cnt == k){
            e = root.val;
            return;
        }
        
        if(root.right != null){
            inOrder(root.right, k);
        }
    }
}
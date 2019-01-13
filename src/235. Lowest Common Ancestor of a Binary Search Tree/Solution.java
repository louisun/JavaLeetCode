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
    private TreeNode t = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            foo(root, q, p);
        }
        else{
            foo(root, p, q);            
        }
        return t;

    }
    
    public void foo(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        
        if(root.val >= p.val && root.val <= q.val){
            t = root;
            return;
        }
        else if(root.val < p.val){
            lowestCommonAncestor(root.right, p, q);

        }
        else if(root.val > q.val){
            lowestCommonAncestor(root.left, p, q);            
        }   
    }
}


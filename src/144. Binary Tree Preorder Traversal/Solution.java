// 日期: 2019-01-14 23:50:39

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 // 非递归实现
 import java.util.LinkedList;

 class Solution {
     private LinkedList<TreeNode> stack = new LinkedList<>();
 
     public List<Integer> preorderTraversal(TreeNode root) {
         // 前序历（中，左，右），借助栈
         List<Integer> ret  = new ArrayList<>();
         TreeNode p = root;
 
         while(p != null || !stack.isEmpty()){
             // 注意是在入栈的时候访问
             if(p != null){
                 // p 非空，访问，往左走
                 ret.add(p.val);
                 // 入栈（子树还要用到）
                 stack.add(p);
                 p = p.left;
             }
             else{
                 // p 为空，走到头了，出栈，访问右子树
                 p = stack.removeLast();
                 p = p.right;
             }
         }
         return ret;
         
     }
 }
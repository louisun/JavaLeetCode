// 日期: 2019-01-14 22:52:16

/* 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */


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

    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历（左，中，右），借助栈
        List<Integer> ret  = new ArrayList<>();
        TreeNode p = root;

        while(p != null || !stack.isEmpty()){
            // 当 p 非空，p 入栈保存
            // 当 p 空，p为栈顶元素，出栈，出栈才会访问节点
            if(p != null){
                stack.add(p);
                p = p.left;
            }
            else{
                // p 空的时候，栈顶就是下一个要访问的祖先节点
                p = stack.removeLast();
                ret.add(p.val);
                p = p.right;
            }
        }
        return ret;
        
    }
}
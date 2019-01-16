// 日期: 2019-01-15 21:46:15

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    private class TreeNodeWithLevel{
        public TreeNode t;
        public int level;
        TreeNodeWithLevel(TreeNode t, int level){
            this.t = t;
            this.level = level;
        }
    }

    // 队列
    private LinkedList<TreeNodeWithLevel> queue = new LinkedList<>();

    // 层号对应的节点
    private HashMap<Integer, List<Integer>> levelMap = new HashMap<>(); 

    // 最终返回的列表
    private List<List<Integer>> retList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return retList;
        }
        queue.addLast(new TreeNodeWithLevel(root, 1));
        int maxLevel = 1;
        while(!queue.isEmpty()){
            TreeNodeWithLevel n = queue.removeFirst();
            if(levelMap.get(n.level) == null){
                levelMap.put(n.level,new ArrayList<Integer>());
            }
            levelMap.get(n.level).add(n.t.val);
            maxLevel = Math.max(maxLevel, n.level);
            if(n.t.left!=null){
                queue.addLast(new TreeNodeWithLevel(n.t.left, n.level + 1));
            }
            if(n.t.right!=null){
                queue.addLast(new TreeNodeWithLevel(n.t.right, n.level + 1));
            }
        }
        for(int i = 1; i <= maxLevel; i++){
            retList.add(levelMap.get(i));
        }
        return retList;
    }
}


/* 另一种更简单的解法:
 * 因为是按层输出的，当一层都输出完了（出队完了）
 * 队列中剩余的节点就是下一层的节点，可以统计出节点数来
 * 所以多个内层循环就好了
 */
class AnotherSolution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++){
            second = second.next;
        }
        if(second == null){
            return head.next;
        }
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        // 此时 first 是要删除的节点之前的节点
        first.next = first.next.next;
        return head;
    }

    public static void main(String[] args){
        // 构造列表
        ListNode head = new ListNode(1);
        ListNode tmp  = head;
        
        for(int i = 2; i <=5; i++){
            tmp.next = new ListNode(i);
            tmp = tmp.next; 
        }
        tmp.next = null;

        // while(head != null){
        //     System.out.println(head.val);
        //     head = head.next;
        // }


        // 调用函数
        Solution solution = new Solution();
        ListNode myhead = solution.removeNthFromEnd(head, 3);
        while(myhead != null){
            System.out.println(myhead.val);
            myhead = myhead.next;
        } 
    }
}
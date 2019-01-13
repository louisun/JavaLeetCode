package q002;
/* 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/


import DataStructure.ListNode;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int index = 0;
        int carry = 0;
        int[] l = new int[100];
        while(l1!= null && l2!= null){
           l[index] = l1.val + l2.val;
           index++;
           l1 = l1.next;
           l2 = l2.next;
        }
        while(l2 != null){
            l[index] = l2.val;
            index++;
            l2 = l2.next;
        }
        while(l1 != null){
            l[index] = l1.val;
            index++;
            l1 = l1.next;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;

        for(int i = 0; i < index; i++){
            int val = (l[i] + carry) % 10;
            carry = (l[i] + carry) / 10;
            p.next = new ListNode(val);
            p = p.next;
        }
        if(carry != 0) p.next = new ListNode(carry);
        return head.next;

    }

}

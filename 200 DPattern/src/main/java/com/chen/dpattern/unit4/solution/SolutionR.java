package com.chen.dpattern.unit4.solution;

/**
 * Definition for singly-linked list.
 * public class solution.ListNode {
 *     int val;
 *     solution.ListNode next;
 *     solution.ListNode() {}
 *     solution.ListNode(int val) { this.val = val; }
 *     solution.ListNode(int val, solution.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}

}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = new ListNode();
        cur.next = null;


        while(head.next != null){

            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;

        }
        head.next = cur.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        // solution.ListNode head = new solution.ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode n_head = solution.reverseList(head);
        while(n_head != null){
            System.out.println(n_head.val);
            n_head = n_head.next;
        }
    }
}

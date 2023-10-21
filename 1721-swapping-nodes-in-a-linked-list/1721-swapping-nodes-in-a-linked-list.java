/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int size=0; 
        ListNode iter=head;
        while(iter!=null){
            iter=iter.next;
            size++; 
        }
        ListNode sent=new ListNode(-1);
        sent.next=head;
        ListNode first=sent;
        ListNode second=sent;
        int count=k;
        while(count > 0){
            first=first.next;
            count--; 
        }
        count=size-k+1;
        while(count>0){
            count--;
            second=second.next; 
        }
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        return sent.next; 
    }
}
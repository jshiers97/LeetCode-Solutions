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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
            
        }
        //prev.next=null;
        
        
        //reverse second half
        ListNode curr=slow;
        prev=null;
        ListNode tmp;
        while(curr!=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
            
        }
        int max=0;
        while(prev!=null){
            
            max=Math.max(max, head.val + prev.val); 
            head=head.next;
            prev=prev.next;
        }
        return max;
    }
}
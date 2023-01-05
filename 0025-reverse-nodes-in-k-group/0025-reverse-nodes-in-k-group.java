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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead=null;
        ListNode tail=null;
        ListNode iter=head;
        while(iter!=null){
            int count=0;
            iter=head;
            while(iter!=null && count < k){
                count++;
                iter=iter.next;
            }
            
            if(count==k){
                ListNode temp=reverse(head, k);
                if(newHead==null){
                    newHead=temp;
                }
                if(tail!=null){
                    tail.next=temp;
                }
                tail=head;
                head=iter;

            }
        }
        if(tail!=null){
            tail.next=head;
        }
        return newHead;
    }
    public ListNode reverse(ListNode current, int k){
        ListNode sent=null;
        int curr=1;
        
        ListNode temp=current.next;
        while(temp!=null && curr < k){
            current.next=sent;
            sent=current;
            current=temp;
            temp=current.next;
            curr++;
            
        }
        current.next=sent;
        return current;
        
    }
}
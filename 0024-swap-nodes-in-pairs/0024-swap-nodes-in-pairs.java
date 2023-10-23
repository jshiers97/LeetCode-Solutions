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
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null; 
        }
        
        
        ListNode ptr1=head;
        ListNode ptr2=head.next;
        if(ptr2==null){
            return ptr1; 
        }
        ListNode temp=ptr2.next;
        ptr2.next=ptr1;
        ptr1.next=swapPairs(temp);
        return ptr2;
        
    }
}
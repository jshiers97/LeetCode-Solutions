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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode sent=new ListNode(-1);
        sent.next=head;
        ListNode iter=sent; 
        boolean pivot=false;
        List<ListNode> list=new ArrayList<>(); 
        while(iter.next!=null){
            if(iter.next.val==x || iter.next.val >x){
                pivot=true;
                iter=iter.next;
            }
            else if(pivot && iter.next.val<x){
                list.add(iter.next);
                iter.next=iter.next.next; 
            }
            else{
                iter=iter.next;
            }
        }
        if(pivot==false){
            return head;
        }
        
        //now you have list, insert them after the last val behind partition that is less than the partition 
        iter=sent;
        while(iter.next.val<x){
            iter=iter.next;
            
        }
        ListNode temp=iter.next;
        for(ListNode node: list){
            iter.next=node;
            iter=node; 
        }
        iter.next=temp; 
        return sent.next;
        
    }
}
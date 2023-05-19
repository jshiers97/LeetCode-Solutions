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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists==null){
            return null; 
        }
        if(lists.length==1){
            return lists[0]; 
        }
       
        ListNode sentinel=new ListNode(-1);
        ListNode head=sentinel;
        int min=100001; 
        int minIndex=-1;
        int empty=0;
        while(empty<lists.length){
            for(int i=0; i<lists.length; i++){
                ListNode curr=lists[i];
                if(curr==null){
                    continue;
                }
                if(curr.val < min){
                    min=curr.val;
                    minIndex=i; 
                }
            }
            ListNode insert=new ListNode(min); 
            if(min==100001){
                return sentinel.next;
            }
            
            head.next=insert;
            head=head.next;
            ListNode shift=lists[minIndex];
            if(shift.next==null){
                empty++;
                
            }
            shift=shift.next;
            lists[minIndex]=shift;
            //System.out.println(empty); 
            min=100001;
            minIndex=-1;
        }
        return sentinel.next;
        
    }
}
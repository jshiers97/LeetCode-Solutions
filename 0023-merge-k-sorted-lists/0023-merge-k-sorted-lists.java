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
        ListNode sent=new ListNode(-1);
        ListNode ret=sent;
        int max=Integer.MAX_VALUE;
        int index=-1;
        
        
        while(true){
            for(int i=0; i<lists.length; i++){
                if(lists[i]==null){
                    continue;
                }
                if(lists[i].val < max){
                    max=lists[i].val;
                    index=i; 

                }
            }
            if(index==-1){
                break;
            }
            else{
                ListNode insert=new ListNode(max);
                sent.next=insert;
                sent=insert;
                lists[index]=lists[index].next;
                index=-1;
                max=Integer.MAX_VALUE;
            }
        }
        return ret.next;
        
    }
}
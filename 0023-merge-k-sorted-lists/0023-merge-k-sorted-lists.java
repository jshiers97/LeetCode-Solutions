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
        if(lists.length==0){
            return null; 
        }
        int interval=1; 
        while(interval < lists.length){
            for(int i=0; i+interval < lists.length; i=i+interval*2){
                lists[i]=mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval=interval*2;
        }
        return lists[0];
        
        
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode sent=new ListNode(-1);
        ListNode ret=sent;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                sent.next=l2;
                sent=l2;
                l2=l2.next;
            }
            else{
                sent.next=l1;
                sent=l1;
                l1=l1.next;
            }
        }
        if(l1!=null){
            sent.next=l1;
            
        }
        else if(l2!=null){
            sent.next=l2; 
        }
        return ret.next; 
    }
}
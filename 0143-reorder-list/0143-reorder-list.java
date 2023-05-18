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
    public void reorderList(ListNode head) {
        
        ListNode l1=head;
        ListNode l2=head.next;
        ListNode sent1=l1;
        ListNode sent2=l2; 
        int count=0;
        while(l1!=null){
            count++;
            l1=l1.next;
        }
        if(count==1 || count==2){
            return;
        }
        count/=2;
        
        l1=sent1;
        System.out.println(count); 
        for(int i=0; i<count; i++ ){
            l1=l1.next;
        }
        l2=l1.next;
        l1.next=null;
        sent2=l2;
        //System.out.println(sent1.next.val);
        Stack<ListNode> stack=new Stack<>();
        while(sent2!=null){
            stack.push(sent2);
            sent2=sent2.next;
        }
        //System.out.println(stack.peek().val);
        while(sent1!=null){
            ListNode temp=sent1.next;
            if(temp==null){
                break;
            }
            ListNode n=null;
            if(!stack.isEmpty()){
                n=stack.pop(); 
                sent1.next=n;
                n.next=temp;
                sent1=temp;
                
            }
            else{
                temp.next=null;
                break;
            }
            
            
        }
    }
}
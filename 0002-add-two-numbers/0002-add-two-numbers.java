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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> stack1=new LinkedList<>();
        Queue<Integer> stack2=new LinkedList<>();
        while(l1!=null){
            stack1.offer(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.offer(l2.val);
            l2=l2.next;
        }
        
        int sum=0;
        int carry=0;
        ListNode returner=new ListNode();
        ListNode head=returner;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int x=0;
            int y=0;
            if(!stack1.isEmpty()){
                x=stack1.poll();
            }
            if(!stack2.isEmpty()){
                y=stack2.poll();
            }
            
            int z=x+y + carry;
            carry=0;
            
            if(z>9){
                carry=1;
                z%=10;
            }
            ListNode insert=new ListNode(z);
            head.next=insert;
            head=insert;
            

        }
        
        if(carry==1){
            ListNode insert=new ListNode(1);
            head.next=insert;
            head=insert;
        }
        
        
        return returner.next;
    }
}
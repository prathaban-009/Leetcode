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
        ListNode fast=head;
        ListNode slow=head;
        int n1=0;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            n1++;
        }

       
        ListNode prev = null;
        ListNode curr = head;

        for(int i=0;i<n1;i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head1=prev;
        int max=Integer.MIN_VALUE;
        while(head1!=null && slow!=null)
        {
            int sum=head1.val+slow.val;
            // System.out.println("pair:"+head1.val+":"+slow.val+" Sum:"+sum);
            max=Math.max(sum,max);
            head1=head1.next;
            slow=slow.next;
        }


        // System.out.println(n1);

        return max;
    }
}
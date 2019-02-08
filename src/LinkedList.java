//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

}

public class LinkedList {
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode current = null;
        ListNode head = new ListNode(-1);
        current = head;
        while (true){
            if(l1==null){
                current.next = l2;
                break;
            }
            if(l2==null){
                current.next = l1;
                break;
            }
            if(l1.val<=l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            if(l2.val>=l1.val){
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        return head.next;
    }
}

package linkedlist;
class SinglyLinkedListNode{
    int data;
    SinglyLinkedListNode next;
}
public class Reverse {
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head){
        SinglyLinkedListNode previous = null;
        while(head!=null){
            SinglyLinkedListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        return previous;
    }
}

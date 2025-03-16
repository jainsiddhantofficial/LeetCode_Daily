/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;
            if (curr.val == nextNode.val) {
                while (nextNode != null && curr.val == nextNode.val) {
                    curr = curr.next;
                    nextNode = curr.next;
                }
                prev.next = nextNode;
            } else {
                prev = prev.next;
            }
            curr = curr.next;

            
        }
        return dummy.next;

    }

    public ListNode deleteDuplicatesWithoutDummy(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode currNode = head, prevNode = null;
        while (currNode != null && currNode.next != null) {
            ListNode nextNode = currNode.next;
            if (currNode.val != nextNode.val) {
                prevNode = currNode;
                currNode = currNode.next;
            } else {
                while (nextNode != null && currNode.val == nextNode.val) {
                    nextNode = nextNode.next;
                }
                if (prevNode == null)
                    head = nextNode;
                else
                    prevNode.next = nextNode;
                currNode = nextNode;
            }
        }
        return head;
    }
}
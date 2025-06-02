class Solution {
    public void reorderList(ListNode head) {
        // 1. Find the middle of the linked list. \U0001f6b6‍♂️
        ListNode middle = getMiddle(head);

        // 2. Split the linked list into two halves. The second half starts after the middle. ✂️
        ListNode half = middle.next; // 'half' is the head of the second half.
        middle.next = null; // Break the connection between the first and second halves.

        // 3. Reverse the second half of the linked list. \U0001f504
        ListNode reversedHalf = reverseList(half);

        // 4. Merge the first half with the reversed second half. \U0001f517
        mergedList(head, reversedHalf);
    }

    // Helper method to reverse a linked list.
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize the previous node to null.
        ListNode current = head; // Start from the head of the list.
        ListNode next = null; // Placeholder for the next node.

        // Iterate through the list.
        while (current != null) {
            next = current.next; // Store the next node.
            current.next = prev; // Reverse the pointer of the current node.
            prev = current; // Move the previous node to the current node.
            current = next; // Move the current node to the next node.
        }

        return prev; // Return the new head of the reversed list.
    }

    // Helper method to find the middle of a linked list using the slow and fast pointer approach.
    private static ListNode getMiddle(ListNode head) {
        if (head == null) { // If the list is empty, return null.
            return null;
        }

        ListNode slow = head; // Slow pointer moves one step at a time.
        ListNode fast = head; // Fast pointer moves two steps at a time.

        // Iterate through the list until the fast pointer reaches the end.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // Move the slow pointer one step.
            fast = fast.next.next; // Move the fast pointer two steps.
        }

        return slow; // Return the middle node (slow pointer).
    }

    // Helper method to merge two linked lists alternately.
    private void mergedList(ListNode first, ListNode second) {
        ListNode firstPtr = first; // Pointer for the first list.
        ListNode secondPtr = second; // Pointer for the second list.
        ListNode firstNext, secondNext; // Placeholders to store next nodes.

        // Iterate through both lists until one of them reaches the end.
        while (firstPtr != null && secondPtr != null) {
            firstNext = firstPtr.next; // Store the next node of the first list.
            secondNext = secondPtr.next; // Store the next node of the second list.

            firstPtr.next = secondPtr; // Link the first list to the second list.
            secondPtr.next = firstNext; // Link the second list back to the first list.

            firstPtr = firstNext; // Move the first pointer to the next node.
            secondPtr = secondNext; // Move the second pointer to the next node.
        }
    }
}
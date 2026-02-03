package reverse.linkedlist;
/*
    92. Reverse Linked List II
    https://leetcode.com/problems/reverse-linked-list-ii/description/
    
    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

    Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]

 */
*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LC92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode helperNode = new ListNode(0);
        ListNode prev = null, curr, next, start, end;
        helperNode.next = head;
        start = helperNode;

        for (int i=1; i<left; i++) {
            start = start.next;
        }

        curr = start.next;
        prev = null;
        end = curr;

        for (int i=0; i<(right-left + 1); i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start.next = prev;
        end.next = curr;

        return helperNode.next;
    }

    public static void main(String[] args) {
        LC92_ReverseLinkedListII solution = new LC92_ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2, right = 4;
        ListNode result = solution.reverseBetween(head, left, right);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

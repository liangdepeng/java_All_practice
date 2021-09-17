package ldp.letcode;

public class TestLinkList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;
            int count = 0;
            while (true) {
                if (a == b) {
                    return a;
                }

                if (a.next == null) {
                    if (++count == 2) {
                        return null;
                    }
                    a = headB;
                } else {
                    a = a.next;
                }


                if (b.next == null) {
                    b = headA;
                } else {
                    b = b.next;
                }

            }
        }
    }
}

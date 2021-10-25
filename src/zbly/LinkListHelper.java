package zbly;

public class LinkListHelper {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode listNode = reverseList(head.next);
        // 后一个 变成前一个
        head.next.next = head;
        // 前一个变后一个 引用重置null
        head.next = null;

        return listNode;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode last = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = last;
            last = cur;
            cur = tmp;
        }
        return last;
    }

    /**
     * 倒数第k个节点
     * <p>
     * 常规解法 栈 去解决 弹出第k个即可
     * <p>
     * 双指针如下 快指针先跑k个 则剩下的路为 n-k  然后慢指针开始跑 刚好跑到 n-k 倒数第k个
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(-1);

        ListNode listNode = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return listNode.next;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int[] nums = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            nums[i] = head.val;
            head = head.next;
        }

        return nums;
    }
}

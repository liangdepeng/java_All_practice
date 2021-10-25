package zzzzin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class DataHelper {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 倒数第k个节点 快慢指正
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    // 翻转链表
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode listNode = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
    // 翻转链表
    public ListNode ReverseList2(ListNode head) {
        // 前一个 ，当前的
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
    // 合并 递增链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode node = listNode;
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

        return listNode.next;
    }
    // 链表公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        if (pHead1 == pHead2)
            return pHead1;

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (pHead1 != pHead2) {
            if (pHead1 == null)
                pHead1 = p2;
            else
                pHead1 = pHead1.next;
            if (pHead2 == null)
                pHead2 = p1;
            else
                pHead2 = pHead2.next;
        }
        return pHead1;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 层序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        linkedList.offer(root);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            if (node.left != null) {
                linkedList.offer(node.left);
            }
            if (node.right != null) {
                linkedList.offer(node.right);
            }
            arrayList.add(node.val);
        }

        return arrayList;
    }
    // 层序遍历升级版
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>(new ArrayList<>());
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(pRoot);

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
                list.add(node.val);
            }
            arrayList.add(list);
        }

        return arrayList;
    }

}

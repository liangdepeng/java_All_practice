package ldp.letcode;

import ldp.utils.SystemOutputUtils;

import java.util.Stack;

public class TestTwo {
    public static void main(String[] args) {
        SystemOutputUtils.println(new Solution().fib2(45));
        SystemOutputUtils.println(new Solution().fib(10));

        SystemOutputUtils.println(new Solution2().numWays2(5));
        SystemOutputUtils.println(new Solution2().numWays(5));
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     */

    static class Solution {
        // 递归
        public int fib(int n) {
            if (n <= 1)
                return n;
            return fib(n - 1) + fib(n - 2);
        }

        // 递推
        public int fib2(int n) {
            if (n <= 1)
                return n;
            int fn_1 = 1;
            int fn_2 = 0;
            int fn = 0;
            for (int i = 2; i <= n; i++) {
                fn = fn_1 + fn_2;
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return fn;
        }



    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     */

    static class Solution2 {

        public int numWays2(int n) {
            int a = 1, b = 1, sum;
            for (int i = 0; i < n; i++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }

        public int numWays(int n) {
            if (n <= 1) {
                return n;
            }

            int fn_2 = 1;
            int fn_1 = 1;
            int fn = 0;

            for (int i = 2; i <= n; i++) {
                fn = (fn_1 + fn_2) % 1000000007;
                fn_2 = fn_1;
                fn_1 = fn;
            }

            return fn;
        }
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
     * 输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     */

    class Solution3 {

        public int minArray(int[] numbers) {

            if (numbers == null || numbers.length == 0)
                return 0;

            if (numbers.length == 1)
                return numbers[0];

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return numbers[i + 1];
                }
            }
            return numbers[0];
        }
    }


    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * <p>
     * 返回删除后的链表的头节点。
     * <p>
     * 注意：此题对比原题有改动
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution4 {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode listNode = head;

            if (listNode == null)
                return null;

            if (listNode.val == val)
                return listNode.next;

            while (true) {

                if (listNode.next == null)
                    break;

                if (listNode.next.val == val) {
                    listNode.next = listNode.next.next;
                    break;
                }

                listNode = listNode.next;
            }

            return head;
        }
    }

    /**
     * 找出倒数第k个节点
     */
    class Solution5 {
        public ListNode getKthFromEnd(ListNode head, int k) {

            if (head == null) {
                return head;
            }

            if (head.next == null && k == 1) {
                return head;
            }

            Stack<ListNode> stack = new Stack();
            ListNode node = head;
            while (node != null) {
                stack.push(node);
                node = node.next;
            }

            if (stack.size() <= 0)
                return node;

            for (int i = 0; i < k; i++) {
                node = stack.pop();
            }

            return node;
        }
    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：nums =[1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
     */
    class Solution6 {
        public int[] exchange(int[] nums) {

            if (nums == null || nums.length <= 1)
                return nums;

            int i = 0;
            int index2 = nums.length - 1;

            while (true) {
                int head = nums[i];
                int last = nums[index2];

                boolean headIsJ = head % 2 != 0;
                boolean lastIsJ = last % 2 != 0;

                if (headIsJ && !lastIsJ) {
                    i++;
                    index2--;
                } else if (headIsJ && lastIsJ) {
                    i++;
                } else if (!headIsJ && lastIsJ) {
                    int temp = nums[i];
                    nums[i] = nums[index2];
                    nums[index2] = temp;
                    i++;
                    index2--;
                } else if (!headIsJ && !lastIsJ) {
                    index2--;
                }

                if (i >= index2)
                    break;
            }

            return nums;
        }

        public int[] exchange2(int[] nums) {

            if (nums == null || nums.length <= 1)
                return nums;

            int left = 0;
            int right = nums.length - 1;

            // 这个条件亚注意
            while (left < right) {

                if ((nums[left] & 1) != 0) {
                    left++;
                    continue;
                }

                if ((nums[right] & 1) == 0) {
                    right--;
                    continue;
                }

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }

            return nums;
        }
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
     *
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution7 {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode listNode = new ListNode(-1);

            ListNode node = listNode;

            while (l1 != null && l2 != null) {

                if (l1.val <= l2.val) {
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

        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

            ListNode node = new ListNode(-1);

            ListNode listNode = node;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
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
    }
}

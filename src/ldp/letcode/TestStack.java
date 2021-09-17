package ldp.letcode;

import java.util.HashSet;
import java.util.Stack;

public class TestStack {
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
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * <p>
     * 反转链表
     */
    static class Solution {
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }

        public static ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode cur = head;
            ListNode pre = null;
            ListNode next;

            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }

        // A->1  2-10 数字本身  J=11,Q=12,K=13 大小王 0  找顺子 5个连续的数字

        public static boolean tete(int[] nums) {

            HashSet<Integer> set = new HashSet<>();

            int min = 14;
            int max = 0;

            for (int num : nums) {
                if (num == 0)
                    continue;

                min = Math.min(num, min);
                max = Math.max(num, max);

                if (!set.add(num))
                    return false;

            }

            return max - min < 5;

        }


        /**
         * 1+2+3+4+...+n=?  不能用 乘除法 和 循环 语句
         */
        public static int sumNums(int n) {
            if (n == 1)
                return 1;
            return n + sumNums(n - 1);
        }


        public static int add(int a, int b) {
            if (b == 0)
                return a;
            return add(a ^ b, a & b << 1);
        }
    }

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     * 示例 2：
     * <p>
     * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     * 输出：false
     * 解释：1 不能在 2 之前弹出。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution2 {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
//            if (pushed == null || popped == null || pushed.length != popped.length)
//                return false;
//            int size = pushed.length;
//            for (int i = 0; i < size; i++) {
//                if (pushed[i] != popped[size - 1 - i])
//                    return false;
//            }


            /**
             * 模拟呀
             */
            Stack<Integer> integerStack = new Stack<>();
            int j = 0;
            for (int i = 0; i < pushed.length; i++) {
                integerStack.push(pushed[i]);

                while (!integerStack.isEmpty() && integerStack.peek() == popped[j]) {
                    integerStack.pop();
                    j++;
                }

            }

            return integerStack.isEmpty();
        }
    }
}

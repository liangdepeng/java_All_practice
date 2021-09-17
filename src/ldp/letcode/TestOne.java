package ldp.letcode;

import ldp.utils.SystemOutputUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TestOne {
    public static void main(String[] args) {
//        SystemOutputUtils.println(test(-1234567890));
//        SystemOutputUtils.println(test(1234567898));
//        SystemOutputUtils.println(test(12));
//        SystemOutputUtils.println(test(8));
//
//        SystemOutputUtils.println(reserve(-1234567890));
//        SystemOutputUtils.println(reserve(1234567898));
//        SystemOutputUtils.println(reserve(12));
//        SystemOutputUtils.println(reserve(8));

        //    SystemOutputUtils.println(new Solution2().replaceSpace("we are family . o  "));
        //   SystemOutputUtils.println(new Solution2().replaceSpace2("we are family . o  "));

//        ListNode node3 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node1 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//
//        SystemOutputUtils.printIntArray(new Solution3().reversePrint(node1));

        SystemOutputUtils.println(new String("lalalala".getBytes(StandardCharsets.UTF_8)));

    }

    public static int reserve(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && x % 10 > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && x % 10 < -8)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static int test(int x) {

        if (x > -10 && x < 10) {
            return x;
        }

        String value = String.valueOf(x);

        boolean isF = x < 0;

        if (isF) {
            value = value.replace("-", "");
        }

        char[] chars = value.toCharArray();

        Stack<Character> characterStack = new Stack<>();

        for (char item : chars) {
            characterStack.push(item);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            builder.append(characterStack.pop());
        }

        long aLong = Long.parseLong(builder.toString());

        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }

        if (isF) {
            return Integer.parseInt("-" + builder.toString());
        } else {
            return Integer.parseInt(builder.toString());
        }


    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     */

    class Solution {
        public int findRepeatNumber(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i]))
                    return nums[i];
            }
            return nums[0];
        }
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     */

    static class Solution2 {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    builder.append("%20");
                } else {
                    builder.append(chars[i]);
                }
            }
            return builder.toString();
        }

        public String replaceSpace2(String s) {
            char[] chars = new char[s.length() * 3];
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {

                    //error 这里不能用i ，i是遍历s用的

                    chars[j++] = '%';
                    chars[j++] = '2';
                    chars[j++] = '0';
                } else {
                    chars[j++] = c;
                }
            }
            return new String(chars, 0, j);
        }
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution3 {

        public int[] reversePrint(ListNode head) {

            // 注意判空

            if (head == null) {
                return new int[]{};
            }
            if (head.next == null) {
                return new int[]{head.val};
            }


            Stack<Integer> stack = new Stack<>();
            ListNode item = head;
            while (true) {
                stack.push(item.val);
                if (item.next == null)
                    break;
                item = item.next;
            }

            int count = stack.size();
            int[] nums = new int[count];

            // 跳出循环的条件不能用 stack.size() 会变化

            for (int i = 0; i < count; i++) {
                nums[i] = stack.pop();
            }

            return nums;
        }
    }


    class Solution4 {
        public char firstUniqChar(String s) {

            if (s == null || s.equals(" ") || s.equals(""))
                return ' ';

            LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (linkedHashMap.containsKey(c)) {
                    linkedHashMap.put(c, linkedHashMap.get(c) + 1);
                } else {
                    linkedHashMap.put(c, 1);
                }
            }

            for (Map.Entry<Character, Integer> item : linkedHashMap.entrySet()) {
                if (item != null && item.getValue() == 1)
                    return item.getKey();
            }

            return ' ';
        }
    }
}

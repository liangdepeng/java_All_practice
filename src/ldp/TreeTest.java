package ldp;

import ldp.utils.SystemOutputUtils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {

    static TreeNode treeNode;

    public static void main(String[] args) {

        testPrintTreeFirst(getTestTree());
        SystemOutputUtils.println("--");

        testPrintTreeMiddle(getTestTree());
        SystemOutputUtils.println("--");

        testPrintTreeLast(getTestTree());
        SystemOutputUtils.println("--");

        ceng(getTestTree());
        SystemOutputUtils.println("--");

    }

    /**
     * 前序遍历
     */
    public static void testPrintTreeFirst(TreeNode treeNode) {
        if (treeNode == null)
            return;

        System.out.print(treeNode.value + "  ");

        if (treeNode.leftNode != null) {
            testPrintTreeFirst(treeNode.leftNode);
        }

        if (treeNode.rightNode != null) {
            testPrintTreeFirst(treeNode.rightNode);
        }

    }

    /**
     * 中序遍历
     */
    public static void testPrintTreeMiddle(TreeNode treeNode) {
        if (treeNode == null)
            return;

        if (treeNode.leftNode != null) {
            testPrintTreeMiddle(treeNode.leftNode);
        }

        System.out.print(treeNode.value + "  ");

        if (treeNode.rightNode != null) {
            testPrintTreeMiddle(treeNode.rightNode);
        }

    }

    /**
     * 后序遍历
     */
    public static void testPrintTreeLast(TreeNode treeNode) {
        if (treeNode == null)
            return;

        if (treeNode.leftNode != null) {
            testPrintTreeLast(treeNode.leftNode);
        }

        if (treeNode.rightNode != null) {
            testPrintTreeLast(treeNode.rightNode);
        }

        System.out.print(treeNode.value + "  ");

    }

    /**
     * 生成这样的一棵树
     * <p>
     * **********  10
     * /    \
     * 9      13
     * /       /  \
     * 7       14   16
     * /  \            \
     * 5    6           20
     * /
     * 2
     */
    public static TreeNode getTestTree() {
        if (treeNode == null) {
            treeNode = new TreeNode();
            TreeNode treeNode2 = new TreeNode();
            TreeNode treeNode3 = new TreeNode();
            TreeNode treeNode4 = new TreeNode();
            TreeNode treeNode5 = new TreeNode();
            TreeNode treeNode6 = new TreeNode();
            TreeNode treeNode7 = new TreeNode();
            TreeNode treeNode8 = new TreeNode();
            TreeNode treeNode9 = new TreeNode();
            TreeNode treeNode10 = new TreeNode();
            treeNode.value = 10;
            treeNode2.value = 9;
            treeNode3.value = 7;
            treeNode4.value = 6;
            treeNode5.value = 5;
            treeNode6.value = 2;
            treeNode7.value = 13;
            treeNode8.value = 16;
            treeNode9.value = 14;
            treeNode10.value = 20;

            treeNode.leftNode = treeNode2;
            treeNode.rightNode = treeNode7;

            treeNode2.leftNode = treeNode3;

            treeNode3.leftNode = treeNode5;
            treeNode3.rightNode = treeNode4;

            treeNode5.leftNode = treeNode6;

            treeNode7.leftNode = treeNode9;
            treeNode7.rightNode = treeNode8;

            treeNode8.rightNode = treeNode10;

            TreeNode treeNode = lowestCommonAncestor(TreeTest.treeNode, treeNode4, treeNode6);
            SystemOutputUtils.println(treeNode.value);
        }


        return treeNode;
    }

    public static class TreeNode {
        public int value;
        public TreeNode leftNode;
        public TreeNode rightNode;
    }

    /**
     * 层序遍历
     */
    public static void ceng(TreeNode treeNode) {

        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);

        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.poll();
            System.out.print(node.value + "  ");

            if (node.leftNode != null) {
                linkedList.offer(node.leftNode);
            }

            if (node.rightNode != null) {
                linkedList.offer(node.rightNode);
            }
        }

    }

    /**
     * 两个 节点的最近 公共节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.leftNode, p, q);
        TreeNode r = lowestCommonAncestor(root.rightNode, p, q);

        if (l == null) {
            return r;
        }

        if (r == null) {
            return l;
        }

        return root;

        //  return l == null ? r : (r == null ? l : root);
    }

    public int maxProfit(int[] prices) {
        // 定义买的钱，利润 力求 最小的花费，最大的利润
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            // 找最小的花费
            cost = Math.min(cost, price);
            // 找最大的收益
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

}

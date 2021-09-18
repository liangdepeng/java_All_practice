package zbly;

import ldp.utils.SystemOutputUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNodeHelper {

    private static TreeNode treeNode;

    public static void main(String[] args) {

        qianxu(getTestTree());
        SystemOutputUtils.println(" ");
        qianxu22(getTestTree());
        SystemOutputUtils.println(" ");
        SystemOutputUtils.println(" ");

        zhongxu(getTestTree());
        SystemOutputUtils.println(" ");
        zhongxu222(getTestTree());
        SystemOutputUtils.println(" ");
        SystemOutputUtils.println(" ");

        houxu(getTestTree());
        SystemOutputUtils.println(" ");
        SystemOutputUtils.println(" ");

        cengxu(getTestTree());
        SystemOutputUtils.println(" ");
        cengxu222fenzu(getTestTree());
    }

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     * *  4
     * * /  \
     * *2  * 7
     * / \  / \
     * 1  3 6 9
     * 镜像输出：
     * <p>
     * *  4
     * * /  \
     * *7   2
     * / \  / \
     * 9  6 3 1
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    /**
     * 判断二叉树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null || l.val != r.val)
            return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }

    /**
     * 生成这样的一棵树
     * <p>
     * * ***10
     * * /   ** \
     * 9   ***  13
     * /  ***  /  \
     * 7  ** 14   16
     * / \    **   \
     * 5  6   ***   20
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
            treeNode.val = 10;
            treeNode2.val = 9;
            treeNode3.val = 7;
            treeNode4.val = 6;
            treeNode5.val = 5;
            treeNode6.val = 2;
            treeNode7.val = 13;
            treeNode8.val = 16;
            treeNode9.val = 14;
            treeNode10.val = 20;

            treeNode.left = treeNode2;
            treeNode.right = treeNode7;

            treeNode2.left = treeNode3;

            treeNode3.left = treeNode5;
            treeNode3.right = treeNode4;

            treeNode5.left = treeNode6;

            treeNode7.left = treeNode9;
            treeNode7.right = treeNode8;

            treeNode8.right = treeNode10;

            //  SystemOutputUtils.println(treeNode.value);
        }


        return treeNode;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void qianxu(TreeNode treeNode) {
        if (treeNode == null)
            return;

        SystemOutputUtils.print(treeNode.val);
        SystemOutputUtils.print("  ");

        if (treeNode.left != null) {
            qianxu(treeNode.left);
        }

        if (treeNode.right != null) {
            qianxu(treeNode.right);
        }
    }

    // 非递归先序
    public static void qianxu22(TreeNode treeNode) {
        if (treeNode == null)
            return;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(treeNode);

        // 前序遍历 先添加右节点 后添加左节点 遍历的时候将会先出栈左节点
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            SystemOutputUtils.print(node.val + "  ");

            if (node.right != null) {
                nodeStack.push(node.right);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
    }

    public static void zhongxu(TreeNode treeNode) {
        if (treeNode == null)
            return;

        if (treeNode.left != null) {
            zhongxu(treeNode.left);
        }

        SystemOutputUtils.print(treeNode.val);
        SystemOutputUtils.print("  ");

        if (treeNode.right != null) {
            zhongxu(treeNode.right);
        }
    }

    public static void zhongxu222(TreeNode treeNode) {

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = treeNode;

        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }

            if (!nodes.isEmpty()) {
                node = nodes.pop();
                SystemOutputUtils.print(node.val + "  ");
                node = node.right;
            }
        }

    }

    public static void houxu(TreeNode treeNode) {
        if (treeNode == null)
            return;

        if (treeNode.left != null) {
            houxu(treeNode.left);
        }

        if (treeNode.right != null) {
            houxu(treeNode.right);
        }

        SystemOutputUtils.print(treeNode.val);
        SystemOutputUtils.print("  ");
    }

    public static void cengxu(TreeNode treeNode) {
        if (treeNode == null)
            return;

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            SystemOutputUtils.print(node.val + "   ");

            if (node.left != null) {
                linkedList.offer(node.left);
            }

            if (node.right != null) {
                linkedList.offer(node.right);
            }
        }
    }

    /**
     * 分组层序遍历 一次找出最大深度和宽度
     *
     * @param treeNode
     */
    public static void cengxu222fenzu(TreeNode treeNode) {

        if (treeNode == null)
            return;

        int maxWidth = 0;
        int maxHeight = 0;

        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);
        while (!linkedList.isEmpty()) {

            int size = linkedList.size();
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();

                if (node.left != null) {
                    linkedList.offer(node.left);
                }

                if (node.right != null) {
                    linkedList.offer(node.right);
                }

                arrayList.add(node.val);
                SystemOutputUtils.print(node.val + "  ");
            }

            maxWidth = Math.max(maxWidth, arrayList.size());

            list.add(arrayList);
        }

        maxHeight = list.size();

        SystemOutputUtils.println(" ");
        SystemOutputUtils.println("最大宽度 " + maxWidth + "  最大深度 " + maxHeight);
    }

}

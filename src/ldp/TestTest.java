package ldp;



import ldp.utils.SystemOutputUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestTest {
    public static void main(String[] args) {
        //  SystemOutputUtils.println(buildVersionCode());

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        hashMap.put(1, 2);
        hashMap.put(2, null);// null 在
        hashMap.put(3, null);
        hashMap.put(4, null);
        hashMap.put(null, 10);
        hashMap.put(null, 100);

        SystemOutputUtils.println(hashMap.get(null));
        SystemOutputUtils.println(hashMap.get(1));
        SystemOutputUtils.println(hashMap.get(2));
        SystemOutputUtils.println(hashMap.get(3));
        SystemOutputUtils.println(hashMap.get(4));

        SystemOutputUtils.println(hashMap.get(2) == hashMap.get(3));
        SystemOutputUtils.println(" ");

        Hashtable<Object, Object> hashtable = new Hashtable<>();

        //       hashtable.put(null,1); error
//        hashtable.put(1,2);
//        hashtable.put(2,null); error
//        hashtable.put(3,null); error

//        SystemOutputUtils.println(hashtable.get(null));
//        SystemOutputUtils.println(hashtable.get(1));
//        SystemOutputUtils.println(hashtable.get(2));
//        SystemOutputUtils.println(hashtable.get(3));

//        HashSet<Object> hashSet = new HashSet<>();
//
//        SystemOutputUtils.println(hashSet.add(0));
//        SystemOutputUtils.println(hashSet.add(1));
//        SystemOutputUtils.println(hashSet.add(2));
//        SystemOutputUtils.println(hashSet.add(2));
//        SystemOutputUtils.println(hashSet.add(2));
//
//        SystemOutputUtils.println(strToInt("-1231 wee 11"));
//        SystemOutputUtils.println(strToInt("1231312312312312"));
//        SystemOutputUtils.println(strToInt("     -1123213213213123 wee 11"));
//        SystemOutputUtils.println(strToInt("      wee 11"));
//        SystemOutputUtils.println(strToInt("1-1"));
//        SystemOutputUtils.println(strToInt("-91283472332"));
//        SystemOutputUtils.println(strToInt("   +0 123"));
//        SystemOutputUtils.println(strToInt("-2147483647"));
//        SystemOutputUtils.println(strToInt("2147483648"));
//        SystemOutputUtils.println(Integer.MIN_VALUE);

        //     SystemOutputUtils.printIntArray(constructArr(new int[]{1, 2, 0, 4, 0}));

        SystemOutputUtils.println(reverseWords("  i ww world!  the    "));

        SystemOutputUtils.println(minNumber2(new int[]{3, 30, 34, 5, 9}));

        SystemOutputUtils.printIntArray(singleNumbers(new int[]{4, 1, 4, 6}));

        SystemOutputUtils.println("  ");

        SystemOutputUtils.println(divide(15, 2));
        SystemOutputUtils.println(divide(7, -3));
        SystemOutputUtils.println(divide(0, 1));
        SystemOutputUtils.println(divide(-2147483648, -1));


        SystemOutputUtils.println(" ");
        SystemOutputUtils.println(" ");
        SystemOutputUtils.println(" ");
        SystemOutputUtils.println("----- ");
        SystemOutputUtils.println("----- ");


        double res = 5000;
        for (int i = 0; i < 16; i++) {
            res = res * 1.05;
        }
        SystemOutputUtils.println(res);

    }

    /**
     * SystemOutputUtils.println(strToInt("-1231 wee 11"));
     * SystemOutputUtils.println(strToInt("1231312312312312"));
     * SystemOutputUtils.println(strToInt("     -1123213213213123 wee 11"));
     * SystemOutputUtils.println(strToInt("      wee 11"));
     * SystemOutputUtils.println(strToInt("1-1"));
     * SystemOutputUtils.println(strToInt("-91283472332"));
     * SystemOutputUtils.println(strToInt("   +0 123"));
     * SystemOutputUtils.println(strToInt("-2147483647"));
     * SystemOutputUtils.println(strToInt("2147483648"));
     * <p>
     * 转换数字
     */
    public static int strToInt(String str) {

        long res = 0;

        if (str == null || "".equals(str))
            return 0;

        char[] array = str.toCharArray();

        if (array.length == 0) {
            return 0;
        }

        boolean isFirst = true;
        int sign = 1;

        for (int i = 0; i < array.length; i++) {

            if (isFirst && ' ' == array[i])
                continue;

            if (isFirst && ('-' == array[i] || '+' == array[i] || (array[i] >= '0' && array[i] <= '9'))) {
                isFirst = false;
                if ('-' == array[i]) {
                    sign = -1;
                    continue;
                } else if ('+' == array[i]) {
                    continue;
                }
            }

            if (array[i] < '0' || array[i] > '9')
                break;

            if (sign == -1 && res * sign < Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
                break;
            }

            if (res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }

            res = res * 10 + (array[i] - '0');
        }

        if (sign == 1 && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign == -1 && res * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return res < 0 ? (int) res : (int) (res * sign);


    }

    public double[] dicesProbability(int n) {
        //因为最后的结果只与前一个动态转移数组有关，所以这里只需要设置一个一维的动态转移数组
        //原本dp[i][j]表示的是前i个骰子的点数之和为j的概率，现在只需要最后的状态的数组，所以就只用一个一维数组dp[j]表示n个骰子下每个结果的概率。
        //初始是1个骰子情况下的点数之和情况，就只有6个结果，所以用dp的初始化的size是6个
        double[] dp = new double[6];
        //只有一个数组
        Arrays.fill(dp, 1.0 / 6.0);
        //从第2个骰子开始，这里n表示n个骰子，先从第二个的情况算起，然后再逐步求3个、4个···n个的情况
        //i表示当总共i个骰子时的结果
        for (int i = 2; i <= n; i++) {
            //每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            //比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            //当有i个骰子时的点数之和的值数组先假定是temp
            double[] temp = new double[5 * i + 1];
            //从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
            //先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值
            for (int j = 0; j < dp.length; j++) {
                //比如只有1个骰子时，dp[1]是代表当骰子点数之和为2时的概率，它会对当有2个骰子时的点数之和为3、4、5、6、7、8产生影响，因为当有一个骰子的值为2时，另一个骰子的值可以为1~6，产生的点数之和相应的就是3~8；比如dp[2]代表点数之和为3，它会对有2个骰子时的点数之和为4、5、6、7、8、9产生影响；所以k在这里就是对应着第i个骰子出现时可能出现六种情况，这里可能画一个K神那样的动态规划逆推的图就好理解很多
                for (int k = 0; k < 6; k++) {
                    //这里记得是加上dp数组值与1/6的乘积，1/6是第i个骰子投出某个值的概率
                    temp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
            //i个骰子的点数之和全都算出来后，要将temp数组移交给dp数组，dp数组就会代表i个骰子时的可能出现的点数之和的概率；用于计算i+1个骰子时的点数之和的概率
            dp = temp;
        }
        return dp;
    }

    // [1, 2, 0, 4, 0]
    public static int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];
        int[] nums = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            nums[i] = calculate(a, a[i], i);
        }
        return nums;
    }

    public static int calculate(int[] a, int b, int index) {
        int res = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                return 0;
            if (a[i] == b && i == index)
                continue;
            if (a[i] == 1)
                continue;
            res = res * a[i];
        }
        return res;
    }


    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static ArrayList<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return 0;
        query(root);
        return list.get(list.size() - k);
    }

    public static void query(TreeNode treeNode) {
        if (treeNode.left != null) {
            query(treeNode.left);
        }
        list.add(treeNode.val);
        if (treeNode.right != null) {
            query(treeNode.right);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (hashSet.contains(c)) {
                hashSet.remove(s.charAt(l++));
            }
            hashSet.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // 缺第一个
        if (nums[0] != 0)
            return 0;
        // 缺中间的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        // 缺最后一个
        return nums[nums.length - 1] + 1;
    }

    // 左旋字符串
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0)
            return null;
        char[] array = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = n; i < array.length; i++) {
            str.append(array[i]);
        }
        for (int i = 0; i < n; i++) {
            str.append(array[i]);
        }
        return str.toString();
    }

    // hello world! -> world! hello
    public static String reverseWords(String s) {
        int hashKey = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();
        StringBuilder str = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (str != null) {
                    hashMap.put(hashKey++, str.toString());
                    str = null;
                }
            } else {
                if (str == null)
                    str = new StringBuilder();
                str.append(c);
                if (i == s.length() - 1) {
                    hashMap.put(hashKey++, str.toString());
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = hashKey - 1; i >= 0; i--) {
            res.append(hashMap.get(i));
            if (i != 0) {
                res.append(' ');
            }
        }
        return res.toString();
    }

    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<>();
            //
            //🧠里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
            //套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
            //当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
            for (int l = 1, r = 1, sum = 0; r < target; r++) {
                sum += r;
                while (sum > target) {
                    sum -= l++;
                }
                if (sum == target) {
                    int[] temp = new int[r - l + 1];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = l + i;
                    }
                    list.add(temp);
                }
            }

            int[][] res = new int[list.size()][];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }


    // 左上到右下取最大值
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // 左上角初始值
        dp[0][0] = grid[0][0];

        // 第一竖
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 第一横
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 其他
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    // 数字 最多两个 与 26个英文字母互换 类似跳台阶
    public int translateNum(int num) {
        String value = String.valueOf(num);
        int[] dp = new int[value.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= value.length(); i++) {
            String tmpStr = value.substring(i - 2, i);

            if (tmpStr.compareTo("10") >= 0 && tmpStr.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[value.length() - 1];
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        for (int l = 1, r = 1; r < target; r++) {
            sum = sum + r;
            while (sum > target) {
                sum = sum - l++;
            }
            if (sum == target) {
                int[] ints = new int[r - l + 1];
                for (int i = 0; i < ints.length; i++) {
                    ints[i] = l + i;
                }
                list.add(ints);
            }

        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static String minNumber(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;
        if (nums.length == 1)
            return String.valueOf(nums[0]);

        boolean isSort = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort)
                break;
        }

        if (nums[0] == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    int temp = nums[i];
                    nums[i] = nums[0];
                    nums[0] = temp;
                    break;
                }
            }
        }

        char[] chars = new char[nums.length];

        for (int i = 0; i < nums.length; i++) {
            chars[i] = (char) (nums[i] + '0');
        }

        return new String(chars);
    }

    // 冒泡排序 String compareTo
    public static String minNumber2(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        if (nums.length == 1)
            return String.valueOf(nums[0]);

        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }

        boolean isSort = false;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if ((list[j] + list[j + 1]).compareTo(list[j + 1] + list[j]) > 0) {
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort)
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String item : list) {
            stringBuilder.append(item);
        }

        return stringBuilder.toString();
    }

    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] > nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i = i + 3) {
            if (i == nums.length - 1) {
                return nums[nums.length - 1];
            }

            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return 0;
    }

    // 2个不重复的数字
    public static int[] singleNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length == 1)
            return nums;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] > nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int[] ints = new int[2];
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 && nums[0] != nums[1]) {
                ints[index++] = nums[0];
                continue;
            }

            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                ints[index++] = nums[i];
            }

            if (i == nums.length - 2 && nums[i] != nums[i + 1]) {
                ints[index++] = nums[i + 1];
            }
        }

        return ints;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void cengNode(TreeNode treeNode) {
        if (treeNode == null) return;

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            SystemOutputUtils.println(node.val);
            if (node.left != null)
                linkedList.offer(node.left);
            if (node.right != null)
                linkedList.offer(node.right);
        }
    }

    public void cengNodeSave(TreeNode treeNode) {
        if (treeNode == null) return;

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(treeNode);

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                SystemOutputUtils.println(node.val);
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
    }


    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfss(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    public void dfss(TreeNode treeNode, int target) {
        if (treeNode == null) return;
        path.offerLast(treeNode.val);
        target -= treeNode.val;
        if (treeNode.left == null && treeNode.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfss(treeNode.left, target);
        dfss(treeNode.right, target);
        path.pollLast();
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0 || postorder.length == 1)
            return true;

        int rootVal = postorder[postorder.length - 1];

        boolean isRight = false;

        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] < rootVal) {
                if (isRight) {
                    return false;
                }
            } else {
                isRight = true;
            }
        }

        return func(postorder, 0, postorder.length - 1);
    }

    // 判断是否是 平衡二叉树 后序遍历
    public boolean func(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int m = i;
        //如： [1,3,2,6,5]，后序遍历 5是根节点，根节点左边的值应该都小于5，右边大于5
        //然后再对两部分递归
        while (postorder[m] < postorder[j]) m++;
        //检查从m到j是否存在小于postorder[j]的值
        for (int k = m; k < j; k++) {
            //从m到j存在小于postorder[j]的值,不符合二叉搜索树
            if (postorder[k] < postorder[j]) return false;
        }
        return func(postorder, i, m - 1) && func(postorder, m, j - 1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        return func(postorder, 0, postorder.length - 1);
    }

    // 之 字形 打印二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> mList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);

        while (!linkedList.isEmpty()) {

            int size = linkedList.size();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
                arr.add(node.val);
            }
            mList.add(arr);
        }

        for (int i = 1; i < mList.size(); i += 2) {
            Collections.reverse(mList.get(i));
        }

        return mList;
    }

    // 二叉树 层序遍历
    public int[] levelOrder3(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);

        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.poll();
            if (treeNode.left != null) {
                linkedList.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                linkedList.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    // 二叉树 层序遍历分组
    public List<List<Integer>> levelOrder4(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> mList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);

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
            }

            mList.add(arrayList);
        }

        return mList;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
//
//
//        示例 1：
//
//        输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//        输出：true
//        解释：我们可以按以下顺序执行：
//        push(1), push(2), push(3), push(4), pop() -> 4,
//                push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//        示例 2：
//
//        输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//        输出：false
//        解释：1 不能在 2 之前弹出。

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // 数组区间求最大值
    public int maxSubArray(int[] nums) {
//        int pre = 0, maxAns = nums[0];
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            maxAns = Math.max(maxAns, pre);
//        }
//        return maxAns;

//        int pre = 0, max = nums[0];
//        for (int num : nums) {
//            pre = Math.max(num, pre + num);
//            max = Math.max(pre, max);
//        }
//        return max;

//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int max = dp[0];
//        for(int i=1;i < nums.length;i++){
//            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
//            max = Math.max(max,dp[i]);
//        }
//        return max;

        int[] ints = new int[nums.length];
        ints[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < ints.length; i++) {
            ints[i] = Math.max(nums[i], ints[i - 1] + nums[i]);
            res = Math.max(ints[i], res);
        }

        return res;
    }

    class MinStack {

        public ArrayList<Integer> arrayList;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            arrayList = new ArrayList<>();
        }

        public void push(int x) {
            arrayList.add(x);
        }

        public void pop() {
            if (arrayList.size() > 0) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public int top() {
            if (arrayList.size() > 0) {
                return arrayList.get(arrayList.size() - 1);
            }
            return 0;
        }

        public int min() {
            if (arrayList.size() == 0)
                return 0;
            int min = arrayList.get(0);
            for (int i = 0; i < arrayList.size(); i++) {
                min = Math.min(min, arrayList.get(i));
            }
            return min;
        }
    }

//    int countDigitOne(int n) {
//
//        int num=n,i=1,s=0;
//
//        while(num)              //分别计算个、十、百......千位上1出现的次数，再求和。
//        {
//            if(num%10==0)
//                s=s+(num/10)*i;
//
//            if(num%10==1)
//                s=s+(num/10)*i+(n%i)+1;
//
//            if(num%10>1)
//                s=s+ceil(num/10.0)*i;
//
//            num=num/10;
//            i=i*10;
//        }
//        return s;
//    }

    // 前 k个小的数字
    // 利用冒泡排序 冒泡前k个小数
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0)
            return new int[0];
        if (arr.length == k)
            return arr;
        int[] nums = new int[k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            nums[i] = arr[arr.length - 1 - i];
            if (i == k - 1) {
                break;
            }
        }
        return nums;
    }

    // 复制复杂链表
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
//        for (Node node = head, copy = null; node != null; node = node.next.next) {
//            copy = new Node(node.val);
//            copy.next = node.next;
//            node.next = copy;
//        }
//        //把拷贝节点的random指针安排上
//        for (Node node = head; node != null; node = node.next.next) {
//            if (node.random != null) {
//                node.next.random = node.random.next;
//            }
//        }
//        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
//        Node newHead = head.next;
//        for (Node node = head, temp = null; node != null && node.next != null;) {
//            temp = node.next;
//            node.next = temp.next;
//            node = temp;
//        }
//
//        return newHead;
//    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;

        }

    }


    // 翻转链表
    public ListNode reverseList(ListNode head) {
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

    public ListNode reverseList2(ListNode head) {
//            ListNode last = null;
//            while (head != null) {
//                ListNode temp = head.next;
//                head.next = last;
//                last = head;
//                head = temp;
//            }
//            return last;

        ListNode lastNode = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = lastNode;
            lastNode = head;
            head = temp;
        }

        return lastNode;
    }

    // 按顺序打印出从 1 到最大的 n 位十进制数。
    // 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int max;
        if (n >= 10) {
            max = Integer.MAX_VALUE;
        } else {
            max = (int) Math.pow(10, n) - 1;
        }
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    // 2.00000
    //-2147483648
    public double myPow(double x, int n) {

        if (n == 0 || x == 1)
            return 1;

        double temp = x;
        int count = n;
        if (n < 0)
            count = n * (-1);

        for (int i = 1; i < count; i++) {
            x = x * temp;
        }

        if (n < 0) {
            return 1 / x;
        }

        return x;
    }

//    public String[] permutation(String s) {
//
//    }

//    public boolean isSymmetric(TreeNode root) {
//        return root == null ? true : recur(root.left, root.right);
//    }
//
//    boolean recur(TreeNode L, TreeNode R) {
//        if(L == null && R == null) return true;
//        if(L == null || R == null || L.val != R.val) return false;
//        // 左对应右
//        return recur(L.left, R.right) && recur(L.right, R.left);
//    }

    // 对称二叉树
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

    //
//    请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//    例如输入：
//
//               4
//             /   \
//            2     7
//           / \   / \
//          1   3 6   9
//    镜像输出：
//
//              4
//             /  \
//            7    2
//           / \   / \
//          9   6 3   1
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
    /*
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
    例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

       示例 1：
       输入: 2
       输出: 1
       解释: 2 = 1 + 1, 1 × 1 = 1

       示例 2:
       输入: 10
       输出: 36
       解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
       提示：

       2 <= n <= 58
    *
    * */

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }


    class CQueue {

        Stack<Integer> stack1, stack2;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.size() == 1)
                return stack1.pop();
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            return stack2.size() == 0 ? -1 : stack2.pop();
        }
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null, next, cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void quick(int[] nums, int L, int R) {

        int l = L, r = R;
        int pivot = nums[l];

        while (l < r) {

            while (l < r && nums[r] >= pivot) {
                r--;
            }

            if (l < r) {
                nums[l] = nums[r];
            }

            while (l < r && nums[l] <= pivot) {
                l++;
            }

            if (l < r) {
                nums[r] = nums[l];
            }

        }

        nums[l] = pivot;

        quick(nums, L, l - 1);
        quick(nums, l + 1, R);
    }


    /*
    /字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

       示例 1：
       输入: s = "abcdefg", k = 2
       输出:"cdefgab"

       示例 2：
       输入: s = "lrloseumgh", k = 6
       输出:"umghlrlose"

       限制：
       1 <= k < s.length <= 10000。
     */

    public static int buildVersionCode() {
        SimpleDateFormat df = new SimpleDateFormat("MMddHH");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return Integer.parseInt("143" + df.format(new Date()));
    }

    public static class View {
    }

    public static class ViewGroup extends View {
        public int getChildCount() {
            return 0;
        }

        public View getChildAt(int index) {
            return new View();
        }
    }

    // 安卓 遍历ViewGroup
    public int findViewCounts(View view) {
        int viewCounts = 0;
        if (view == null)
            return 0;

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View child = ((ViewGroup) view).getChildAt(i);
                if (child instanceof ViewGroup) {
                    viewCounts += findViewCounts(view);
                } else {
                    viewCounts++;
                }
            }
        } else {
            viewCounts++;
        }

        return viewCounts;
    }

//    第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
//
//    每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
//
//    返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
//
//
//    示例 1：
//
//    输入：people = [1,2], limit = 3
//    输出：1
//    解释：1 艘船载 (1, 2)
//    示例 2：
//
//    输入：people = [3,2,2,1], limit = 3
//    输出：3
//    解释：3 艘船分别载 (1, 2), (2) 和 (3)
//    示例 3：
//
//    输入：people = [3,5,3,4], limit = 5
//    输出：4
//    解释：4 艘船分别载 (3), (3), (4), (5)

    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    //  给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。

    public static int divide(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (b == 1)
            return a;
        if (b == -1) {
            if (a == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return -a;
        }


        boolean flag = true;
        if (a < 0 && b < 0) {
            a = -a;
            b = -b;
        } else if (a < 0 || b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
            flag = false;
        }
        int res = 0;
        while (a - b >= 0) {
            a = a - b;
            ++res;
        }
        return flag ? res : -res;
    }
}

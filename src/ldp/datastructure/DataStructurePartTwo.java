package ldp.datastructure;

import ldp.utils.SystemOutputUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 栈 -- 先进后出，后进先出
 *
 * 栈（stack）又称为堆栈或堆叠，栈作为一种数据结构，它按照先进后出的原则存储数据，先进入的数据被压入栈底，最后的数据在栈顶
 *
 * java中Stack是Vector的一个子类，只定义了默认构造函数，用来创建一个空栈。
 *
 * 栈是元素的集合，其包含了两个基本操作：push 操作可以用于将元素压入栈，pop 操作可以将栈顶元素移除。
 * 遵循后入先出（LIFO）原则。
 */
public class DataStructurePartTwo {

    private static final String[] s = new String[]{"test1", "test2", "test3", "test4", "test5", "testLast"};

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String item : s)
            stack.push(item);

        while (!stack.empty()) {
            String popItem = stack.pop();
            SystemOutputUtils.print(popItem + "  ");
        }

        SystemOutputUtils.println(" ");

        MyStack<String> myStack = new MyStack<>();
        for (String item : s)
            myStack.push(item);

        while (!myStack.isEmpty()) {
            String popItem = myStack.pop();
            SystemOutputUtils.print(popItem + "  ");
        }
    }

    /**
     * 实现一个简易的栈
     */
    public static class MyStack<T> {

        final ArrayList<T> arrayList;

        public MyStack() {
            arrayList = new ArrayList<>();
        }

        /**
         * 入栈
         */
        public synchronized void push(T obj) {
            arrayList.add(obj);
        }

        /**
         * 栈顶元素出栈 并且返回该元素
         */
        public synchronized T pop() {
            T obj = peek();
            arrayList.remove(obj);
            return obj;
        }

        /**
         * 返回栈顶元素
         */
        public synchronized T peek() {
            if (size() <= 0)
                return null;
            return arrayList.get(size() - 1);
        }

        /**
         * 是否为空
         */
        public synchronized boolean isEmpty() {
            return arrayList.size() == 0;
        }

        /**
         * 栈的大小
         */
        public synchronized int size() {
            return arrayList.size();
        }

    }
}

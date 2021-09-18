package zbly;

import java.util.Stack;

public class StackHelper {

    public static void main(String[] args) {

    }

    /**
     * 栈实现队列
     * <p>
     * * Your CQueue object will be instantiated and called as such:
     * * CQueue obj = new CQueue();
     * * obj.appendTail(value);
     * * int param_2 = obj.deleteHead();
     */

    class CQueue {

        private final Stack<Integer> stack1 = new Stack<>();
        private final Stack<Integer> stack2 = new Stack<>();

        public CQueue() {
        }

        public void appendTail(int value) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }

        public int deleteHead() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}

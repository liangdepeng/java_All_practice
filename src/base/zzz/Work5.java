package base.zzz;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Work5 {
    // 操作数栈
    private static Stack<Double> Num;
    // 操作符栈
    //
    private static Stack<Character> Symbols;
    // 操作符集合
    private static final Set<Character> C_Symbolset = new HashSet<Character>() {
        /**        * 		*/
        private static final long serialVersionUID = 1L;

        {
            add('+');
            add('-');
            add('*');
            add('/');
            add('^');
            add('(');
            add(')');
        }
    };

    private static int getOperatorPriority(char ch) {
        if (ch == '+' || ch == '-') return 0;
        else if (ch == '*' || ch == '/') return 1;
        else if (ch == '^') return 3;
        else return -1;
    }

    /**
     * 确认表达式的合法性
     * @param expression 表达式
     * @return
     */
    private static String infixToSuffix(String expression) {
        Symbols = new Stack<>();
        Symbols.clear();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') continue;
            if (C_Symbolset.contains(ch)) {
                if (Symbols.empty()) {
                    if (ch == ')') {
                        System.out.println("括号不匹配");
                        return sBuilder.toString();
                    }
                    Symbols.push(ch);
                } else if (ch == '(') {
                    Symbols.push(ch);
                } else if (ch == ')') {
                    char top;
                    while ((top = Symbols.peek()) != '(') {
                        if (Symbols.empty()) {
                            System.out.println("括号不匹配");
                            return sBuilder.toString();
                        }
                        sBuilder.append(top);
                        Symbols.pop();
                    }
                    Symbols.pop();
                } else {
                    char top = Symbols.peek();
                    if (getOperatorPriority(ch) <= getOperatorPriority(top)) {
                        while (!Symbols.empty() && getOperatorPriority(ch) <= getOperatorPriority(top = Symbols.peek())) {
                            sBuilder.append(top);
                            Symbols.pop();
                        }
                    }
                    Symbols.push(ch);
                }
            } else {
                sBuilder.append("[" + ch);
                while (i + 1 < expression.length() && (((ch = expression.charAt(i + 1)) == '.') || (ch >= '0' && ch <= '9'))) {
                    sBuilder.append(ch);
                    ++i;
                }
                sBuilder.append(']');
            }
        }
        while (!Symbols.empty()) {
            sBuilder.append(Symbols.peek());
            Symbols.pop();
        }
        return sBuilder.toString();
    }

    public static double evalExp(String expression) {
        Num = new Stack<>();
        Num.clear();
        double ret = 0;
        String suffix = infixToSuffix(expression);
      //  System.out.println("suffix: " + suffix);
        for (int i = 0; i < suffix.length(); i++) {
            if (suffix.charAt(i) == '[') {
                i++;
                int beginIndex = i, endIndex = i;
                while (']' != suffix.charAt(i)) {
                    i++;
                    endIndex++;
                }
                Num.push(Double.valueOf(suffix.substring(beginIndex, endIndex)));
            } else {
                double left, right, res = 0;
                right = Num.peek();
                Num.pop();
                left = Num.peek();
                Num.pop();
                switch (suffix.charAt(i)) {
                    case '+':
                        res = left + right;
                        break;
                    case '-':
                        res = left - right;
                        break;
                    case '*':
                        res = left * right;
                        break;
                    case '/':
                        res = left / right;
                        break;
                    case '^':
                        res = Math.pow(left, right);
                        break;
                }
                Num.push(res);
            }
        }
        ret = Num.peek();
        Num.pop();
        return ret;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
         Scanner input = new Scanner(System.in);
         System.out.println("请输入一个含+-*/^()的表达式，请确认输入合法");
         for (int i = 0; i<12;i++){
             String expression = input.nextLine();
             System.out.println(expression + " =" + evalExp(expression));
         }
        input.close();
	}
}





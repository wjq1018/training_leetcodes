package stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 *
 * @author wjq
 * @date 2021/6/27 23:40
 * @since 1.0.0
 **/
public class QN20Stack {

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        //定义一个栈进行匹配存储
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    //栈中没有进行')','}',']'匹配;
                    return false;
                } else {
                    char temp = stack.pop();
                    if (c == ')') {
                        if (temp != '(') {
                            return false;
                        }
                    }
                    if (c == '}') {
                        if (temp != '{') {
                            return false;
                        }
                    }
                    if (c == ']') {
                        if (temp != '[') {
                            return false;
                        }
                    }
                }
            }

        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println( isValid("(){}[]"));
        System.out.println( isValid("(){}[]{"));
    }
}

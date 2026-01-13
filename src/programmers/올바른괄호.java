package programmers;

import java.util.Stack;

public class 올바른괄호 {
    static Stack<Character> stack;

    public static boolean Solution(String s) {
        stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.size() > 0 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(Solution("()()"));
        System.out.println(Solution("(())()"));
        System.out.println(Solution(")()("));
        System.out.println(Solution("(()("));
    }
}

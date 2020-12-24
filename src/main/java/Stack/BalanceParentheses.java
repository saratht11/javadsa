package Stack;

import java.util.HashMap;
import java.util.Stack;

public class BalanceParentheses {
    public static void main(String[] args) {
        BalanceParentheses bp = new BalanceParentheses();
        String input = "[()()()]{}{[()]}";
        System.out.println(bp.validBalanceParentheses01(input));
        System.out.println(bp.isValid(input));
    }

    public boolean validBalanceParentheses01(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                stack.add(current);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char peek = stack.peek();
            if (current == '}' && peek != '{' ||
                    current == ']' && peek != '[' ||
                    current == ')' && peek != '(') {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    private HashMap<Character, Character> mappings;

    {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (mappings.containsKey(c)) {
                char topE = stack.empty() ? '#' : stack.pop();
                return topE == mappings.get(c);
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

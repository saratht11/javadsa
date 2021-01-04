package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(game.calculateScore(ops));
        System.out.println(game.calculateScore02(ops));
        System.out.println(game.calculateScore03(ops));
    }

    public int calculateScore(String[] ops) {
        int s = 0;
        Stack<Integer> stack = new Stack<>();
        for (String p : ops) {
            if (p.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (p.equals("C")) {
                stack.pop();
            } else if (p.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(p));
            }
        }
        for (int score : stack) s += score;
        return s;
    }

    public int calculateScore02(String[] ops) {
        int s = 0;
        Stack<Integer> stack = new Stack<>();
        for (String p : ops) {
            switch (p) {
                case "+":
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                default:
                    stack.push(Integer.valueOf(p));
                    break;
            }
        }
        for (int score : stack) s += score;
        return s;
    }

    public int calculateScore03(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        int s = 0;
        for (String p : ops) {
            switch (p) {
                case "+":
                    list.add(list.getLast() + list.get(list.size() - 2));
                    s += list.getLast();
                    break;
                case "C":
                    s -= list.removeLast();
                    break;
                case "D":
                    list.add(2 * list.getLast());
                    s += list.getLast();
                    break;
                default:
                    list.add(Integer.valueOf(p));
                    s += list.getLast();
                    break;
            }
        }
        return s;
    }
}

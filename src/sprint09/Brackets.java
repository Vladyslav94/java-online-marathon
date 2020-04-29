package sprint09;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Brackets {
    public static void main(String[] args) {
        String text = "(\\()";
        System.out.println(verifyBrackets(text));

    }

    public static boolean verifyBrackets(String text) {
        if(text.contains("\\{"))
            text = text.replace("\\{", "");
        if(text.contains("\\}"))
            text = text.replace("\\}", "");
        if(text.contains("\\("))
            text = text.replace("\\(", "");
        if(text.contains("\\)"))
            text = text.replace("\\)", "");
        if(text.contains("\\["))
            text = text.replace("\\[", "");
        if(text.contains("\\]"))
            text = text.replace("\\]", "");

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty())
                    return false;
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}


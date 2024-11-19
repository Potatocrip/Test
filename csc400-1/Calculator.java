import java.util.Stack;

public class Calculator {

    public int evaluateInfix(String expression) throws IllegalArgumentException {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                i--; // step back
                values.push(Integer.parseInt(sb.toString()));
            }
            // handles parentheses
            else if (c == '(') {
                ops.push(c);
            }
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    if (values.size() < 2) {
                        throw new IllegalArgumentException("Invalid expression: Missing operands.");
                    }
                    values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
                }
                if (ops.isEmpty() || ops.peek() != '(') {
                    throw new IllegalArgumentException("Invalid expression: Unmatched parentheses.");
                }
                ops.pop(); // pop the '('
            }
            // handles operators
            else if (isOperator(c)) {
                while (!ops.isEmpty() && precedence(c) <= precedence(ops.peek())) {
                    if (values.size() < 2) {
                        throw new IllegalArgumentException("Invalid expression: Missing operands.");
                    }
                    values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }

        // applies remaining operations
        while (!ops.isEmpty()) {
            if (values.size() < 2) {
                throw new IllegalArgumentException("Invalid expression: Missing operands.");
            }
            values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
        }

        if (values.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Unbalanced operands and operators.");
        }

        return values.pop(); // Final result
    }

    // Checks if a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    // Determines precedence of operators
    private int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/' || op == '%') {
            return 2;
        }
        return -1;
    }

    // Applies operation
    private int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            case '%': return a % b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            String expression1 = "(4+2)*3";
            System.out.println("Result 1: " + calculator.evaluateInfix(expression1)); 

            String expression2 = "39-(21/3)";
            System.out.println("Result 2: " + calculator.evaluateInfix(expression2)); 

            String expression3 = "10+(23%4)";
            System.out.println("Result 3: " + calculator.evaluateInfix(expression3)); 

            String expression4 = "4+2*10-";
            System.out.println("This won't print because it's wrong!: " + calculator.evaluateInfix(expression4)); 

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
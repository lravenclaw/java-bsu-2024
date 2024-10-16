package by.lravenclaw.quizer.tasks;

import by.lravenclaw.quizer.tasks.math.*;

public class ExpressionTask<T extends Number> extends ExpressionMathTask<T> implements MathTask<T> {
    public ExpressionTask(T num1, Operation op, T num2) {
        super(num1, op, num2);
        text = num1.toString() + operations_to_str.get(op) + num2.toString() + "=?";
    }
}

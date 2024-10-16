package by.lravenclaw.quizer.tasks;

import by.lravenclaw.quizer.tasks.math.*;

public class EquationTask<T extends Number> extends EquationMathTask<T> implements MathTask<T> {
    public EquationTask(Operation op, T num, T answer) {
        super(op, num, answer);
        text = "x" + operations_to_str.get(op) + num.toString() + "=" + answer.toString();
    }

    public EquationTask(T num, Operation op, T answer) {
        super(num, op, answer);
        text = num.toString() + operations_to_str.get(op) + "x=" + answer.toString();
    }
}

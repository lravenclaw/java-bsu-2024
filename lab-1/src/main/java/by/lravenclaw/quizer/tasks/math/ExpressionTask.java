package by.lravenclaw.quizer.tasks.math;

import by.lravenclaw.quizer.exceptions.IllegalOperationException;

public class ExpressionTask<T extends Number> extends AbstractMathTask<T> implements MathTask<T> {
    /**
     *  Описывает уравнения типа:
     *  <num1><operator><num2>=<answer>
     */

    T num1, num2;
    Operation operator;

    public ExpressionTask(T num1, Operation op, T num2) {
        this.num1 = num1;
        this.operator = op;
        this.num2 = num2;

        text = num1.toString() + operationsToStr.get(op) +
                num2.toString() + "=?";
    }

    @Override
    public double getCorrectAnswer() throws IllegalOperationException {
        return calculateExpression(
                num1.doubleValue(),
                operator,
                num2.doubleValue());
    }
}

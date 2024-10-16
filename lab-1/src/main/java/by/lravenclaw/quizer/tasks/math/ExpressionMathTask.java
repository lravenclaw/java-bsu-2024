package by.lravenclaw.quizer.tasks.math;

import by.lravenclaw.quizer.tasks.Result;
import by.lravenclaw.quizer.exceptions.IllegalOperationException;

public class ExpressionMathTask<T extends Number> extends AbstractMathTask<T> implements MathTask<T> {
    /**
     *  Описывает уравнения типа:
     *  <num1><operator><num2>=<answer>
     */

    T num1, num2;
    Operation operator;

    public ExpressionMathTask(T num1, Operation op, T num2) {
        this.num1 = num1;
        this.operator = op;
        this.num2 = num2;
    }

    @Override
    public double getCorrectAnswer() throws IllegalOperationException {
        return calculateExpression(
                num1.doubleValue(),
                operator,
                num2.doubleValue());
    }
}

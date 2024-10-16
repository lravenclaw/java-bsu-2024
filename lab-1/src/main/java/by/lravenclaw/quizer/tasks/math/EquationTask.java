package by.lravenclaw.quizer.tasks.math;

import by.lravenclaw.quizer.exceptions.IllegalOperationException;

public class EquationTask<T extends Number> extends AbstractMathTask<T> implements MathTask<T> {
    /**
     *  Описывает уравнения типа:
     *  <num1><operator1>x=<answer> и
     *  x<operator2><num2>=<answer>
     */
    private final T num1, num2, answer;
    private final Operation operator1, operator2;

    public EquationTask(Operation operator2, T num2, T answer) {
        /**
         *  x<operator2><num2>=<answer>
         */
        num1 = null;
        operator1 = Operation.SUM;

        this.operator2 = operator2;
        this.num2 = num2;
        this.answer = answer;

        text = "x" + operationsToStr.get(operator2) +
                num2.toString() + "=" + answer.toString();
    }

    public EquationTask(T num1, Operation operator1, T answer) {
        /**
         *  <num1><operator1>x=<answer>
         */
        num2 = null;
        operator2 = Operation.SUM;

        this.num1 = num1;
        this.operator1 = operator1;
        this.answer = answer;

        text = num1.toString() + operationsToStr.get(operator1) +
                "x=" + answer.toString();
    }

    @Override
    public double getCorrectAnswer() throws IllegalOperationException, NullPointerException {
        double right = calculateExpression(
                answer.doubleValue(),
                getOppositeOperation(operator2),
                num2.doubleValue());

        if (operator1 == Operation.DIVIDE) {
            return calculateExpression(
                    num1.doubleValue(),
                    Operation.DIVIDE,
                    right);
        }

        return calculateExpression(
                right,
                getOppositeOperation(operator1),
                num1.doubleValue());
    }
}

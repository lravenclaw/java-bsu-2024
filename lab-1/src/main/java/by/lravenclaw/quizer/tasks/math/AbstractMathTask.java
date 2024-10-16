package by.lravenclaw.quizer.tasks.math;

import by.lravenclaw.quizer.exceptions.IllegalOperationException;
import by.lravenclaw.quizer.tasks.AbstractTask;
import by.lravenclaw.quizer.tasks.Result;

import java.util.Map;
import java.util.EnumMap;

abstract public class AbstractMathTask<T extends Number> extends AbstractTask implements MathTask<T> {
    public enum Operation {
        SUM,
        SUBTRACT,
        DIVIDE,
        MULTIPLY
    }

    public Map<Operation, String> operations_to_str = new EnumMap<>(Operation.class);

    AbstractMathTask(){
        operations_to_str.put(Operation.SUM, "+");
        operations_to_str.put(Operation.SUBTRACT, "-");
        operations_to_str.put(Operation.DIVIDE, "/");
        operations_to_str.put(Operation.MULTIPLY, "*");
    }

    public Operation getOppositeOperation(Operation op) {
        switch (op) {
            case Operation.SUM:
                return Operation.SUBTRACT;

            case Operation.SUBTRACT:
                return Operation.SUM;

            case Operation.MULTIPLY:
                return Operation.DIVIDE;

            case Operation.DIVIDE:
                return Operation.MULTIPLY;

            default:
                return op;
        }
    }

    public double calculateExpression(double a, Operation op, double b) throws IllegalOperationException {
        if (op == Operation.DIVIDE && b == 0.) {
            throw new IllegalOperationException("Division by zero!");
        }

        switch (op) {
            case Operation.SUM:
                return a + b;

            case Operation.SUBTRACT:
                return a - b;

            case Operation.MULTIPLY:
                return a * b;

            case Operation.DIVIDE:
                return a / b;

            default:
                return 0.;

        }
    }

    @Override
    public Result validate(String answer) {
        double input;
        try {
            input = Double.parseDouble(answer);
        } catch (NumberFormatException _) {
            return Result.INCORRECT_INPUT;
        }

        double EPSILON = 1e-6;
        if (Math.abs(input - getCorrectAnswer()) < EPSILON) {
            return Result.OK;
        }
        return Result.WRONG;
    }
}

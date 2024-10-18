package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.tasks.math.AbstractMathTask;
import by.lravenclaw.quizer.tasks.math.ExpressionTask;

import java.util.EnumSet;

public class ExpressionTaskGenerator
        <NumType extends Number>
        extends AbstractMathTaskGenerator<NumType, ExpressionTask<NumType>>
        implements MathTaskGenerator<NumType, ExpressionTask<NumType>> {

    /**
     * @param minNumber  минимальное число
     * @param maxNumber  максимальное число
     * @param operations множество разрешённых операций
     */
    public ExpressionTaskGenerator(int minNumber, int maxNumber, EnumSet<AbstractMathTask.Operation> operations) {
        super(minNumber, maxNumber, operations);
    }

    @Override
    public ExpressionTask<NumType> generate() {
        return null;
    }
}

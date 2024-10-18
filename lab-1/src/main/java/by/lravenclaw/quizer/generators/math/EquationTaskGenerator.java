package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.tasks.math.AbstractMathTask;
import by.lravenclaw.quizer.tasks.math.EquationTask;

import java.util.EnumSet;

public class EquationTaskGenerator
        <NumType extends Number>
        extends AbstractMathTaskGenerator<NumType, EquationTask<NumType>>
        implements MathTaskGenerator<NumType, EquationTask<NumType>> {

    /**
     * @param minNumber  минимальное число
     * @param maxNumber  максимальное число
     * @param operations множество разрешённых операций
     */
    public EquationTaskGenerator(int minNumber, int maxNumber, EnumSet<AbstractMathTask.Operation> operations) {
        super(minNumber, maxNumber, operations);
    }

    @Override
    public EquationTask<NumType> generate() {
        return null;
    }
}

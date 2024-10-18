package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.tasks.math.AbstractMathTask.Operation;
import by.lravenclaw.quizer.tasks.math.MathTask;

import java.util.*;
import lombok.*;

abstract public class AbstractMathTaskGenerator
        <NumType extends Number, TaskType extends MathTask<NumType>>
        implements MathTaskGenerator<NumType, TaskType> {
    @Getter(AccessLevel.PUBLIC)
    protected int minNumber;

    @Getter(AccessLevel.PUBLIC)
    protected int maxNumber;

    protected ArrayList<Operation> operations;

    /**
     * @param minNumber минимальное число
     * @param maxNumber максимальное число
     * @param operations множество разрешённых операций
     */
    AbstractMathTaskGenerator(
            int minNumber,
            int maxNumber,
            EnumSet<Operation> operations) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;

        this.operations = new ArrayList<>();
        this.operations.addAll(operations);

        if (minNumber > maxNumber) {
            throw new IllegalArgumentException("Max number should be less then min.");
        }
    }
}

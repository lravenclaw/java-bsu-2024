package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.tasks.Task;
import by.lravenclaw.quizer.tasks.math.AbstractMathTask.Operation;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import lombok.*;

public abstract class AbstractMathTaskGenerator implements MathTaskGenerator {
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
            int tmp = minNumber;
            minNumber = maxNumber;
            maxNumber = tmp;
        }
    }

    @Override
    Task generate();
}

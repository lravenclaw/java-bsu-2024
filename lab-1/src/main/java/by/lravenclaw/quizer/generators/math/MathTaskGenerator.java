package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.generators.TaskGenerator;
import by.lravenclaw.quizer.tasks.math.*;

public interface MathTaskGenerator
        <NumType extends Number, TaskType extends MathTask<NumType>>
        extends TaskGenerator<TaskType> {
    int getMinNumber(); // получить минимальное число
    int getMaxNumber(); // получить максимальное число

    /**
     * @return разница между максимальным и минимальным возможным числом
     */
    default int getDiffNumber() {
        return getMaxNumber() - getMinNumber();
    }
}

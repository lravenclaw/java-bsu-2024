package by.lravenclaw.quizer.generators.math;

import by.lravenclaw.quizer.generators.TaskGenerator;

import by.lravenclaw.quizer.tasks.math.*;
import by.lravenclaw.quizer.tasks.*;

public interface MathTaskGenerator<T extends MathTask> extends TaskGenerator {
    int getMinNumber(); // получить минимальное число
    int getMaxNumber(); // получить максимальное число

    /**
     * @return разница между максимальным и минимальным возможным числом
     */
    default int getDiffNumber() {
        return getMaxNumber() - getMinNumber();
    }
}

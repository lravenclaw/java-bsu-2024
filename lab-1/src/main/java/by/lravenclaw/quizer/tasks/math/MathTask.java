package by.lravenclaw.quizer.tasks.math;

import by.lravenclaw.quizer.tasks.*;

public interface MathTask<T extends Number> extends Task {
    double getCorrectAnswer();
}

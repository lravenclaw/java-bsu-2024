package by.lravenclaw.quizer.tasks;

import lombok.*;

abstract public class AbstractTask implements Task {
    @Getter(AccessLevel.PUBLIC)
    protected String text;

    /**
     * Проверяет ответ на задание и возвращает результат
     *
     * @param  answer ответ на задание
     * @return        результат ответа
     * @see           Result
     */
    abstract public Result validate(String answer);
}

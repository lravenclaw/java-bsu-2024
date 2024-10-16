package by.lravenclaw.quizer.tasks;

import lombok.AllArgsConstructor;

/**
 * Задание с заранее заготовленным текстом. 
 * Можно использовать {@link PoolTaskGenerator}, чтобы задавать задания такого типа.
 */

@AllArgsConstructor
class TextTask extends AbstractTask implements Task {
    String answer;

    @Override
    public Result validate(String answer) {
        if (answer.isEmpty()) {
            return Result.INCORRECT_INPUT;
        }

        if (text.equals(answer)) {
            return Result.OK;
        }
        return Result.WRONG;
    }
}
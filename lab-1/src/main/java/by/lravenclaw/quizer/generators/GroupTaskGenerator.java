package by.lravenclaw.quizer.generators;

import by.lravenclaw.quizer.tasks.*;
import by.lravenclaw.quizer.tools.RandomWrapper;

import java.util.*;

class GroupTaskGenerator implements TaskGenerator<Task> {
    private final ArrayList<TaskGenerator<Task>> generators;

    /**
     * Конструктор с переменным числом аргументов
     *
     * @param generators генераторы, которые в конструктор передаются через запятую
     */
    @SafeVarargs
    public GroupTaskGenerator(TaskGenerator<Task>... generators) {
        this.generators = new ArrayList<>(Arrays.asList(generators));
    }

    /**
     * Конструктор, который принимает коллекцию генераторов
     *
     * @param generators генераторы, которые передаются в конструктор в Collection (например, {@link ArrayList})
     */
    public GroupTaskGenerator(Collection<TaskGenerator<Task>> generators) {
        this.generators = new ArrayList<>(generators);
    }

    /**
     * @return результат метода generate() случайного генератора из списка.
     *         Если этот генератор выбросил исключение в методе generate(), выбирается другой.
     *         Если все генераторы выбрасывают исключение, то и тут выбрасывается исключение.
     */
    @Override
    public Task generate() {
        return this.generators.get(RandomWrapper.getRandomIndex(this.generators.size())).generate();
    }
}
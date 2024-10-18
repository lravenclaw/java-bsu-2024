package by.lravenclaw.quizer.generators;

import by.lravenclaw.quizer.exceptions.EmptyPoolException;
import by.lravenclaw.quizer.tasks.*;
import by.lravenclaw.quizer.tools.RandomWrapper;

import java.util.*;

public class PoolTaskGenerator implements TaskGenerator<Task> {
    Set<Integer> usedIndexes;
    boolean allowDuplicate;
    ArrayList<Task> tasks;

    /**
     * Конструктор с переменным числом аргументов
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые в конструктор передаются через запятую
     */
    public PoolTaskGenerator(
        boolean allowDuplicate,
        Task... tasks
    ) {
        usedIndexes = new HashSet<>();
        this.allowDuplicate = allowDuplicate;
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
    }

    /**
     * Конструктор, который принимает коллекцию заданий
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые передаются в конструктор в Collection (например, {@link LinkedList})
     */
    public PoolTaskGenerator(
        boolean allowDuplicate,
        Collection<Task> tasks
    ) {
        usedIndexes = new HashSet<>();
        this.allowDuplicate = allowDuplicate;
        this.tasks = new ArrayList<>(tasks);
    }

    /**
     * @return случайная задача из списка
     */
    @Override
    public Task generate() throws EmptyPoolException {
        var currentTaskSize = tasks.size();
        if (usedIndexes.size() >= currentTaskSize) {
            throw new EmptyPoolException("Empty pool or all tasks used.");
        }

        if (allowDuplicate) {
            int index = RandomWrapper.getRandomIndex(currentTaskSize);
            while (usedIndexes.contains(index)) {
                index = RandomWrapper.getRandomIndex(currentTaskSize);
            }
            usedIndexes.add(index);
            return tasks.get(index);
        }
        return tasks.get(RandomWrapper.getRandomIndex(currentTaskSize));
    }
}
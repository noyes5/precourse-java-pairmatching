package pairmatching.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DataInputHandler {
    private DataInputHandler() {
    }

    public static <T> T get(Supplier<T> action, Consumer<IllegalArgumentException> consumer) {
        try {
            return action.get();
        } catch (IllegalArgumentException exception) {
            consumer.accept(exception);
            return get(action, consumer);
        }
    }
}


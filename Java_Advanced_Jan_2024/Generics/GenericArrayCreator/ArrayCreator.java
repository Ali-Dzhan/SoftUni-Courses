package Generics.GenericArrayCreator;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);
    }

    public static <T> T[] create(Class<?>clazz, int length, @NotNull T item) {

        T[] arr = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(arr, item);

        return arr;
    }
}

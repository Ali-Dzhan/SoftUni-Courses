package Generics.ListUtilities;

import java.util.List;

public class ListUtilities {
    // min comparing
    public static <T extends Comparable<T>> T getMin( List<T> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return list.stream().min(Comparable::compareTo).get();
    }
    // max comparing
    public static <T extends Comparable<T>> T getMax( List<T> list) {
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return list.stream().max(Comparable::compareTo).get();
    }
}

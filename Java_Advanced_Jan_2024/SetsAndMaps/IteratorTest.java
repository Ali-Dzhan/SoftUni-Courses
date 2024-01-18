package SetsAndMaps;

import java.util.LinkedHashSet;

public class IteratorTest {
    public static void main(String[] args) {

        LinkedHashSet<Integer> testSet = new LinkedHashSet<>();

        testSet.add(1);
        testSet.add(2);
        testSet.add(3);

        for (int e: testSet){
            System.out.println(e);
        }
        int firstNum = testSet.iterator().next();
        System.out.println(firstNum);
    }
}

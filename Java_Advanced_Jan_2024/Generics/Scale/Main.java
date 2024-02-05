package Generics.Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(15,15);
        System.out.println(scale.getHeavier());

        Scale<String> stringScale = new Scale<>("a", "f");
        System.out.println(stringScale.getHeavier());
    }
}

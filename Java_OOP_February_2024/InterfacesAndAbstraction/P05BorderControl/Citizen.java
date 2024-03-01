package InterfacesAndAbstraction.P05BorderControl;

public class Citizen implements Identifiable {
    private int age;
    private String name;

    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;

    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}

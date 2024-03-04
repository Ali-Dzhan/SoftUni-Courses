package InterfacesAndAbstractionExercise.P07Collection;

public class AddRemoveCollection extends Collection implements AddRemovable, Addable{
    @Override
    public String remove() {
        return super.removeLast();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }
}

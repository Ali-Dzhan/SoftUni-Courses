package Exam.sharkHaunt;

import java.util.ArrayList;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                sharks.remove(shark);
                return true;
            }
        }
        return false;
    }

    public Shark getLargestShark() {
        if (sharks.isEmpty()) {
            return null;
        }

        Shark largestShark = sharks.get(0);
        for (Shark shark : sharks) {
            if (shark.getLength() > largestShark.getLength()) {
                largestShark = shark;
            }
        }
        return largestShark;
    }

    public Shark getShark(String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        if (sharks.isEmpty()) {
            return 0;
        }

        int totalLength = 0;
        for (Shark shark : sharks) {
            totalLength += shark.getLength();
        }
        return totalLength / sharks.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder("Sharks in " + name + ":\n");

        for (Shark shark : sharks) {
            report.append(shark.toString()).append("\n");
        }

        return report.toString();
    }
}



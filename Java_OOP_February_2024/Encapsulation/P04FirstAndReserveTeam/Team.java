package Encapsulation.P04FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> reserveTeam;

    public void setName(String name) {
        this.name = name;
    }

    private List<Person> firstTeam;

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public Team(String name) {
        this.setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public void addPLayer(Person person) {
        if (person.getAge() < 40) {
            firstTeam.add(person);
        } else {
            reserveTeam.add(person);
        }
    }
}




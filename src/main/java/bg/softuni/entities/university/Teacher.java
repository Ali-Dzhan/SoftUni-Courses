package bg.softuni.entities.university;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Column(name = "email")
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    public Teacher(){
        super();
    }
}

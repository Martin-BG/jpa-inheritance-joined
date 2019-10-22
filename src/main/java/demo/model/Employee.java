package demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "person_id")
public class Employee extends Person {

    private String position;

    public Employee() {

    }

    public Employee(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String name) {
        this.position = name;
    }
}

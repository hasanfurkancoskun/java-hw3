package edu.sabanci.model;

import jakarta.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    public int fixedSalary;

    public PermanentInstructor(String firstName, String lastName, String address, String phoneNumber, int fixedSalary) {
        super(firstName, lastName, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
    public PermanentInstructor() {
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                ", id=" + id +
                ", firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


}

package edu.sabanci.model;

import jakarta.persistence.Entity;

@Entity
public class VisitingInstructor extends Instructor{

    public int hourlySalary;

    public VisitingInstructor(String firstName, String lastName, String address, String phoneNumber, int hourlySalary) {
        super(firstName, lastName, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }
    public VisitingInstructor( int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
    public VisitingInstructor() {
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingInstructor{" +
                "hourlySalary=" + hourlySalary +
                ", id=" + id +
                ", firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

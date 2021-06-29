package com.ashish.example.springmanydemo.datarest.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=5, allocationSize=100)
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private int eid;
    private String ename;
    private String gender;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

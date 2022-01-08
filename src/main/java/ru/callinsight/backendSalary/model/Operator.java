package ru.callinsight.backendSalary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "operator")
public class Operator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(insertable = false, updatable = false)
    private Integer id;

//    @OneToMany
//    private List<Salary> salaries;

    @Column(name = "full_name")
    private String fullName;

    public Operator() {
    }

    public Operator(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

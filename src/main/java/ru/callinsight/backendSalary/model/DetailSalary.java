package ru.callinsight.backendSalary.model;

import javax.persistence.*;

@Entity
@Table(name = "detail_salary")
public class DetailSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="salary_id")
    private Salary salary;

    @Column(name = "begin")
    private Double begin;

    @Column(name = "end")
    private Double end;

    @Column(name = "total")
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Double getBegin() {
        return begin;
    }

    public void setBegin(Double begin) {
        this.begin = begin;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

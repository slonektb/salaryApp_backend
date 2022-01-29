package ru.callinsight.backendSalary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "salary")
public class Salary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(insertable = false, updatable = false)
    private Integer id;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="operator_id", insertable = false, updatable = false)
    @JoinColumn (name="operator_id")
    //private Optional<Operator> operator;
    private Operator operator;

//    @Column(name = "operator_id")
//    private Integer operatorId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total_hours")
    private Double totalHours;

    @Column(name = "hourly_rate")
    private Double hourlyRate;

    @Column(name = "total_salary")
    private Double totalSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public Optional<Operator> getOperator() {
    public Operator getOperator() {
        return operator;
    }

    //public void setOperator(Optional<Operator> operator) {
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }
}

package ru.callinsight.backendSalary.dto;

import ru.callinsight.backendSalary.model.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OperatorDto {

    private int id;
    private String fullName;
    private List<Salary> salaries;
    private double hourly_rate;
    private double total_salary;
    private double total_hours;

    public OperatorDto() {
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public double getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public double getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(double total_salary) {
        this.total_salary = total_salary;
    }

    public double getTotal_hours() {
        return total_hours;
    }

    public void setTotal_hours(double total_hours) {
        this.total_hours = total_hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

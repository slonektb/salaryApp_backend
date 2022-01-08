package ru.callinsight.backendSalary.dto;

import org.springframework.jdbc.core.RowMapper;
import ru.callinsight.backendSalary.model.DetailSalary;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DetailSalaryDto  {
    private int id;
    private String fullName;
    private List<DetailSalary> salaries;
    private double begin;
    private double end;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<DetailSalary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<DetailSalary> salaries) {
        this.salaries = salaries;
    }

    private double total;

    public DetailSalaryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBegin() {
        return begin;
    }

    public void setBegin(double begin) {
        this.begin = begin;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}



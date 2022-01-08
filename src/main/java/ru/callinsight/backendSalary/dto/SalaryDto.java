package ru.callinsight.backendSalary.dto;

public class SalaryDto {
    private Integer id;
    private Integer salary_id;
    private double begin;
    private double end;
    private double total;

    public SalaryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(Integer salary_id) {
        this.salary_id = salary_id;
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

package ru.callinsight.backendSalary.dto;

public class DatailSalaryForUpdateDto {
    private int id;

    private double begin;

    private double end;

    public DatailSalaryForUpdateDto() {
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
}

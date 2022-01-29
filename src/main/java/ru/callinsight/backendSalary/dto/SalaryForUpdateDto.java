package ru.callinsight.backendSalary.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SalaryForUpdateDto {
    private int idOperator;

    private int idSalary;

    private LocalDate dateSalary;

    private List<DatailSalaryForUpdateDto> detailSalary;

    public SalaryForUpdateDto() {
    }

    @Override
    public String toString() {
        return "idOperator: {" + idOperator + "}\n" +
                "idSalary: {" + idSalary +  "}\n" +
                "dateSalary: {" + dateSalary.toString() +"}\n";
    }

    public int getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(int idOperator) {
        this.idOperator = idOperator;
    }

    public int getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(int idSalary) {
        this.idSalary = idSalary;
    }

    public LocalDate getDateSalary() {
        return dateSalary;
    }

    public void setDateSalary(LocalDate dateSalary) {
        this.dateSalary = dateSalary;
    }

    public List<DatailSalaryForUpdateDto> getDetailSalary() {
        return detailSalary;
    }

    public void setDetailtSalary(List<DatailSalaryForUpdateDto> detailSalary) {
        this.detailSalary = detailSalary;
    }
}

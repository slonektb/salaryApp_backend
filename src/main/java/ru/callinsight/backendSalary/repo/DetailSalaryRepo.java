package ru.callinsight.backendSalary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Salary;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface DetailSalaryRepo extends JpaRepository<DetailSalary, Integer> {
    List<DetailSalary> findDetailSalaryBySalaryIn(Collection<Salary> salary);
    List<DetailSalary> findAllBySalaryDateAndSalaryOperatorId(LocalDate date, Integer operatorId);
}

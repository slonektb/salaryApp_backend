package ru.callinsight.backendSalary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Salary;

import java.time.LocalDate;
import java.util.List;


public interface SalaryRepo extends JpaRepository<Salary, Integer> {
    List<Salary> findAllByOperatorIdAndDateBetween(Integer id, LocalDate minusMonths, LocalDate now);
    List<Salary> findAllByDate(LocalDate date);
}

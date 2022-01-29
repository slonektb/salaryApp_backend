package ru.callinsight.backendSalary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Salary;

import java.time.LocalDate;
import java.util.List;


public interface SalaryRepo extends JpaRepository<Salary, Integer> {
    List<Salary> findAllByOperatorIdAndDateBetween(Integer id, LocalDate minusMonths, LocalDate now);

    Salary findById(int id);

    List<Salary> findByTotalHours(double num);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM `salary`" +
            " WHERE `id` = :id")
    void rmSalaryById(int id);
}

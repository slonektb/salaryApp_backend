package ru.callinsight.backendSalary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Salary;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Transactional
public interface DetailSalaryRepo extends JpaRepository<DetailSalary, Integer> {
    List<DetailSalary> findDetailSalaryBySalaryIn(Collection<Salary> salary);
    List<DetailSalary> findAllBySalaryDateAndSalaryOperatorId(LocalDate date, Integer operatorId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM `detail_salary`" +
            " WHERE `salary_id` = :idSalary AND `id` NOT IN ( :inForSQL )")
    void rmDetailSalary(int idSalary, List<Integer> inForSQL);

    DetailSalary findById(int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM `detail_salary`" +
            " WHERE `salary_id` = :idSalary")
    void rmDeails(int idSalary);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "SELECT * FROM `detail_salary`" +
            " WHERE `salary_id` = :salId")
    List<DetailSalary> DSbySalId(double salId);
}

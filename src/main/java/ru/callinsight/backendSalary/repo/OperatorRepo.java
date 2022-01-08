package ru.callinsight.backendSalary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.callinsight.backendSalary.model.Operator;

import java.util.Optional;

public interface OperatorRepo extends JpaRepository<Operator, Integer> {
    void deleteOperatorById(int id);

    Optional<Operator> findOperatorById(Integer id);
}

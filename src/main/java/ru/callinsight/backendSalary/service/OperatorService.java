package ru.callinsight.backendSalary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.callinsight.backendSalary.dto.OperatorDto;
import ru.callinsight.backendSalary.exception.OperatorNotFoundException;
import ru.callinsight.backendSalary.model.Operator;
import ru.callinsight.backendSalary.model.Salary;
import ru.callinsight.backendSalary.repo.OperatorRepo;
import ru.callinsight.backendSalary.repo.SalaryRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorService.class);
    private final OperatorRepo operatorRepo;
    private final SalaryRepo salaryRepo;

    @Autowired
    public OperatorService(OperatorRepo operatorRepo, SalaryRepo salaryRepo) {
        this.operatorRepo = operatorRepo;
        this.salaryRepo = salaryRepo;
    }

    public List<OperatorDto> findAllOperators(LocalDate date) {
        List<Operator> operators = operatorRepo.findAll();
        LOGGER.info("operators = " + operators);
        List<OperatorDto> operatorDtos = new ArrayList<>();
        for (Operator e : operators) {
            List<Salary> salaries = salaryRepo.findAllByOperatorIdAndDateBetween(
                    e.getId(),
//                    LocalDate.now().minusMonths(1L), LocalDate.now()
                    date, date.plusMonths(1L).minusDays(1L)
            );
            LOGGER.info("operators from findAllOperators" + salaries.toString() + " " + e.getId());
            OperatorDto operatorDto = new OperatorDto();

            double hourTotal = 0;
            double salaryTotal = 0;
            double hourRate = 0;
            for (Salary salary: salaries) {
                hourTotal += salary.getTotalHours();
                salaryTotal += salary.getTotalSalary();
                hourRate = salary.getHourlyRate();
            }
            operatorDto.setId(e.getId());
            operatorDto.setFullName(e.getFullName());
            operatorDto.setSalaries(salaries);
            operatorDto.setTotal_hours(hourTotal);
            operatorDto.setHourly_rate(hourRate);
            operatorDto.setTotal_salary(salaryTotal);
            operatorDtos.add(operatorDto);
            LOGGER.info("hourTotal = " + hourTotal + ", salaryTotal = " + salaryTotal + ", hourRate = " + hourRate);
        }
        return operatorDtos;
    }

    public Operator addOperator(Operator operator) {
        return operatorRepo.save(operator);
    }

    public Operator findById(Integer id){
        return operatorRepo.findOperatorById(id)
                .orElseThrow(()-> new OperatorNotFoundException("User by id " + id + " was not found"));
    }

    public Operator updateOperator(Operator operator) {
        return operatorRepo.save(operator);
    }

    public void deleteOperator(int id) {
        operatorRepo.deleteOperatorById(id);
    }

//    public List<Operator> findTotalHoursForOperators(int year, int month) {
//        return operatorJDBC.findTotalHoursForOperators(year, month);
//    }
}

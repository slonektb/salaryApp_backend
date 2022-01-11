package ru.callinsight.backendSalary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.callinsight.backendSalary.dto.DetailSalaryDto;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Operator;
import ru.callinsight.backendSalary.repo.DetailSalaryRepo;
import ru.callinsight.backendSalary.repo.OperatorRepo;
import ru.callinsight.backendSalary.repo.SalaryRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailSalaryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailSalaryService.class);
    private final DetailSalaryRepo detailSalaryRepo;
    private final SalaryRepo salaryRepo;
    private final OperatorRepo operatorRepo;

    @Autowired
    public DetailSalaryService(DetailSalaryRepo detailSalaryRepo, SalaryRepo salaryRepo, OperatorRepo operatorRepo) {
        this.detailSalaryRepo = detailSalaryRepo;
        this.salaryRepo = salaryRepo;
        this.operatorRepo = operatorRepo;
    }

    public List<DetailSalary> allDetailSalary() {
        LOGGER.info("Метод allDetailSalary");
        return detailSalaryRepo.findAll();
    }
//
//    public List<DetailSalary> findDetailSalaryByDate(LocalDate date) {
//        List<Salary> salaries = salaryRepo.findAllByDate(date);
//        return findDetailSalaryBySalaryIn(salaries);
//    }
//
//
//    public List<DetailSalary> findDetailSalaryBySalaryIn(List<Salary> salaries) {
//        return detailSalaryRepo.findDetailSalaryBySalaryIn(salaries);
//    }

    public List<DetailSalaryDto> findAllDetailSalary(LocalDate date) {
        List<Operator> operators = operatorRepo.findAll();
        LOGGER.info("operators from findAllDetailSalary" + operators);
        List<DetailSalaryDto> detailSalaryDtos = new ArrayList<>();
        for (Operator operator : operators) {
            List<DetailSalary> detailSalarys = detailSalaryRepo.
                    findAllBySalaryDateAndSalaryOperatorId(date, operator.getId());
            LOGGER.info("DetailSalary " + detailSalarys);
            DetailSalaryDto detailSalaryDto = new DetailSalaryDto();
            detailSalaryDto.setId(operator.getId());
            detailSalaryDto.setFullName(operator.getFullName());
            detailSalaryDto.setSalaries(detailSalarys);
            detailSalaryDtos.add(detailSalaryDto);
        }
        return detailSalaryDtos;
    }
}

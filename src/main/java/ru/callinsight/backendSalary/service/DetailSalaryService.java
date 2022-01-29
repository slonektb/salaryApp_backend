package ru.callinsight.backendSalary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.callinsight.backendSalary.dto.DatailSalaryForUpdateDto;
import ru.callinsight.backendSalary.dto.DetailSalaryDto;
import ru.callinsight.backendSalary.dto.SalaryForUpdateDto;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.model.Operator;
import ru.callinsight.backendSalary.model.Salary;
import ru.callinsight.backendSalary.repo.DetailSalaryRepo;
import ru.callinsight.backendSalary.repo.OperatorRepo;
import ru.callinsight.backendSalary.repo.SalaryRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailSalaryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailSalaryService.class);
    private final DetailSalaryRepo detailSalaryRepo;
    private final OperatorRepo operatorRepo;
    private final SalaryRepo salaryRepo;

    @Autowired
    public DetailSalaryService(DetailSalaryRepo detailSalaryRepo, OperatorRepo operatorRepo, SalaryRepo salaryRepo) {
        this.detailSalaryRepo = detailSalaryRepo;
        this.operatorRepo = operatorRepo;
        this.salaryRepo = salaryRepo;

    }

    public List<DetailSalary> allDetailSalary() {
        LOGGER.info("Метод allDetailSalary");
        return detailSalaryRepo.findAll();
    }


    //-----------------------------------------------------
    // Добавление периодов в таблицу DetailSalary
    //-----------------------------------------------------
    public double updateDatailSalary(List<DatailSalaryForUpdateDto> datailSalaryForUpdateDto, int idSalary) {
        double sumTotalHour = 0;

        Salary salary = salaryRepo.findById(idSalary);

        if (datailSalaryForUpdateDto.size() > 0) {
            List<Integer> inFoSQL = new ArrayList<>();
            //Собираю массив для удаления лишних периодов
            for (DatailSalaryForUpdateDto item : datailSalaryForUpdateDto) {
                //if (inFoSQL.length() > 0 ) inFoSQL = inFoSQL + ", ";
                inFoSQL.add(item.getId());
                //удаляем из базы лишние периоды
                System.out.println(inFoSQL.toString());
                detailSalaryRepo.rmDetailSalary(idSalary, inFoSQL);
            }


            //Создаем новые периоды и считаем сумму часов
            for(DatailSalaryForUpdateDto item : datailSalaryForUpdateDto) {
                double tempSum = item.getEnd() - item.getBegin();
                if (item.getId() < 0) {
                    DetailSalary ds = new DetailSalary ();
                    ds.setBegin(item.getBegin());
                    ds.setEnd(item.getEnd());
                    ds.setTotal(tempSum);
                    ds.setSalary(salary);
                    detailSalaryRepo.save(ds);
                } else {
                    DetailSalary ds = detailSalaryRepo.findById(item.getId());
                    if (ds != null) {
                        ds.setTotal(tempSum);
                        detailSalaryRepo.save(ds);
                    }
                }

                sumTotalHour += tempSum;
            }
        } else {
            detailSalaryRepo.rmDeails(idSalary);
        }

        return sumTotalHour;
    }


    //-------------------------------------------------------------
    // проверка наличия записи Salary и если такой нет - создаем
    //-------------------------------------------------------------
    public int salaryCheck(SalaryForUpdateDto salaryForUpdateDto) {
        int salaryId = -1;
        if (salaryForUpdateDto.getIdSalary() < 0) {
            Operator oper = operatorRepo.findOperatorById(salaryForUpdateDto.getIdOperator());
            if (salaryForUpdateDto.getDetailSalary().size() > 0) {
                Salary sal = new Salary();
                sal.setOperator(oper);
                sal.setDate(salaryForUpdateDto.getDateSalary());
                sal.setTotalSalary((double) 0);
                sal.setHourlyRate((double) 0);
                sal.setTotalHours((double) 0);
                salaryRepo.save(sal);
                salaryId = sal.getId();
            } else {
                Salary sal = salaryRepo.findById(salaryForUpdateDto.getIdSalary());
                salaryRepo.delete(sal);
            }
        } else {
            Salary sal = salaryRepo.findById(salaryForUpdateDto.getIdSalary());
            salaryId = sal.getId();
        }

        return salaryId;
    }

    //-------------------------------------------------
    // Обновление суммы часов в записи таблицы Salary
    //-------------------------------------------------
    public void salaryTotalHoursUpdate (double sumHours, int idSalary) {
        if (idSalary > -1) {
            Salary sal = salaryRepo.findById(idSalary);
            sal.setTotalHours(sumHours);
            salaryRepo.save(sal);
        }
    }

    //-------------------------------------------------
    // Прием и обработка всех DetailSalary
    //-------------------------------------------------
    public String updateDS (List<SalaryForUpdateDto> listSalary) {
        for (SalaryForUpdateDto item : listSalary) {
            double totalHours = 0;
            int idSal = salaryCheck(item);
            totalHours = updateDatailSalary(item.getDetailSalary(), idSal);
            salaryTotalHoursUpdate(totalHours, idSal);

            clearEmptySalary();
        }
        return "OK";
    }


    public void clearEmptySalary () {
        List<Salary> salarys = salaryRepo.findByTotalHours(0);
        for (Salary item : salarys) {
            if (detailSalaryRepo.DSbySalId(item.getId()).size() == 0) {
                salaryRepo.rmSalaryById(item.getId());
            }
        }
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

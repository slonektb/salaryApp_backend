package ru.callinsight.backendSalary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.callinsight.backendSalary.dto.DetailSalaryDto;
import ru.callinsight.backendSalary.model.DetailSalary;
import ru.callinsight.backendSalary.service.DetailSalaryService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/operator")
public class DetailSalaryController {
    private final DetailSalaryService detailSalaryService;

    public DetailSalaryController(DetailSalaryService detailSalaryService) {
        this.detailSalaryService = detailSalaryService;
    }

//
//    @GetMapping("/detail/{date}")
//    public ResponseEntity<List<DetailSalary>> findDetailSalaryByDate(@PathVariable String date) {
//        LocalDate localDate = LocalDate.parse(date);
//        List<DetailSalary> detailSalaries = detailSalaryService.findDetailSalaryByDate(localDate);
//        LOGGER.info("Метод findDetailSalaryByDate() ");
//        return new ResponseEntity<>(detailSalaries, HttpStatus.OK);
//    }
    @GetMapping("/date/{year}/{month}/{day}")
    public ResponseEntity<List<DetailSalaryDto>> findAllDetailSalary(@PathVariable("year") String year
            , @PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        String s = year + "-" + month + "-" + day;
        LocalDate date = LocalDate.parse(s, formatter);
        List<DetailSalaryDto> detailSalaryDtos = detailSalaryService.findAllDetailSalary(date);
        return new ResponseEntity<>(detailSalaryDtos, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<List<DetailSalary>> getAllDetails() {
        List<DetailSalary> detailSalaries = detailSalaryService.allDetailSalary();
        return new ResponseEntity<>(detailSalaries, HttpStatus.OK);
    }
}

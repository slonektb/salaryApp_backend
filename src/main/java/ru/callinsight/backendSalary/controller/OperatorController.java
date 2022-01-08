package ru.callinsight.backendSalary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.callinsight.backendSalary.dto.OperatorDto;
import ru.callinsight.backendSalary.model.Operator;
import ru.callinsight.backendSalary.service.OperatorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/operator")
public class OperatorController {
    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/date/{year}/{month}")
    public ResponseEntity<List<OperatorDto>> getAllOperators(@PathVariable("year") String year
            , @PathVariable("month") Integer month) {
        LocalDate date = LocalDate.parse(year + "-" + "0" + month + "-01");
        List<OperatorDto> operators = operatorService.findAllOperators(date, month);
        return new ResponseEntity<>(operators, HttpStatus.OK);
    }

//    @GetMapping("/date/{year}/{month}")
//    public ResponseEntity<List<Operator>> findTotalHoursForOperators(@PathVariable("year") Integer year
//            , @PathVariable("month") Integer month) {
//        List<Operator> operators = operatorService.findTotalHoursForOperators(year, month);
//        return new ResponseEntity<>(operators, HttpStatus.OK);
//    }

    //Метод пока не используется
    @GetMapping("/find/{id}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable("id") Integer id) {
        Operator operator = operatorService.findById(id);
        return new ResponseEntity<>(operator, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Operator> addOperator(@RequestBody Operator operator) {
        Operator newOperator = operatorService.addOperator(operator);
        return new ResponseEntity<>(newOperator, HttpStatus.CREATED);
    }

    //Метод пока не используется
    @PutMapping("/update")
    public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator) {
        Operator updateOperator = operatorService.updateOperator(operator);
        return new ResponseEntity<>(updateOperator, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Operator> deleteOperator(@PathVariable("id") Integer id) {
        operatorService.deleteOperator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

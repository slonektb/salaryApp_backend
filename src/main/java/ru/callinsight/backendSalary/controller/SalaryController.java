package ru.callinsight.backendSalary.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/operator")
public class SalaryController {
//    @GetMapping
//    public ResponseEntity<Salary> findTotalHoursForOperators(@RequestBody Salary salary) {
//        Salary newSalary = operatorService.updateOperator(operator);
//        return new ResponseEntity<>(updateOperator, HttpStatus.OK);
//    }
}

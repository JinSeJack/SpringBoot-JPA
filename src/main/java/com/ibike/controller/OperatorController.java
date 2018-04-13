package com.ibike.controller;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Operator;
import com.ibike.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    public OperatorController(){}

    public OperatorController(OperatorService operatorService){
        this.operatorService = operatorService;
    }

    @RequestMapping("/addOperator/{oName}")
    public String addOp(@PathVariable String oName){
        Operator o = new Operator(oName, LocalDateTime.now(),0.0, 0);
        operatorService.newOperator(o);
        return "ok";
    }

    @RequestMapping(value = "/getOperator/{id}")
    public String addOp(@PathVariable int id){
        Operator o = operatorService.findById(id);
        return o.toString();
    }

    @RequestMapping("/setDeposit/{id}/{deposit}")
    public int setDeposit(@PathVariable int id, @PathVariable double deposit){
        return operatorService.setOperatorDeposit(deposit, id);
    }
}

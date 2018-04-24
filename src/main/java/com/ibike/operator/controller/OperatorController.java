package com.ibike.operator.controller;

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
@RequestMapping(value = "/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    public OperatorController() {
    }

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }


    //    String operatorName, String englishName, String address, String establishedTime, LocalDateTime createTime, double deposit, double credit, int isRunning, String leader
    @RequestMapping("/addOperator/{name}/{eName}/{address}/{establishedTime}/{leader}")
    public String addOp(@PathVariable String name, @PathVariable String eName, @PathVariable String address, @PathVariable String establishedTime, @PathVariable String leader) {
        try {
            Operator o = new Operator(name, eName, address,establishedTime, LocalDateTime.now(), 0.0, 0.0, 0, leader);
            operatorService.newOperator(o);
        } catch (Exception e) {
            return e.toString();
        }
        return "ok";
    }

    @RequestMapping(value = "/getOperator/{id}")
    public String addOp(@PathVariable int id) {
        try {
            Operator o = operatorService.findById(id);
            return o.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping("/setDeposit/{id}/{deposit}")
    public String setDeposit(@PathVariable int id, @PathVariable double deposit) {
        try {
            operatorService.setOperatorDeposit(deposit, id);
            return "ok";
        } catch (Exception e) {
            return e.toString();
        }
    }

    /**
     * 待定
     * @param id
     * @return
     */
    @RequestMapping("/run/{id}/{state}")
    public String start(@PathVariable int id, @PathVariable int state){
        try {
            if(state != 0 && state != 1)
                return "illegal parameter for running state";
            Operator o = operatorService.findById(id);
            o.setIsRunning(state);
            operatorService.save(o);
            return "ok";
        } catch (Exception e) {
            return "Exception caused by:" + e.toString();
        }
    }

    @RequestMapping("/all/{isRunning}")
    public  List<Operator> getAllRunning(@PathVariable int isRunning){
        List<Operator> os = operatorService.findRunningOp(isRunning);
        return os;
    }
}

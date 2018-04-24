package com.ibike.credit.controller;

import com.ibike.credit.domain.CreditRecord;
import com.ibike.credit.domain.CreditRule;
import com.ibike.credit.service.CreditRecordService;
import com.ibike.credit.service.CreditRuleService;
import com.ibike.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/creditRecord")
public class CreditRecordController {

    @Autowired
    CreditRecordService creditRecordService;
    @Autowired
    CreditRuleService ruleService;
    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/check/{check}")
    public List<CreditRecord> getContract(@PathVariable int check){

        List<CreditRecord> creditRecords = null;
        try {
            creditRecords = creditRecordService.findAllCheckedRecord(check);
        }catch (Exception e){

        }
        return creditRecords;
    }
//    http://localhost:8080/creditRecord/add/mobike/15
    @RequestMapping(value = "/add/{opName}/{ruleId}")
    public String save(@PathVariable String opName, @PathVariable int ruleId){
        try{
            CreditRule rule = ruleService.getById(ruleId);
            creditRecordService.save(new CreditRecord(LocalDateTime.now(), LocalDateTime.now(), opName, rule, 0));
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        try{
            creditRecordService.deleteById(id);
        }catch (Exception e){
            return e.toString();
        }
        return "delete successfully";
    }

    @RequestMapping(value = "/update/{id}")
    public String check(@PathVariable int id){
        try{
            CreditRecord record = creditRecordService.findById(id);
            record.setIsChecked(1);
            creditRecordService.save(record);
        }catch (Exception e){
            return e.toString();
        }
        return "checks successfully";
    }

//    http://localhost:8080/creditRecord/exec/17
    @RequestMapping(value = "/exec/{id}")
    public String execRecord(@PathVariable int id){
        try{
            CreditRecord record = creditRecordService.findById(id);
            double point = record.getRule().getPoint();
            operatorService.updatePoint(record.getOperatorName(), point);
        }catch (Exception e){
            return e.toString();
        }

        return "exec successfully";
    }
}

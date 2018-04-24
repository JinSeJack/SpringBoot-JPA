package com.ibike.credit.controller;

import com.ibike.credit.domain.CreditRule;
import com.ibike.credit.service.CreditRuleService;
import com.ibike.operator.domain.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/creditRule")
public class CreditRuleController {

    @Autowired
    CreditRuleService ruleService;

    @RequestMapping(value = "/check/{check}")
    public List<CreditRule> getRule(@PathVariable int check){

        List<CreditRule> ruls = null;
        try {
            ruls = ruleService.findAllCheckedCreditRules(check);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ruls;
    }
//    http://localhost:8080/creditRule/add/%E8%BF%9D%E5%81%9C/-2/%E4%B9%B1%E5%81%9C%E4%B9%B1%E6%94%BE%E7%9A%84%E8%BD%A6%E5%AD%90%E8%BF%90%E8%90%A5%E5%95%86%E6%89%A32%E5%88%86
    @RequestMapping(value = "/add/{name}/{point}/{description}")
    public String save(@PathVariable double point, @PathVariable String name, @PathVariable String description){
        try{
            CreditRule rule = new CreditRule(LocalDateTime.now(), LocalDateTime.now(), name, point, description, 0);
            ruleService.save(rule);
            return "成功了";
        }catch (Exception e){
            e.printStackTrace();
            return "出错了";
        }

    }

    @RequestMapping(value = "/delete/{id}")
    public String delete( @PathVariable int id){

        try{
            ruleService.delete(id);
            return "成功了";
        }catch (Exception e){
            e.printStackTrace();
            return "出错了";
        }
    }

    @RequestMapping(value = "/updateCheck/{id}")
    public String updateCheck( @PathVariable int id){

        try{
            CreditRule rule = ruleService.getById(id);
            rule.setIsChecked(1);
            ruleService.save(rule);
            return "成功了";
        }catch (Exception e){
            e.printStackTrace();
            return "出错了";
        }
    }



}

package com.ibike.operator.controller;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.DepositRecord;
import com.ibike.operator.domain.Operator;
import com.ibike.operator.service.ContactService;
import com.ibike.operator.service.DepositService;
import com.ibike.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/Deposit")
public class DepositController {

    @Autowired
    DepositService depositService;
    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/getDeposits/{operatorId}")
    public List<DepositRecord> getDeposit(@PathVariable int operatorId){

        List<DepositRecord> records = null;
        try {
            records = depositService.findAllContractByOperatorId(operatorId);
        }catch (Exception e){

        }
        return records;
    }

    /**
     * 存下一次押金
     * @param operatorId
     * @param deposit
     * @return
     */
    @RequestMapping(value = "/add/{deposit}/{operatorId}")
    public String save(@PathVariable int operatorId, @PathVariable double deposit){

        try{
            Operator o = operatorService.findById(operatorId);
            depositService.save(new DepositRecord(o, LocalDateTime.now(), LocalDateTime.now(), 0, deposit));
            return "成功了";
        }catch (Exception e){
            return "出错了";
        }

    }

    @RequestMapping(value = "/delete/{depositId}")
    public String delete( @PathVariable int depositId){

        try{
            depositService.deleteById(depositId);
            return "成功了";
        }catch (Exception e){
            return "出错了";
        }
    }

    @RequestMapping(value = "/update/{depositId}")
    public String update( @PathVariable int depositId){
        try{
            DepositRecord record = depositService.findById(depositId);
            record.setIsDepositChecked(1);
            depositService.saveDeposit(record);
            return "成功了";
        }catch (Exception e){
            return "出错了";
        }
    }

    @RequestMapping(value = "/updateCheck/{depositId}")
    public String updateCheck( @PathVariable int depositId){

        try{

            depositService.updateCheckByDepositId(depositId);
//            更新运营商押金余额，如果在更新过程出现异常，回滚状态改变
            updateOperatorDeposit(depositId);
            return "成功了";
        }catch (Exception e){
            e.printStackTrace();
            return "出错了";
        }
    }

    private void updateOperatorDeposit(int depositId) {
        try{
            DepositRecord record = depositService.findById(depositId);
            operatorService.setOperatorDeposit(record.getOperator().getDeposit() + record.getDeposit(), record.getOperator().getId());

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }



}

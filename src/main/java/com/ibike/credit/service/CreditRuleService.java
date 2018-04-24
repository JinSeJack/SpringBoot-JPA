package com.ibike.credit.service;

import com.ibike.credit.domain.CreditRule;
import com.ibike.credit.repository.CreditRuleRepository;

import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditRuleService implements JpaService<CreditRuleRepository> {
    @Override
    public CreditRuleRepository repository() {
        return creditRuleRepository;
    }

    public CreditRuleService(CreditRuleRepository creditRuleRepository) {
        this.creditRuleRepository = creditRuleRepository;
    }

    @Autowired
    private final CreditRuleRepository creditRuleRepository;

    public List<CreditRule> findAllCheckedCreditRules(int check) {
        return creditRuleRepository.getChecked(check);
    }

    public void save(CreditRule record) {
        creditRuleRepository.save(record);
    }

    public void delete(int id){
        creditRuleRepository.deleteById(id);
    }

    public void delete(CreditRule c){
        creditRuleRepository.delete(c);
    }

    public CreditRule getById(int id){
         return creditRuleRepository.getCreditRuleById(id);
    }
}

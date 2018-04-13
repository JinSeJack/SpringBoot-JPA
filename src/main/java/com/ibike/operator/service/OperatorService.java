package com.ibike.operator.service;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Operator;
import com.ibike.operator.repository.OperatorRepository;
import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class OperatorService implements JpaService<OperatorRepository> {

    @Autowired
    private final OperatorRepository operatorRepository;


    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public OperatorRepository repository() {
        return operatorRepository;
    }

    public void newOperator(Operator o){
        operatorRepository.save(o);
    }

    public Operator findById(int id){
        return operatorRepository.findFirstById(id);
    }

    public int setOperatorDeposit(double deposit, int id){
        return operatorRepository.setOperatorDeposit(deposit, id);
    }

}

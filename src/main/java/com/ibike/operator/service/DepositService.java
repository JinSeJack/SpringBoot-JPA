package com.ibike.operator.service;

import com.ibike.operator.domain.DepositRecord;
import com.ibike.operator.repository.DepositRepository;
import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService implements JpaService<DepositRepository> {
    @Override
    public DepositRepository repository() {
        return depositRepository;
    }

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Autowired
    private final DepositRepository depositRepository;

    public List<DepositRecord> findAllContractByOperatorId(int id) {
        return depositRepository.findAllRecordsByOperatorId(id);
    }

    public void save(DepositRecord record) {
        depositRepository.save(record);
    }

    public void deleteById(int depositId) {
        depositRepository.deleteById(depositId);
    }

//    public void updateByDepositId(int depositId, double deposit) {
//        depositRepository.updateById(depositId, deposit);
//    }

    public void updateCheckByDepositId(int depositId) {
        depositRepository.updateCheckById(depositId);
    }

    public DepositRecord findById(int depositId) {
        return depositRepository.getDepositRecordById(depositId);
    }

    public void saveDeposit(DepositRecord record){
        depositRepository.save(record);
    }

}

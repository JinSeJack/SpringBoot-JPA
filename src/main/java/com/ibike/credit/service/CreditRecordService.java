package com.ibike.credit.service;

import com.ibike.credit.domain.CreditRecord;
import com.ibike.credit.repository.CreditRecordRepository;
import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditRecordService implements JpaService<CreditRecordRepository> {
    @Override
    public CreditRecordRepository repository() {
        return creditRecordsRepository;
    }

    public CreditRecordService(CreditRecordRepository creditRecordsRepository) {
        this.creditRecordsRepository = creditRecordsRepository;
    }

    @Autowired
    private final CreditRecordRepository creditRecordsRepository;

    public List<CreditRecord> findAllCheckedRecord(int check) {
        return creditRecordsRepository.findChecked(check);
    }

    public void save(CreditRecord record) {
        creditRecordsRepository.save(record);
    }

    public void deleteById(int id) {
        creditRecordsRepository.deleteById(id);
    }


    public CreditRecord findById(int id) {
        return creditRecordsRepository.getCreditRecordById(id);
    }

    public void saveCreditRecord(CreditRecord record){
        creditRecordsRepository.save(record);
    }

}

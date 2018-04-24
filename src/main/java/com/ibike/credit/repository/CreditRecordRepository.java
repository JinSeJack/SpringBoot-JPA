package com.ibike.credit.repository;

import com.ibike.credit.domain.CreditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditRecordRepository extends JpaRepository<CreditRecord, Integer> {

    /*
     *@id 即By后面的Id名称，方法名中的字段如果在对应的表中不存在会导致应用无法启动，
     * 此时可以通过maven install命令来定位错误
     */
    List<CreditRecord> findAllById(int id);

    @Query("select r from CreditRecord r where r.isChecked = :isChecked")
    List<CreditRecord> findChecked(int isChecked);

    CreditRecord getCreditRecordById(int id);
}

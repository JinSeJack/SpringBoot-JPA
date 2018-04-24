package com.ibike.operator.repository;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.DepositRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepositRepository extends JpaRepository<DepositRecord, Integer> {

    /*
     *@id 即By后面的Id名称，方法名中的字段如果在对应的表中不存在会导致应用无法启动，
     * 此时可以通过maven install命令来定位错误
     */
    List<DepositRecord> findAllRecordsByOperatorId(int id);

//    @Modifying
//    @Transactional
//    @Query("update DepositRecord d set d.deposit = :deposit where d.id = :depositId")
//    void updateById(@Param("id")int depositId, @Param("deposit") double deposit);

    @Modifying
    @Transactional
    @Query("update DepositRecord d set d.isDepositChecked = 1 where d.id = :depositId")
    void updateCheckById(@Param("depositId") int depositId);

    @Query("select '*' from DepositRecord d where d.id = :depositId")
    DepositRecord findOneById(@Param("depositId") int depositId);

    DepositRecord getDepositRecordById(int id);


}

package com.ibike.operator.repository;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {

    Operator findFirstById(int id);

    @Modifying
    @Transactional(readOnly = false)
    @Query("update Operator o set o.deposit = :deposit where o.id = :id")
    int setOperatorDeposit(@Param("deposit")double deposit, @Param("id")int id);

    @Query("select o from Operator o where o.operatorName = :operatorName")
    Operator getByName(@Param("operatorName")String operatorName);

    @Query("select o from Operator o where o.isRunning = :i")
    List<Operator> findAllRunning(@Param("i") int i);

//    @Modifying
//    @Transactional(readOnly = false)
//    @Query("UPDATE operator o SET  o.deposit = o.deposit + (SELECT d.deposit FROM depositrecord d WHERE d.id = 11) WHERE o.id = (SELECT  de.operator_id FROM depositrecord de WHERE de.id = 11)")
//    void updateDeposit (@Param("deposit") int depositId);

}

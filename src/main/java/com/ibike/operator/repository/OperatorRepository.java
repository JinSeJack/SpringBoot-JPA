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


}

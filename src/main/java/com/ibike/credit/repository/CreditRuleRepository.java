package com.ibike.credit.repository;

import com.ibike.credit.domain.CreditRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CreditRuleRepository extends JpaRepository<CreditRule, Integer> {

    /*
     *@id 即By后面的Id名称，方法名中的字段如果在对应的表中不存在会导致应用无法启动，
     * 此时可以通过maven install命令来定位错误
     */
    List<CreditRule> findAllById(int id);

    @Modifying
    @Transactional
    @Query("update CreditRule d set d.isChecked = 1 where d.id = :id")
    void updateCheckById(@Param("id") int id);

    CreditRule getCreditRuleById(int id);

    @Query("select r from CreditRule r where r.isChecked = :isChecked")
    List<CreditRule> getChecked(@Param("isChecked")int isChecked);

}

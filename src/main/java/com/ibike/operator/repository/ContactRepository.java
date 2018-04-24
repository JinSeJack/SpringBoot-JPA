package com.ibike.operator.repository;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    /*
     *@id 即By后面的Id名称，方法名中的字段如果在对应的表中不存在会导致应用无法启动，
     * 此时可以通过maven install命令来定位错误
     */
    List<Contact> findAllContractByOperatorId(int id);

    Contact getContactById(int id);
}

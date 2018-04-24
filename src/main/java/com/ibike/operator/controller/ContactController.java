package com.ibike.operator.controller;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Operator;
import com.ibike.operator.repository.ContactRepository;
import com.ibike.operator.service.ContactService;
import com.ibike.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/getOpCont/{operatorId}")
    public List<Contact> getContract(@PathVariable int operatorId){

        List<Contact> contacts = null;
        try {
            contacts = contactService.findAllContractByOperatorId(operatorId);
        }catch (Exception e){

        }
        return contacts;
    }

//    /addCont/zhangsan/65320120/7/dispatcher
    @RequestMapping(value = "/addCont/{name}/{phone}/{id}/{type}")
    public String save(@PathVariable String name, @PathVariable String phone, @PathVariable int id, @PathVariable String type){
        try{
            Operator operator = operatorService.findById(id);
            contactService.save(new Contact(name, LocalDateTime.now(), LocalDateTime.now(), phone, operator, type, 0));
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        try{
            contactService.delete(id);
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }

    @RequestMapping(value = "/check/{id}")
    public String check(@PathVariable int id){
        try{
            Contact c = contactService.getById(id);
            c.setIsChecked(1);
            contactService.save(c);
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }
}

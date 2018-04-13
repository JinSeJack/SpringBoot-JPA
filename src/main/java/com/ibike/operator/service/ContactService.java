package com.ibike.operator.service;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.repository.ContactRepository;
import com.ibike.operator.repository.OperatorRepository;
import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements JpaService<ContactRepository> {
    @Override
    public ContactRepository repository() {
        return contactRepository;
    }

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Autowired
    private final ContactRepository contactRepository;

    public List<Contact> findAllContractByOperatorId(int id) {
        return contactRepository.findAllContractByOperatorId(id);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }
}

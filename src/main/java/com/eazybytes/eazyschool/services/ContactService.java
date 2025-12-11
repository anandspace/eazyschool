package com.eazybytes.eazyschool.services;

import com.eazybytes.eazyschool.models.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ContactService {

    private Logger logger = Logger.getLogger(ContactService.class.getName());

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        logger.info(contact.toString());
        return isSaved;
    }
}

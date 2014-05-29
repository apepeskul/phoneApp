package com.apepeskul.service;

import com.apepeskul.dao.PhoneDao;
import com.apepeskul.domain.Phone;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    Gson gson = new Gson();

    @Autowired
    PhoneDao mPhoneDao;

    @Override
    public String getAll() {
        List<Phone> phoneList = mPhoneDao.getAll();

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.add("aaData",gson.toJsonTree(phoneList));
        return jsonResponse.toString();

    }

    @Override
    public String getById(long id) {
        return gson.toJson(mPhoneDao.get(id)).toString();
    }
}
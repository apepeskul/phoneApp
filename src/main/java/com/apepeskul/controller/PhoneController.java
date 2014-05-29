package com.apepeskul.controller;

import com.apepeskul.dao.PhoneDao;
import com.apepeskul.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alex on 28.05.2014.
 */
@Controller
public class PhoneController {

    @Autowired
    PhoneDao mPhoneDao;
    @Autowired
    PhoneService mPhoneService;

    @RequestMapping(value = "/home")
    public String hello(Model model) {

   /* Phone phone = new Phone("Alex", "095-222-31-20");
    mPhoneDao.save(phone);
    model.addAttribute("phone", phone);*/
        model.addAttribute("phones", mPhoneDao.getAll());
        return "phone";
    }

    @RequestMapping(value = "/phones/get")
    public
    @ResponseBody
    String getAll() {
        return mPhoneService.getAll();

    }

    @RequestMapping (value = "/phone/{id}")
    public @ResponseBody String editPhone(@PathVariable("id") int id){
        return mPhoneService.getById(id);
    }

}

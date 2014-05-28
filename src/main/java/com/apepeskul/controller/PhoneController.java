package com.apepeskul.controller;

import com.apepeskul.dao.PhoneDao;
import com.apepeskul.dao.PhoneDaoImpl;
import com.apepeskul.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alex on 28.05.2014.
 */
 @Controller
public class PhoneController {

    @Autowired
    PhoneDao mPhoneDao;

@RequestMapping (value = "/home")
public String hello(Model model){

   /* Phone phone = new Phone("Alex", "095-222-31-20");
    mPhoneDao.save(phone);
    model.addAttribute("phone", phone);*/
    model.addAttribute("phones", mPhoneDao.getAll());
return "phone";
}

}

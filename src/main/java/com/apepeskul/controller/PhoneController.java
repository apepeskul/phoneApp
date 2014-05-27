package com.apepeskul.controller;

import com.apepeskul.domain.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alex on 28.05.2014.
 */
 @Controller
public class PhoneController {

@RequestMapping (value = "/")
public String hello(Model model){

    Phone phone = new Phone("Alex", "095-222-31-20");
    model.addAttribute("phone", phone);
return "phone";
}

}

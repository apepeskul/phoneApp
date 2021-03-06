package com.apepeskul.controller;

import com.apepeskul.dao.PhoneDao;
import com.apepeskul.dto.PhoneDto;
import com.apepeskul.service.PhoneService;
import com.apepeskul.validator.PhoneValidator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PhoneController {

    @Autowired
    PhoneDao mPhoneDao;
    @Autowired
    PhoneService mPhoneService;

    @Autowired
    PhoneValidator mPhoneValidator;


    @RequestMapping(value = "/")
    public String hello(Model model) {

        model.addAttribute("phones", mPhoneDao.getAll());
        model.addAttribute("phone", new PhoneDto());
        return "phone";
    }

    @RequestMapping(value = "/phones/get")
    public
    @ResponseBody
    String getAll() {
        return mPhoneService.getAll();
    }

    @RequestMapping(value = "/phone/{id}")
    public
    @ResponseBody
    String editPhone(@PathVariable("id") int id) {
        return mPhoneService.getById(id);
    }

    @RequestMapping(value = "/phone/delete/{id}")
    public String deletePhone(@PathVariable("id") long id) {
        mPhoneService.delete(id);
        return "phone";
    }

    @RequestMapping(value = "/phone/save", produces = {"application/json; charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public String savePhone(@Valid PhoneDto phone, BindingResult bindingResult) {
        JsonResponse jsonResponse = new JsonResponse();

        mPhoneValidator.validate(phone, bindingResult);
        if (!bindingResult.hasErrors()) {
            mPhoneService.save(phone);
        } else {
            Map<String, String> errors = new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            jsonResponse.setErrorsMap(errors);
            jsonResponse.setStatus("ERROR");

        }
        Gson gson = new Gson();
        return gson.toJson(jsonResponse);
    }

    @RequestMapping(value = "/phone/update", produces = {"application/json; charset=UTF-8"}, method = RequestMethod.POST)
    @ResponseBody
    public String updatePhone(@Valid PhoneDto phone, BindingResult bindingResult) {
        JsonResponse jsonResponse = new JsonResponse();

        if (!bindingResult.hasErrors()) {
            mPhoneService.update(phone);
        } else {
            Map<String, String> errors = new HashMap<String, String>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            jsonResponse.setErrorsMap(errors);
            jsonResponse.setStatus("ERROR");

        }
        Gson gson = new Gson();
        return gson.toJson(jsonResponse);
    }


    class JsonResponse {
        private String status;
        private Map<String, String> errorsMap;

        public void setStatus(String status) {
            this.status = status;
        }

        public void setErrorsMap(Map<String, String> errorsMap) {
            this.errorsMap = errorsMap;
        }

    }


}

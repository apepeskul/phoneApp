package com.apepeskul.service;

import com.apepeskul.dto.PhoneDto;

/**
 * Created by admin on 5/29/2014.
 */
public interface PhoneService {
    String getAll();

    String getById(long id);

    void delete(long id);

    void save(PhoneDto phone);

    void update(PhoneDto phone);
}

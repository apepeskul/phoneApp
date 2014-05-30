package com.apepeskul.service;

import com.apepeskul.dto.PhoneDto;

public interface PhoneService {
    String getAll();

    String getById(long id);

    void delete(long id);

    void save(PhoneDto phone);

    void update(PhoneDto phone);
}

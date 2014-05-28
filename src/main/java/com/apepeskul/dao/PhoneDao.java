package com.apepeskul.dao;


import com.apepeskul.domain.Phone;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface PhoneDao {
    public Phone get(int id);
    public void delete (int id);
    public void update (Phone phone);
    public void save (Phone phone);
    public List<Phone> getAll();

}

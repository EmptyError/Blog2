package com.yana.home.persistence.service.implementation;

import com.yana.home.persistence.domain.Currency;
import com.yana.home.persistence.repository.CurrencyRepo;
import com.yana.home.persistence.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 13.05.2017.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;
    @Override
    public void add(Currency currency) {
        currencyRepo.save(currency);
    }

    @Override
    public void delete(int id) {
currencyRepo.delete(id);
    }

    @Override
    public void edit(Currency currency) {
currencyRepo.save(currency);
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepo.findAll();
    }
    public Currency findById(int id){
        return currencyRepo.findOne(id);
    }
}

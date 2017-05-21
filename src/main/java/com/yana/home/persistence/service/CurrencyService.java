package com.yana.home.persistence.service;

import com.yana.home.persistence.domain.Currency;

import java.util.List;

/**
 * Created by Admin on 13.05.2017.
 */
public interface CurrencyService {
    public  void  add(Currency currency);
    public  void delete(int id);
    public void edit(Currency currency);

    public List<Currency> findAll();
    public Currency findById(int id);
}

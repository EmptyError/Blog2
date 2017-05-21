package com.yana.home.persistence.repository;

import com.yana.home.persistence.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Admin on 12.05.2017.
 */
public interface CurrencyRepo extends JpaRepository<Currency,Integer> {

}

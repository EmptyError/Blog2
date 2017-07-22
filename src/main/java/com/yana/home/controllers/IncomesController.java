package com.yana.home.controllers;

import com.yana.home.persistence.domain.*;
import com.yana.home.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/**
 * Created by Admin on 30.05.2017.
 */
@Controller
public class IncomesController {
    @Autowired
    private UserService userService;

    @Autowired
    private SpendingService spendingService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/incomes",method = RequestMethod.GET)
    public  String incomes(Principal principal, Model model){
        User user=userService.findByLogin(principal.getName());
        List<User> users =userService.findAll();
        List<Account> accounts=accountService.findByUser(user);
        List<Currency> currencyList= currencyService.findAll();
        List<Category> categories=categoryService.findAll();
List<Income> incomes=incomeService.findAllByUser(user);
model.addAttribute("incomes",incomes);
        model.addAttribute("accounts",accounts);
        model.addAttribute("currencyList",currencyList);
        model.addAttribute("user",user);
        model.addAttribute("sumSpending",spendingService.sumAllSpendingsForUser(user));
        model.addAttribute("sumIncomes",incomeService.findSumIncomes(user));
        model.addAttribute("balance",accountService.balanceAccount(user));
        model.addAttribute("categories",categories);
        return"incomes";
    }
    @RequestMapping(value = "/get/incomes/chart",method = RequestMethod.GET)
    @ResponseBody
    public List<Income> getIncomes(Principal principal){
        User user=userService.findByLogin(principal.getName());
        return incomeService.findAllByUser(user);

    }

}

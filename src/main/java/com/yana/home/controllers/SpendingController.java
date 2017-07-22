package com.yana.home.controllers;

import com.yana.home.persistence.domain.Income;
import com.yana.home.persistence.domain.Spending;
import com.yana.home.persistence.domain.User;
import com.yana.home.persistence.service.SpendingService;
import com.yana.home.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/**
 * Created by Admin on 17.06.2017.
 */
@Controller
public class SpendingController {
    @Autowired
    private UserService userService;
    @Autowired
    private SpendingService spendingService;
    @RequestMapping(value = "/spending",method = RequestMethod.GET)
    public String spending(Principal principal,Model model){
        User user=userService.findByLogin(principal.getName());
        List<Spending> spendingList=spendingService.findAllByUser(user);
model.addAttribute("user",user);
        model.addAttribute("spendingList",spendingList);
        return "spending";
    }
    @RequestMapping(value = "/get/spending/chart",method = RequestMethod.GET)
    @ResponseBody
    public List<Spending> getIncomes(Principal principal){
        User user=userService.findByLogin(principal.getName());
        return spendingService.findAllByUser(user);

    }
}

package com.yana.home.controllers;


import com.yana.home.persistence.domain.*;
import com.yana.home.persistence.repository.SpendingRepo;
import com.yana.home.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

/**
 * Created by Admin on 08.05.2017.
 */
@Controller
public class BaseController {
    @Qualifier(value = "userValidator")
    @Autowired
    private Validator validator;

    @Autowired
    private UserService userService;

@Autowired
    private SpendingService spendingService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private  IncomeService incomeService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model,Principal principal) {
        User user=userService.findByLogin(principal.getName());
        List<User> users =userService.findAll();
        List<Account> accounts=accountService.findByUser(user);
        List<Currency> currencyList= currencyService.findAll();
        List<Category> categories=categoryService.findAll();


        model.addAttribute("accounts",accounts);
        model.addAttribute("currencyList",currencyList);
        model.addAttribute("user",user);
        model.addAttribute("sumSpending",spendingService.sumAllSpendingsForUser(user));
        model.addAttribute("sumIncomes",incomeService.findSumIncomes(user));
        model.addAttribute("balance",accountService.balanceAccount(user));
        model.addAttribute("categories",categories);

        return "home";
    }


    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login() {

        return "loginPage";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public  String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute User user,BindingResult bindingResult) {
        validator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.add(user);
            return "redirect:/loginPage";
        }
    }
    @RequestMapping(value = "/account/add/",method = RequestMethod.POST)

    @ResponseBody
    public  void  addAccount(@RequestBody String [] array,Principal principal){
        User user=userService.findByLogin(principal.getName());
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        int currencyId=Integer.parseInt(array[3]);
        double currencyAmount=Double.parseDouble(array[1]);
        Currency currency=currencyService.findById(currencyId);
        Account account= new Account(array[0],currencyAmount,array[2],currency,user);
        accountService.add(account);



    }

    @RequestMapping(value="/account/find/all",method = RequestMethod.GET)
    @ResponseBody

    public List<Account> getAccount(Principal principal){
        User user=userService.findByLogin(principal.getName());
        System.out.println("before");
        System.out.println(accountService.findByUser(user));
       return accountService.findByUser(user);

    }

    @RequestMapping(value = "/add/income/{id}",method = RequestMethod.GET)
    public String addIncome(Model model,Principal principal,@PathVariable Integer id){
        Account account=accountService.findOne(id);
        User user=userService.findByLogin(principal.getName());
        model.addAttribute("account",account);
        model.addAttribute("user",user);

        return "addIncome";
    }

    @RequestMapping(value ="/add/income/{id}",method = RequestMethod.POST)
    public  String addIncomeProcessing(@RequestParam("description") String description,@RequestParam("amount") double amount,
                                       @RequestParam("date")String date,@PathVariable Integer id,
                                       Principal principal){
        Account account=accountService.findOne(id);
        User user=userService.findByLogin(principal.getName());
        System.out.println(date);
       incomeService.add(description,amount,date,account,user);
        account.setAmount(account.getAmount()+amount);
accountService.edit(account);



        return "redirect:/";
    }
    @RequestMapping(value = "/delete/account/{id}",method = RequestMethod.GET)
    public  String deleteAccount(@PathVariable Integer id){


       accountService.delete(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/category/add",method = RequestMethod.POST)
    @ResponseBody
    public void categoryAdd(@RequestBody String array[], Principal principal){
        User user=userService.findByLogin(principal.getName());
        Category category=new Category(array[0],array[1],user);
        categoryService.add(category);
    }

    @RequestMapping(value = "/category/find/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> categoryFindAll(Principal principal){
        User user=userService.findByLogin(principal.getName());
return categoryService.findAllByUser(user);
    }
    @RequestMapping(value = "/delete/category/{id}",method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/add/spending/{id}",method = RequestMethod.GET)
    public String addSpendingForCategory(@PathVariable Integer id,Principal principal,Model model){
        User user=userService.findByLogin(principal.getName());
        Category category=categoryService.findOne(id);
        List<Account> accounts= accountService.findByUser(user);

        model.addAttribute("accounts",accounts);
        model.addAttribute("user",user);
        model.addAttribute("category",category);
        return "addSpending";
    }
@RequestMapping(value = "/add/spending/{id}",method = RequestMethod.POST)
    public  String addSpendingProcessing(@PathVariable Integer id,@RequestParam("description")String description,@RequestParam("amount") double amount,
                                         @RequestParam("date") String date,@RequestParam("account") int accountId,Principal principal){
    User user=userService.findByLogin(principal.getName());
    Category category=categoryService.findOne(id);
    category.setAmount(category.getAmount()+amount);
    categoryService.edit(category);
     Account account =accountService.findOne(accountId);
     account.setAmount(account.getAmount()-amount);
     accountService.edit(account);
        spendingService.add(description,amount,date,category,account,user);

        return "redirect:/";
}
@RequestMapping(value = "/add/photo",method = RequestMethod.GET)
public String addPhoto(Principal principal){
    User user=userService.findByLogin(principal.getName());

        return "addPhoto";
}
@RequestMapping(value = "/add/photo" ,method = RequestMethod.POST)
public String addPhoto(Principal principal, @RequestParam("photo") MultipartFile multipartFile){
    User user=userService.findByLogin(principal.getName());
    userService.addPhoto(multipartFile,user);
    return "redirect:/";
}
@RequestMapping(value = "/activate/{activationKey}",method = RequestMethod.GET)
String activate(@PathVariable String activationKey){
    userService.activate(activationKey);
    return "redirect:/";
}

}

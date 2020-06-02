package royalstacks.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import royalstacks.app.model.Account;
import royalstacks.app.model.BusinessAccount;
import royalstacks.app.model.Customer;
import royalstacks.app.model.PrivateAccount;
import royalstacks.app.service.AccountService;
import royalstacks.app.service.CustomerService;

import java.util.List;
import java.util.Set;

@Controller
public class AccountDetails {
    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    public AccountDetails() {
    }

    @GetMapping("/accountdetails")
    public ModelAndView accountDetailsHandler(){

        //TODO:get account from DB with account ID


        Account account = accountService.getAccountById(354);   //for now dummy account


        //TODO: get accounttype so it can be shown which account which accounttype
        //TODO: get current Date and Time


        //TODO:get list accountholders from DB
        Set<Customer> accountholders = account.getAccountHolders();
        //each accountholder should be shown in html

       //TODO: get transactions corresponding to this account from nosql DB en show only ten last transaction

        ModelAndView mav = new ModelAndView("/accountdetails");
        mav.addObject("account",account);
        mav.addObject("list",accountholders);

        return mav;
    }

    //TODO method give action to new transfer button
        //should go to the transaction html page
    @GetMapping("transaction")
    public ModelAndView goToTransactionHandler(@ModelAttribute("account") Account account){
        ModelAndView mav = new ModelAndView("transaction");
        mav.addObject("account",account);
        return mav;

    }
}

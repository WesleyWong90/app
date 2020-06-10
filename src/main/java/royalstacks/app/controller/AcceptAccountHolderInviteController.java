package royalstacks.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import royalstacks.app.backingBean.AccountHolderInviteBackingBean;
import royalstacks.app.model.Account;
import royalstacks.app.model.AccountHolderInvite;
import royalstacks.app.model.Customer;
import royalstacks.app.model.User;
import royalstacks.app.service.AccountHolderInviteService;
import royalstacks.app.service.AccountService;
import royalstacks.app.service.UserService;

import java.util.Optional;

@Controller
public class AcceptAccountHolderInviteController {

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @Autowired
    AccountHolderInviteService accountHolderInviteService;


    @GetMapping("/acceptaccountholderinvite")
    public ModelAndView acceptAccountHolderInviteHandler(@SessionAttribute("userid") int userId) {
        return new ModelAndView("acceptaccountholderinvite");
    }


    @PostMapping("/acceptaccountholderinvite")
    public ModelAndView acceptAccountHolderInviteHandler(@ModelAttribute AccountHolderInviteBackingBean ibb,
                                                         @SessionAttribute("userid") int userId,
                                                         Model model) {
        ModelAndView mav = new ModelAndView("addaccountholder");
        User invitee = null;
        Account accountToBeAdded = null;

        //met meegegeven userId de user ophalen en ifPresent get als invitee
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            invitee = optionalUser.get();
        }

        // vanuit de backing bean een optional account ophalen en ifPresent get als account
        Optional<Account> optionalAccount = accountService.getAccountByAccountNumber(ibb.getAccountNumber());
        if (optionalAccount.isPresent()) {
            accountToBeAdded = optionalAccount.get();
        }

        // invite aanmaken en checken of deze in de DB bestaat (Customer invitee, Account account, String verif.code)
        AccountHolderInvite inviteToBeVerified = new AccountHolderInvite((Customer) invitee, accountToBeAdded, ibb.getVerificationCode());
        Optional<AccountHolderInvite> existingInvite = accountHolderInviteService.findAccountHolderInviteByAccountAndInviteeAndCode(inviteToBeVerified.getInvitee().getUserid(), inviteToBeVerified.getAccount().getAccountId(), inviteToBeVerified.getVerificationCode());
        //ifPresent: voeg customer toe als accountholder en geef bevestiging aan klant
        // TODO moet hier meer gebeuren? Boolean isBusinessAccountHolder en Employee accountmanager! ZIE OPENACCOUNTCONTROLLER
        if (existingInvite.isPresent()){
            // TODO wat gebeurt er als men al accountholder was van dezelfde account?
            accountToBeAdded.addAccountHolder((Customer) invitee);
            accountService.saveAccount(accountToBeAdded);
            displayMessage("Account added.", mav);
            System.out.println("Account added");
        }
        // TODO hier wordt nu nog een héél verkeerd scherm getoond haha
        return mav;
    }


    private void displayMessage(String message, ModelAndView mav){
        mav.addObject("message", message);
    }


    private void populateFields(AccountHolderInviteBackingBean ibb, ModelAndView mav) {
        mav.addObject("accountNumber",ibb.getAccountNumber());
        mav.addObject("verificationCode", ibb.getVerificationCode());
    }


}

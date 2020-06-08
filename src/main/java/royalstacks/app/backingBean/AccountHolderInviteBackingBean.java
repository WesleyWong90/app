package royalstacks.app.backingBean;

import royalstacks.app.model.Account;
import royalstacks.app.model.AccountHolderInvite;
import royalstacks.app.model.Customer;
import royalstacks.app.model.User;

import java.util.Objects;

public class AccountHolderInviteBackingBean {

    private Customer invitee;
    private String inviteeUsername;
    private Account account;
    private String accountNumber;
    private String verificationCode;

    public AccountHolderInviteBackingBean(String inviteeUsername, String accountNumber, String verificationCode) {
        this.inviteeUsername = inviteeUsername;
        this.accountNumber = accountNumber;
        this.verificationCode = verificationCode;
    }

/*    public AccountHolderInvite accountHolderInvite() {
        AccountHolderInvite accountHolderInvite = new AccountHolderInvite(invitee, account, verificationCode);
        return accountHolderInvite;
    }*/

    public AccountHolderInvite accountHolderInvite(Customer invitee, Account account, String verificationCode) {
        AccountHolderInvite accountHolderInvite = new AccountHolderInvite(invitee, account, verificationCode);
        return accountHolderInvite;
    }


    // creates a backing bean from accountHolderInvite (heb ik deze nodig?)
    public static AccountHolderInviteBackingBean createAccountHolderInviteBackingBean(AccountHolderInvite accountHolderInvite) {
        AccountHolderInviteBackingBean ahibb =
                new AccountHolderInviteBackingBean(accountHolderInvite.getInvitee().getUsername(), accountHolderInvite.getAccount().getAccountNumber(), accountHolderInvite.getVerificationCode());
        return ahibb;
    }

    public Customer getInvitee() {
        return invitee;
    }

    public void setInvitee(Customer invitee) {
        this.invitee = invitee;
    }

    public String getInviteeUsername() {
        return inviteeUsername;
    }

    public void setInviteeUsername(String inviteeUsername) {
        this.inviteeUsername = inviteeUsername;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolderInviteBackingBean that = (AccountHolderInviteBackingBean) o;
        return Objects.equals(inviteeUsername, that.inviteeUsername) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(verificationCode, that.verificationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inviteeUsername, accountNumber, verificationCode);
    }*/

    @Override
    public String toString() {
        return "AccountHolderInviteBackingBean{" +
                "inviteeUsername='" + inviteeUsername + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}

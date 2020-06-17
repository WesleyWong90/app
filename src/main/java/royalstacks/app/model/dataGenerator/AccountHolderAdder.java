package royalstacks.app.model.DataGenerator;

import royalstacks.app.model.Account;
import royalstacks.app.model.BusinessAccount;
import royalstacks.app.model.Customer;
import royalstacks.app.model.Employee;

import java.util.List;

public class AccountHolderAdder {

    public static void addAccountHoldersToAccount(List<Account> accounts, List<Customer> customers, Employee headbusiness){
        final int MIN_ACCOUNTHOLDERS = 1;
        final int MAX_ACCOUNTHOLDERS = 4;

        for(Account account : accounts){
            int amountAccountholders = royalstacks.app.model.dataGenerator.Gen.randomInt(MIN_ACCOUNTHOLDERS, MAX_ACCOUNTHOLDERS);
            for (int i = 0; i < amountAccountholders; i++) {
                Customer randomCustomer = customers.get(royalstacks.app.model.dataGenerator.Gen.randomInt(0, customers.size()-1));
                account.addAccountHolder(randomCustomer);
                if(account instanceof  BusinessAccount && !randomCustomer.isBusinessAccountHolder()){
                        randomCustomer.setBusinessAccountHolder(true);
                        randomCustomer.setAccountManager(headbusiness);
                }
            }
        }
    }
}

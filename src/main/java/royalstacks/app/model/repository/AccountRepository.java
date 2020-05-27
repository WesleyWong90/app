package royalstacks.app.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import royalstacks.app.model.Account;
import royalstacks.app.model.BusinessAccount;
import royalstacks.app.model.User;

import java.util.*;

public interface AccountRepository extends CrudRepository<Account,Integer> {

    Optional<Account> findByAccountId(int accountId);

    @Query("SELECT a.accountNumber FROM Account a WHERE a.accountId = (select max(a.accountId) From a)")
    Optional<String> getLastAccountNumber();

    @Query("SELECT p FROM PrivateAccount p")
    Iterable<Account> findAllPrivateAccounts();

    @Query("SELECT b FROM BusinessAccount b")
    Iterable<Account> findAllBusinessAccounts();

}

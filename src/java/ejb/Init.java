package ejb;

import entity.Account;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author grin
 */
@Singleton
@Startup
public class Init {

  @EJB
  private AccountManager accountManager;
  
  @PostConstruct
  public void init() {
    if (accountManager.getAccountNumber() == 0) {
      Account a1 = new Account("John Lennon", 150_000);
      Account a2 = new Account("Paul McCartney", 950_000);
      Account a3 = new Account("Rongo Starr", 20_000);
      Account a4 = new Account("Georges Harrisson", 100_000);
      accountManager.create(a1);
      accountManager.create(a2);
      accountManager.create(a3);
      accountManager.create(a4);
    }
  }
}

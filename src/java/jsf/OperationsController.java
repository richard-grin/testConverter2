package jsf;

import entity.Account;
import entity.BankingOperation;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 */
@Named(value = "operationsController")
@RequestScoped
public class OperationsController {
  private Account account;

  /**
   * Creates a new instance of OperationsController
   */
  public OperationsController() {
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    System.out.println("***** Dans OperationsController.setAccount avec account=" + account);
    this.account = account;
  }
  
  public List<BankingOperation> getAllOperations() {
    System.out.println("account dans OperationController=" + account);
    return account.getOperations();
  }
  
}

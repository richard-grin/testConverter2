/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import ejb.AccountManager;
import entity.Account;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author grin
 */
@Named(value = "accountController")
@ViewScoped
public class AccountController implements Serializable {

  @EJB
  private AccountManager accountManager;
  
  public List<Account> getAllAccounts() {
    return accountManager.findAllAccounts();
  }
  
}

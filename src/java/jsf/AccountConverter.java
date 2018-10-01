package jsf;

import ejb.AccountManager;
import entity.Account;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 * Convertisseur d'Account.
 */
//@FacesConverter(value="accountConverter", managed = true)
@Named
@RequestScoped
public class AccountConverter implements Converter<Account> {
  @EJB
  private AccountManager accountManager;

  @Override
  public Account getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) {
      return null;
    }
    return accountManager.findByid(Long.parseLong(value));
  }

  @Override
  public String getAsString(FacesContext arg0, UIComponent arg1, Account account) {
    if (account == null) {
      return "";
    }
    return account.getId().toString();
  }
  
}

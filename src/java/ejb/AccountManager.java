package ejb;

import entity.Account;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 */
@DataSourceDefinition (
    className="org.apache.derby.jdbc.ClientDataSource",
    name="java:app/jdbc/bank",
    serverName="localhost",
    portNumber=1527,
    user="toto", // nom et
    password="toto", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="bank"
)
@Stateless
public class AccountManager {

  @PersistenceContext
  private EntityManager em;

  public void create(Account account) {
    em.persist(account);
  }
  
  public List<Account> findAllAccounts() {
    TypedQuery query = em.createQuery("select a from Account a", Account.class);
    return query.getResultList();
  }
  
  public Long getAccountNumber() {
    TypedQuery<Long> query = em.createQuery("select count(a) from Account a", Long.class);
    return query.getSingleResult();
  }
  
  public Account findByid(Long id) {
    return em.find(Account.class, id);
  }

}

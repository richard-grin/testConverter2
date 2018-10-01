package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 */
@Entity
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private int balance;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<BankingOperation> operations = new ArrayList<>();

  public Account() {
  }
  
  public Account(String name, int balance) {  
  this.name = name;  
  this.balance = balance;
  operations.add(new BankingOperation("Création du compte", balance));
}  

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public List<BankingOperation> getOperations() {
    return operations;
  }
  
  public void deposit(int amount) {  
  balance += amount;
  operations.add(new BankingOperation("Ajout", amount));
}  
                  
public void withdraw(int amount) {  
  if (amount < balance) {  
    balance -= amount;  
  } else {
    balance = 0;
  }
  operations.add(new BankingOperation("Retrait", -amount));
}

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Account)) {
      return false;
    }
    Account other = (Account) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.CompteBancaire[ id=" + id + " ]";
  }
  
}

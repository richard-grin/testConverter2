/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author grin
 */
@Entity
public class BankingOperation implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String description;
  private LocalDateTime moment;
  private int montant;

  public BankingOperation() {
  }

  public BankingOperation(String description, LocalDateTime moment, int montant) {
    this.description = description;
    this.moment = moment;
    this.montant = montant;
  }

  public BankingOperation(String description, int montant) {
    this(description, LocalDateTime.now(), montant);
  }

  
  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public int getMontant() {
    return montant;
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
    if (!(object instanceof BankingOperation)) {
      return false;
    }
    BankingOperation other = (BankingOperation) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.BankingOperation[ id=" + id + " ]";
  }
  
}

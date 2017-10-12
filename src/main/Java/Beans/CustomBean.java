package Beans;

import Interfaces.HostI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class CustomBean<T>  {
    @PersistenceContext
    EntityManager entityManager;
    public  boolean addCustom(T t){
      try{
          entityManager.persist(t);
          return  true;
      }catch (PersistenceException ex) {
          ex.printStackTrace();
          return  false;
      }
    }
}

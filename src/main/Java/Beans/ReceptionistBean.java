package Beans;

import Entities.Receptionist;
import Interfaces.ReceptionistI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
@Stateless
@Local
public class ReceptionistBean extends  CustomBean<Receptionist> implements ReceptionistI {
    @PersistenceContext
    EntityManager entityManager;

    public boolean add(Receptionist receptionist) {
        return  this.addCustom(receptionist);
    }
    @SuppressWarnings(value = "unchecked")
    public ArrayList<Receptionist> viewReceptionsit() {
        try {
            return (ArrayList<Receptionist>) entityManager.createNamedQuery("findAllReceptionist").getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return  null;
        }
    }


    @SuppressWarnings(value = "unchecked")
    public Receptionist getById(Receptionist receptionist) {
        try{
          List<Receptionist>receptionistList= entityManager.createNamedQuery("findReceptionistById").setParameter("worknum",receptionist.getWorkNumber()).getResultList();
          return  receptionistList.size()>0 ? receptionistList.get(0):null;
        }catch (PersistenceException ex){
            ex.printStackTrace();
            return null;
        }
        }

}

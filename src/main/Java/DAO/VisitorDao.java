package DAO;

import Entities.Activity;
import Entities.Visitor;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class VisitorDao  {
    EntityManager entityManager;
    @EJB
    ActivityI activityI;

    public VisitorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public  boolean add(Visitor visitor){
        try {
            entityManager.persist(visitor);
            return  true;
        }catch (PersistenceException ex){
            ex.printStackTrace();
            return  false;
        }
    }
    @SuppressWarnings(value = "unchecked")
    public  Visitor getById(Visitor visitor){
        try {
            List<Visitor> visitorList = entityManager.createNamedQuery("findVisitorById").setParameter("idnumber", visitor.getIdNumber()).getResultList();
            return visitorList.size() > 0 ? visitorList.get(0) : null;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    public boolean updateVisitor(Visitor visitor){
        try {
            entityManager.merge(visitor);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @SuppressWarnings(value = "unchecked")
    public ArrayList<Visitor> viewAllVisitors() {
        try {
            return (ArrayList<Visitor>) entityManager.createNamedQuery("findAllVisitors").getResultList();
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    public boolean checkInVisitor(Visitor visitor, Activity activity) {
        if (getById(visitor) != null) {
            try {
                entityManager.merge(visitor);
                activityI.add(activity);
                return true;
            } catch (PersistenceException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean checkOutVisitor(Visitor visitor, Activity activity) {
        if (getById(visitor) != null) {
            try {
                entityManager.merge(visitor);

                activityI.add(activity);
                return true;
            } catch (PersistenceException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
}

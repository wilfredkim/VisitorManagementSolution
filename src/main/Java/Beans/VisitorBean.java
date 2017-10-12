package Beans;

import DAO.VisitorDao;
import Entities.Activity;
import Entities.Visitor;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Local
public class VisitorBean  implements VisitorI {

    @PersistenceContext
    EntityManager entityManager;


    public boolean add(Visitor visitor) {
        VisitorDao visitorDao = new VisitorDao(entityManager);
        return visitorDao.add(visitor);

    }

    public boolean checkInVisitor(Visitor visitor, Activity activity) {
        VisitorDao visitorDao = new VisitorDao(entityManager);
        return visitorDao.checkInVisitor(visitor,activity);
    }


    public Visitor getById(Visitor visitor) {
        VisitorDao visitorDao = new VisitorDao(entityManager);
        return visitorDao.getById(visitor);
    }

    public boolean updateVisitor(Visitor visitor) {
        VisitorDao visitorDao = new VisitorDao(entityManager);
        return  visitorDao.updateVisitor(visitor);

    }


    public ArrayList<Visitor> viewAllVisitors() {
        VisitorDao visitorDao = new VisitorDao(entityManager);
        return visitorDao.viewAllVisitors();
    }

    public boolean checkOutVisitor(Visitor visitor, Activity activity) {
       VisitorDao visitorDao = new VisitorDao(entityManager);
       return visitorDao.checkOutVisitor(visitor,activity);
    }

}

package Beans;

import Entities.Activity;
import Interfaces.ActivityI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Stateless
@Local
public class ActivityBean extends CustomBean<Activity> implements ActivityI {
    @PersistenceContext
    EntityManager entityManager;
    public boolean add(Activity activity) {
        return this.addCustom(activity);
    }
    @SuppressWarnings("unchecked")
    public Activity getByVisitorId(Activity activity) {
        try{
          List<Activity>activityList = entityManager.createNamedQuery("findActivityById").setParameter("v",activity.getVisitor()).getResultList();
         return activityList.size()>0? activityList.get(0):null;
        } catch (PersistenceException ex){
            ex.printStackTrace();
            return  null;
        }
    }

}

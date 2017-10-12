package Beans;

import Entities.AuditTrail;
import Interfaces.AuditTrailI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@Local
public class AuditTrailBean  implements AuditTrailI{
    @PersistenceContext
    EntityManager entityManager;
    public boolean recordTrail(AuditTrail auditTrail) {
        try{
            entityManager.persist(auditTrail);
            return  true;
        }catch (PersistenceException ex){
            ex.printStackTrace();
            return  false;
        }

    }
}

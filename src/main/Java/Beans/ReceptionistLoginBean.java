package Beans;

import Entities.AuditTrail;
import Entities.Receptionist;
import Events.AuditTrailEvent;
import Interfaces.LoginI;
import Qualifiers.LoginQ;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

@LoginQ(LoginQ.LoginChoice.Receptionist)
public class ReceptionistLoginBean implements LoginI {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    private Event<AuditTrailEvent> event;
    @SuppressWarnings("unchecked")
    public boolean authenticate(String email, String password) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        try {
     List<Receptionist>receptionistList = entityManager.createNamedQuery("receptionistLoginNQ").setParameter("mail",email).setParameter("pass",password).getResultList();
            auditTrail.setDate(new Date());
            auditTrail.setDetail("Login");
            auditTrail.setUserId(email);
            auditTrail.setUserType("Receptionist");
            auditTrailEvent.setAuditTrail(auditTrail);
            event.fire(auditTrailEvent);
       return  receptionistList.size()>0;
        }catch (PersistenceException ex){
            ex.printStackTrace();
            return false;
        }

    }
}

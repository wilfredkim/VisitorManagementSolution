package Beans;

import Entities.Host;
import Interfaces.HostI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Local
@Stateless
public class HostBean  extends CustomBean<Host> implements  HostI{
    @PersistenceContext
    EntityManager entityManager;


    public boolean add(Host host) {
         return  this.addCustom(host);
    }


}

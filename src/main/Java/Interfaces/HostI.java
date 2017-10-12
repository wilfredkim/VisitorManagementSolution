package Interfaces;

import Entities.Host;

import javax.ejb.Local;

@Local
public interface HostI {

    boolean add(Host host);
}

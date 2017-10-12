package Interfaces;

import Entities.Receptionist;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface ReceptionistI {
    boolean add(Receptionist receptionist);

    ArrayList<Receptionist> viewReceptionsit();

    Receptionist getById(Receptionist receptionist);
}

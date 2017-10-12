package Interfaces;

import Entities.Activity;
import Entities.Visitor;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface VisitorI {
    boolean add(Visitor visitor);

    boolean checkInVisitor(Visitor visitor,Activity activity);

    Visitor getById(Visitor visitor);

    boolean updateVisitor(Visitor visitor);

    ArrayList<Visitor> viewAllVisitors();

    boolean checkOutVisitor(Visitor visitor,Activity activity);
}

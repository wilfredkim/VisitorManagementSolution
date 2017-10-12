package Interfaces;

import Entities.Activity;
import Entities.Visitor;

import javax.ejb.Local;

@Local
public interface ActivityI {
    boolean add(Activity activity);

    Activity getByVisitorId(Activity activity);
}

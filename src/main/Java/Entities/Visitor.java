package Entities;

import Enums.Status;
import Enums.VisitorCategory;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({@NamedQuery(name = "findVisitorById",
        query = "SELECT  v from Visitor v where v.idNumber=:idnumber "),
        @NamedQuery(name = "findAllVisitors", query = "select v from Visitor v")})

public class Visitor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String idNumber;

    @Enumerated(EnumType.STRING)
    VisitorCategory visitorCategory;
    @Enumerated(EnumType.STRING)
    Status status;

    public VisitorCategory getVisitorCategory() {
        return visitorCategory;
    }

    public void setVisitorCategory(VisitorCategory visitorCategory) {
        this.visitorCategory = visitorCategory;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

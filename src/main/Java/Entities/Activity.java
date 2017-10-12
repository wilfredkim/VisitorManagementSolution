package Entities;

import Enums.Status;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "findActivityById",query = "select a from  Activity  a where a.visitor=:v")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    Date date;
    @Column(name = "Detail")
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne
    Visitor visitor;
    @Lob
    private  String purpose;

    private  String personVisted;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPersonVisted() {
        return personVisted;
    }

    public void setPersonVisted(String personVisted) {
        this.personVisted = personVisted;
    }
}

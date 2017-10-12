package Entities;

import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "findAllReceptionist",
        query = "select  r  from Receptionist  r"),
        @NamedQuery(name = "findReceptionistById",
                query = "select  r from  Receptionist  r where r.workNumber=:worknum"),
        @NamedQuery(name = "receptionistLoginNQ",
                query = "select r from Receptionist  r where r.email=:mail and r.password=:pass")


})

public class Receptionist extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String workNumber;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
}

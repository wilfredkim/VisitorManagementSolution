package Entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "hostLoginNQ",query = "select h from Host  h where h.email=:Email and h.password=:Pass")
public class Host extends  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private  String workNumber;

    private  String password;

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

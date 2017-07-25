package de.beinlich.markus.pizzaservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -565390959945252363L;
    @Version
    private Long lastUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<OrderHeader> orderHeaders;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String street;
    private String town;
    private String postcode;

    public Customer() {
    }

    public void store() {
//        DaoCustomer daoCustomer = new DaoCustomer();
//        this.customerId = daoCustomer.store(this);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}

package my.group.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Office entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="OFFICE"
    ,schema="CLASSICCARS"
)

public class Office  implements java.io.Serializable {


    // Fields    

     private String officecode;
     private String city;
     private String phone;
     private String addressline1;
     private String addressline2;
     private String state;
     private String country;
     private String postalcode;
     private String territory;
     private Set<Employee> employees = new HashSet<Employee>(0);


    // Constructors

    /** default constructor */
    public Office() {
    }

	/** minimal constructor */
    public Office(String officecode) {
        this.officecode = officecode;
    }
    
    /** full constructor */
    public Office(String officecode, String city, String phone, String addressline1, String addressline2, String state, String country, String postalcode, String territory, Set<Employee> employees) {
        this.officecode = officecode;
        this.city = city;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
        this.territory = territory;
        this.employees = employees;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="OFFICECODE", unique=true, nullable=false, length=10)

    public String getOfficecode() {
        return this.officecode;
    }
    
    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }
    
    @Column(name="CITY", length=50)

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="PHONE", length=50)

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="ADDRESSLINE1", length=50)

    public String getAddressline1() {
        return this.addressline1;
    }
    
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }
    
    @Column(name="ADDRESSLINE2", length=50)

    public String getAddressline2() {
        return this.addressline2;
    }
    
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }
    
    @Column(name="STATE", length=50)

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Column(name="COUNTRY", length=50)

    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    @Column(name="POSTALCODE", length=15)

    public String getPostalcode() {
        return this.postalcode;
    }
    
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    
    @Column(name="TERRITORY", length=10)

    public String getTerritory() {
        return this.territory;
    }
    
    public void setTerritory(String territory) {
        this.territory = territory;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="office")

    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
   








}
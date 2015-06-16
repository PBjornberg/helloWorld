package my.group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="EMPLOYEE",schema="CLASSICCARS")
public class Employee  implements java.io.Serializable {

    // Fields    

     private Integer employeenumber;
     private Office office;
     private String lastname;
     private String firstname;
     private String extension;
     private String email;
     private Integer reportsto;
     private String jobtitle;


    // Constructors

    /** default constructor */
    public Employee() {
    }

	/** minimal constructor */
    public Employee(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }
    
    /** full constructor */
    public Employee(Integer employeenumber, Office office, String lastname, String firstname, String extension, String email, Integer reportsto, String jobtitle) {
        this.employeenumber = employeenumber;
        this.office = office;
        this.lastname = lastname;
        this.firstname = firstname;
        this.extension = extension;
        this.email = email;
        this.reportsto = reportsto;
        this.jobtitle = jobtitle;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="EMPLOYEENUMBER", unique=true, nullable=false)

    public Integer getEmployeenumber() {
        return this.employeenumber;
    }
    
    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="OFFICECODE")

    public Office getOffice() {
        return this.office;
    }
    
    public void setOffice(Office office) {
        this.office = office;
    }
    
    @Column(name="LASTNAME", length=50)

    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Column(name="FIRSTNAME", length=50)

    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Column(name="EXTENSION", length=10)

    public String getExtension() {
        return this.extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    @Column(name="EMAIL", length=100)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="REPORTSTO")

    public Integer getReportsto() {
        return this.reportsto;
    }
    
    public void setReportsto(Integer reportsto) {
        this.reportsto = reportsto;
    }
    
    @Column(name="JOBTITLE", length=50)

    public String getJobtitle() {
        return this.jobtitle;
    }
    
    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }
   








}
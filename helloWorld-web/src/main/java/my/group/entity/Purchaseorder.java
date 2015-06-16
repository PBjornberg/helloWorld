package my.group.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Purchaseorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PURCHASEORDER"
    ,schema="CLASSICCARS"
)

public class Purchaseorder  implements java.io.Serializable {


    // Fields    

     private Integer purchaseordernumber;
     private Date orderdate;
     private Date requireddate;
     private Date shippeddate;
     private String status;
     private String comments;
     private Integer customernumber;
     private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);


    // Constructors

    /** default constructor */
    public Purchaseorder() {
    }

	/** minimal constructor */
    public Purchaseorder(Integer purchaseordernumber) {
        this.purchaseordernumber = purchaseordernumber;
    }
    
    /** full constructor */
    public Purchaseorder(Integer purchaseordernumber, Date orderdate, Date requireddate, Date shippeddate, String status, String comments, Integer customernumber, Set<Orderdetail> orderdetails) {
        this.purchaseordernumber = purchaseordernumber;
        this.orderdate = orderdate;
        this.requireddate = requireddate;
        this.shippeddate = shippeddate;
        this.status = status;
        this.comments = comments;
        this.customernumber = customernumber;
        this.orderdetails = orderdetails;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="PURCHASEORDERNUMBER", unique=true, nullable=false)

    public Integer getPurchaseordernumber() {
        return this.purchaseordernumber;
    }
    
    public void setPurchaseordernumber(Integer purchaseordernumber) {
        this.purchaseordernumber = purchaseordernumber;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="ORDERDATE", length=10)

    public Date getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="REQUIREDDATE", length=10)

    public Date getRequireddate() {
        return this.requireddate;
    }
    
    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="SHIPPEDDATE", length=10)

    public Date getShippeddate() {
        return this.shippeddate;
    }
    
    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }
    
    @Column(name="STATUS", length=15)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="COMMENTS", length=32700)

    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Column(name="CUSTOMERNUMBER")

    public Integer getCustomernumber() {
        return this.customernumber;
    }
    
    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="purchaseorder")

    public Set<Orderdetail> getOrderdetails() {
        return this.orderdetails;
    }
    
    public void setOrderdetails(Set<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }
   








}
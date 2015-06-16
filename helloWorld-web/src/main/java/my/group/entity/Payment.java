package my.group.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Payment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PAYMENT"
    ,schema="CLASSICCARS"
)

public class Payment  implements java.io.Serializable {


    // Fields    

     private PaymentId id;
     private Customer customer;
     private Date paymentdate;
     private Double amount;


    // Constructors

    /** default constructor */
    public Payment() {
    }

	/** minimal constructor */
    public Payment(PaymentId id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
    
    /** full constructor */
    public Payment(PaymentId id, Customer customer, Date paymentdate, Double amount) {
        this.id = id;
        this.customer = customer;
        this.paymentdate = paymentdate;
        this.amount = amount;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="customernumber", column=@Column(name="CUSTOMERNUMBER", nullable=false) ), 
        @AttributeOverride(name="checknumber", column=@Column(name="CHECKNUMBER", nullable=false, length=50) ) } )

    public PaymentId getId() {
        return this.id;
    }
    
    public void setId(PaymentId id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="CUSTOMERNUMBER", nullable=false, insertable=false, updatable=false)

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="PAYMENTDATE", length=10)

    public Date getPaymentdate() {
        return this.paymentdate;
    }
    
    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }
    
    @Column(name="AMOUNT", precision=52, scale=0)

    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
   








}
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
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PRODUCT"
    ,schema="CLASSICCARS"
)

public class Product  implements java.io.Serializable {


    // Fields    

     private String productcode;
     private String productname;
     private String productline;
     private String productscale;
     private String productvendor;
     private String productdescription;
     private Integer quantityinstock;
     private Double buyprice;
     private Double msrp;
     private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);


    // Constructors

    /** default constructor */
    public Product() {
    }

	/** minimal constructor */
    public Product(String productcode) {
        this.productcode = productcode;
    }
    
    /** full constructor */
    public Product(String productcode, String productname, String productline, String productscale, String productvendor, String productdescription, Integer quantityinstock, Double buyprice, Double msrp, Set<Orderdetail> orderdetails) {
        this.productcode = productcode;
        this.productname = productname;
        this.productline = productline;
        this.productscale = productscale;
        this.productvendor = productvendor;
        this.productdescription = productdescription;
        this.quantityinstock = quantityinstock;
        this.buyprice = buyprice;
        this.msrp = msrp;
        this.orderdetails = orderdetails;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="PRODUCTCODE", unique=true, nullable=false, length=15)

    public String getProductcode() {
        return this.productcode;
    }
    
    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }
    
    @Column(name="PRODUCTNAME", length=70)

    public String getProductname() {
        return this.productname;
    }
    
    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    @Column(name="PRODUCTLINE", length=50)

    public String getProductline() {
        return this.productline;
    }
    
    public void setProductline(String productline) {
        this.productline = productline;
    }
    
    @Column(name="PRODUCTSCALE", length=10)

    public String getProductscale() {
        return this.productscale;
    }
    
    public void setProductscale(String productscale) {
        this.productscale = productscale;
    }
    
    @Column(name="PRODUCTVENDOR", length=50)

    public String getProductvendor() {
        return this.productvendor;
    }
    
    public void setProductvendor(String productvendor) {
        this.productvendor = productvendor;
    }
    
    @Column(name="PRODUCTDESCRIPTION", length=32700)

    public String getProductdescription() {
        return this.productdescription;
    }
    
    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }
    
    @Column(name="QUANTITYINSTOCK")

    public Integer getQuantityinstock() {
        return this.quantityinstock;
    }
    
    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }
    
    @Column(name="BUYPRICE", precision=52, scale=0)

    public Double getBuyprice() {
        return this.buyprice;
    }
    
    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }
    
    @Column(name="MSRP", precision=52, scale=0)

    public Double getMsrp() {
        return this.msrp;
    }
    
    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")

    public Set<Orderdetail> getOrderdetails() {
        return this.orderdetails;
    }
    
    public void setOrderdetails(Set<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }
   








}
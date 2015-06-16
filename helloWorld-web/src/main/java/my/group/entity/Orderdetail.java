package my.group.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ORDERDETAIL"
    ,schema="CLASSICCARS"
)

public class Orderdetail  implements java.io.Serializable {


    // Fields    

     private OrderdetailId id;
     private Purchaseorder purchaseorder;
     private Product product;
     private Integer quantityordered;
     private Double priceeach;
     private Short orderlinenumber;


    // Constructors

    /** default constructor */
    public Orderdetail() {
    }

	/** minimal constructor */
    public Orderdetail(OrderdetailId id, Purchaseorder purchaseorder, Product product) {
        this.id = id;
        this.purchaseorder = purchaseorder;
        this.product = product;
    }
    
    /** full constructor */
    public Orderdetail(OrderdetailId id, Purchaseorder purchaseorder, Product product, Integer quantityordered, Double priceeach, Short orderlinenumber) {
        this.id = id;
        this.purchaseorder = purchaseorder;
        this.product = product;
        this.quantityordered = quantityordered;
        this.priceeach = priceeach;
        this.orderlinenumber = orderlinenumber;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="purchaseordernumber", column=@Column(name="PURCHASEORDERNUMBER", nullable=false) ), 
        @AttributeOverride(name="productcode", column=@Column(name="PRODUCTCODE", nullable=false, length=15) ) } )

    public OrderdetailId getId() {
        return this.id;
    }
    
    public void setId(OrderdetailId id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PURCHASEORDERNUMBER", nullable=false, insertable=false, updatable=false)

    public Purchaseorder getPurchaseorder() {
        return this.purchaseorder;
    }
    
    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="PRODUCTCODE", nullable=false, insertable=false, updatable=false)

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Column(name="QUANTITYORDERED")

    public Integer getQuantityordered() {
        return this.quantityordered;
    }
    
    public void setQuantityordered(Integer quantityordered) {
        this.quantityordered = quantityordered;
    }
    
    @Column(name="PRICEEACH", precision=52, scale=0)

    public Double getPriceeach() {
        return this.priceeach;
    }
    
    public void setPriceeach(Double priceeach) {
        this.priceeach = priceeach;
    }
    
    @Column(name="ORDERLINENUMBER")

    public Short getOrderlinenumber() {
        return this.orderlinenumber;
    }
    
    public void setOrderlinenumber(Short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }
   








}
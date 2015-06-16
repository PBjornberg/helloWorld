package my.group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * Productline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="PRODUCTLINE"
    ,schema="CLASSICCARS"
)

public class Productline  implements java.io.Serializable {


    // Fields    

     private String productline;
     private String textdescription;
     private String htmldescription;
     private byte[] image;


    // Constructors

    /** default constructor */
    public Productline() {
    }

	/** minimal constructor */
    public Productline(String productline) {
        this.productline = productline;
    }
    
    /** full constructor */
    public Productline(String productline, String textdescription, String htmldescription, byte[] image) {
        this.productline = productline;
        this.textdescription = textdescription;
        this.htmldescription = htmldescription;
        this.image = image;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="PRODUCTLINE", unique=true, nullable=false, length=50)

    public String getProductline() {
        return this.productline;
    }
    
    public void setProductline(String productline) {
        this.productline = productline;
    }
    
    @Column(name="TEXTDESCRIPTION", length=4000)

    public String getTextdescription() {
        return this.textdescription;
    }
    
    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }
    @Lob
    @Column(name="HTMLDESCRIPTION")

    public String getHtmldescription() {
        return this.htmldescription;
    }
    
    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }
    @Lob
    @Column(name="IMAGE")

    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
   








}
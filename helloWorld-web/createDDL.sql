CREATE TABLE CLASSICCARS.PRODUCTLINE (PRODUCTLINE VARCHAR(50) NOT NULL, HTMLDESCRIPTION CLOB(2147483647), IMAGE BLOB(2147483647), TEXTDESCRIPTION VARCHAR(4000), PRIMARY KEY (PRODUCTLINE));
CREATE TABLE CLASSICCARS.OFFICE (OFFICECODE VARCHAR(10) NOT NULL, ADDRESSLINE1 VARCHAR(50), ADDRESSLINE2 VARCHAR(50), CITY VARCHAR(50), COUNTRY VARCHAR(50), PHONE VARCHAR(50), POSTALCODE VARCHAR(15), STATE VARCHAR(50), TERRITORY VARCHAR(10), PRIMARY KEY (OFFICECODE));
CREATE TABLE CLASSICCARS.ORDERDETAIL (ORDERLINENUMBER SMALLINT, PRICEEACH FLOAT, QUANTITYORDERED INTEGER, PRODUCTCODE VARCHAR(15) NOT NULL, PURCHASEORDERNUMBER INTEGER NOT NULL, PRIMARY KEY (PRODUCTCODE, PURCHASEORDERNUMBER));
CREATE TABLE CLASSICCARS.EMPLOYEE (EMPLOYEENUMBER INTEGER NOT NULL, EMAIL VARCHAR(100), EXTENSION VARCHAR(10), FIRSTNAME VARCHAR(50), JOBTITLE VARCHAR(50), LASTNAME VARCHAR(50), REPORTSTO INTEGER, OFFICECODE VARCHAR(10), PRIMARY KEY (EMPLOYEENUMBER));
CREATE TABLE CLASSICCARS.PAYMENT (AMOUNT FLOAT, PAYMENTDATE DATE, CHECKNUMBER VARCHAR(50) NOT NULL, CUSTOMERNUMBER INTEGER NOT NULL, PRIMARY KEY (CHECKNUMBER, CUSTOMERNUMBER));
CREATE TABLE CLASSICCARS.PURCHASEORDER (PURCHASEORDERNUMBER INTEGER NOT NULL, COMMENTS VARCHAR(255), CUSTOMERNUMBER INTEGER, ORDERDATE DATE, REQUIREDDATE DATE, SHIPPEDDATE DATE, STATUS VARCHAR(15), PRIMARY KEY (PURCHASEORDERNUMBER));
CREATE TABLE CLASSICCARS.PRODUCT (PRODUCTCODE VARCHAR(15) NOT NULL, BUYPRICE FLOAT, MSRP FLOAT, PRODUCTDESCRIPTION VARCHAR(255), PRODUCTLINE VARCHAR(50), PRODUCTNAME VARCHAR(70), PRODUCTSCALE VARCHAR(10), PRODUCTVENDOR VARCHAR(50), QUANTITYINSTOCK INTEGER, PRIMARY KEY (PRODUCTCODE));
CREATE TABLE CLASSICCARS.CUSTOMER (CUSTOMERNUMBER INTEGER NOT NULL, ADDRESSLINE1 VARCHAR(50), ADDRESSLINE2 VARCHAR(50), CITY VARCHAR(50), CONTACTFIRSTNAME VARCHAR(50), CONTACTLASTNAME VARCHAR(50), COUNTRY VARCHAR(50), CREDITLIMIT FLOAT, CUSTOMERNAME VARCHAR(50), PHONE VARCHAR(50), POSTALCODE VARCHAR(15), SALESREPEMPLOYEENUMBER INTEGER, STATE VARCHAR(50), PRIMARY KEY (CUSTOMERNUMBER));
ALTER TABLE CLASSICCARS.ORDERDETAIL ADD CONSTRAINT RDRDETAILPRDCTCODE FOREIGN KEY (PRODUCTCODE) REFERENCES CLASSICCARS.PRODUCT (PRODUCTCODE);
ALTER TABLE CLASSICCARS.ORDERDETAIL ADD CONSTRAINT RDRDTLPRCHSRDRNMBR FOREIGN KEY (PURCHASEORDERNUMBER) REFERENCES CLASSICCARS.PURCHASEORDER (PURCHASEORDERNUMBER);
ALTER TABLE CLASSICCARS.EMPLOYEE ADD CONSTRAINT EMPLOYEEOFFICECODE FOREIGN KEY (OFFICECODE) REFERENCES CLASSICCARS.OFFICE (OFFICECODE);
ALTER TABLE CLASSICCARS.PAYMENT ADD CONSTRAINT PYMNTCSTOMERNUMBER FOREIGN KEY (CUSTOMERNUMBER) REFERENCES CLASSICCARS.CUSTOMER (CUSTOMERNUMBER);

package my.group.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Customer;

/**
 	* A data access object (DAO) providing persistence and search support for Customer entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Customer
  * @author MyEclipse Persistence Tools 
 */
public class CustomerDAO  {
	//property constants
	public static final String CUSTOMERNAME = "customername";
	public static final String CONTACTLASTNAME = "contactlastname";
	public static final String CONTACTFIRSTNAME = "contactfirstname";
	public static final String PHONE = "phone";
	public static final String ADDRESSLINE1 = "addressline1";
	public static final String ADDRESSLINE2 = "addressline2";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String POSTALCODE = "postalcode";
	public static final String COUNTRY = "country";
	public static final String SALESREPEMPLOYEENUMBER = "salesrepemployeenumber";
	public static final String CREDITLIMIT = "creditlimit";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Customer entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   CustomerDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Customer entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Customer entity) {
    				EntityManagerHelper.log("saving Customer instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Customer entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   CustomerDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Customer entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Customer entity) {
    				EntityManagerHelper.log("deleting Customer instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Customer.class, entity.getCustomernumber());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Customer entity and return it or a copy of it to the sender. 
	 A copy of the Customer entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = CustomerDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Customer entity to update
	 @return Customer the persisted Customer entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Customer update(Customer entity) {
    				EntityManagerHelper.log("updating Customer instance", Level.INFO, null);
	        try {
            Customer result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Customer findById( Integer id) {
    				EntityManagerHelper.log("finding Customer instance with id: " + id, Level.INFO, null);
	        try {
            Customer instance = getEntityManager().find(Customer.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Customer entities with a specific property value.  
	 
	  @param propertyName the name of the Customer property to query
	  @param value the property value to match
	  	  @return List<Customer> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Customer> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Customer instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Customer model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Customer> findByCustomername(Object customername
	) {
		return findByProperty(CUSTOMERNAME, customername
		);
	}
	
	public List<Customer> findByContactlastname(Object contactlastname
	) {
		return findByProperty(CONTACTLASTNAME, contactlastname
		);
	}
	
	public List<Customer> findByContactfirstname(Object contactfirstname
	) {
		return findByProperty(CONTACTFIRSTNAME, contactfirstname
		);
	}
	
	public List<Customer> findByPhone(Object phone
	) {
		return findByProperty(PHONE, phone
		);
	}
	
	public List<Customer> findByAddressline1(Object addressline1
	) {
		return findByProperty(ADDRESSLINE1, addressline1
		);
	}
	
	public List<Customer> findByAddressline2(Object addressline2
	) {
		return findByProperty(ADDRESSLINE2, addressline2
		);
	}
	
	public List<Customer> findByCity(Object city
	) {
		return findByProperty(CITY, city
		);
	}
	
	public List<Customer> findByState(Object state
	) {
		return findByProperty(STATE, state
		);
	}
	
	public List<Customer> findByPostalcode(Object postalcode
	) {
		return findByProperty(POSTALCODE, postalcode
		);
	}
	
	public List<Customer> findByCountry(Object country
	) {
		return findByProperty(COUNTRY, country
		);
	}
	
	public List<Customer> findBySalesrepemployeenumber(Object salesrepemployeenumber
	) {
		return findByProperty(SALESREPEMPLOYEENUMBER, salesrepemployeenumber
		);
	}
	
	public List<Customer> findByCreditlimit(Object creditlimit
	) {
		return findByProperty(CREDITLIMIT, creditlimit
		);
	}
	
	
	/**
	 * Find all Customer entities.
	  	  @return List<Customer> all Customer entities
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAll(
		) {
					EntityManagerHelper.log("finding all Customer instances", Level.INFO, null);
			try {
			final String queryString = "select model from Customer model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
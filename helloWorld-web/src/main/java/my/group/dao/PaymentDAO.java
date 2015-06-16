package my.group.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Payment;
import my.group.entity.PaymentId;

/**
 	* A data access object (DAO) providing persistence and search support for Payment entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Payment
  * @author MyEclipse Persistence Tools 
 */
public class PaymentDAO  {
	//property constants
	public static final String AMOUNT = "amount";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Payment entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   PaymentDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Payment entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Payment entity) {
    				EntityManagerHelper.log("saving Payment instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Payment entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   PaymentDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Payment entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Payment entity) {
    				EntityManagerHelper.log("deleting Payment instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Payment.class, entity.getId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Payment entity and return it or a copy of it to the sender. 
	 A copy of the Payment entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = PaymentDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Payment entity to update
	 @return Payment the persisted Payment entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Payment update(Payment entity) {
    				EntityManagerHelper.log("updating Payment instance", Level.INFO, null);
	        try {
            Payment result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Payment findById( PaymentId id) {
    				EntityManagerHelper.log("finding Payment instance with id: " + id, Level.INFO, null);
	        try {
            Payment instance = getEntityManager().find(Payment.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Payment entities with a specific property value.  
	 
	  @param propertyName the name of the Payment property to query
	  @param value the property value to match
	  	  @return List<Payment> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Payment> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Payment instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Payment model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Payment> findByAmount(Object amount
	) {
		return findByProperty(AMOUNT, amount
		);
	}
	
	
	/**
	 * Find all Payment entities.
	  	  @return List<Payment> all Payment entities
	 */
	@SuppressWarnings("unchecked")
	public List<Payment> findAll(
		) {
					EntityManagerHelper.log("finding all Payment instances", Level.INFO, null);
			try {
			final String queryString = "select model from Payment model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
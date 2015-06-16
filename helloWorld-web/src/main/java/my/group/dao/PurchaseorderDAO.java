package my.group.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Purchaseorder;

/**
 	* A data access object (DAO) providing persistence and search support for Purchaseorder entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Purchaseorder
  * @author MyEclipse Persistence Tools 
 */
public class PurchaseorderDAO  {
	//property constants
	public static final String STATUS = "status";
	public static final String COMMENTS = "comments";
	public static final String CUSTOMERNUMBER = "customernumber";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Purchaseorder entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   PurchaseorderDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Purchaseorder entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Purchaseorder entity) {
    				EntityManagerHelper.log("saving Purchaseorder instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Purchaseorder entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   PurchaseorderDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Purchaseorder entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Purchaseorder entity) {
    				EntityManagerHelper.log("deleting Purchaseorder instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Purchaseorder.class, entity.getPurchaseordernumber());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Purchaseorder entity and return it or a copy of it to the sender. 
	 A copy of the Purchaseorder entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = PurchaseorderDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Purchaseorder entity to update
	 @return Purchaseorder the persisted Purchaseorder entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Purchaseorder update(Purchaseorder entity) {
    				EntityManagerHelper.log("updating Purchaseorder instance", Level.INFO, null);
	        try {
            Purchaseorder result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Purchaseorder findById( Integer id) {
    				EntityManagerHelper.log("finding Purchaseorder instance with id: " + id, Level.INFO, null);
	        try {
            Purchaseorder instance = getEntityManager().find(Purchaseorder.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Purchaseorder entities with a specific property value.  
	 
	  @param propertyName the name of the Purchaseorder property to query
	  @param value the property value to match
	  	  @return List<Purchaseorder> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Purchaseorder> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Purchaseorder instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Purchaseorder model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Purchaseorder> findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List<Purchaseorder> findByComments(Object comments
	) {
		return findByProperty(COMMENTS, comments
		);
	}
	
	public List<Purchaseorder> findByCustomernumber(Object customernumber
	) {
		return findByProperty(CUSTOMERNUMBER, customernumber
		);
	}
	
	
	/**
	 * Find all Purchaseorder entities.
	  	  @return List<Purchaseorder> all Purchaseorder entities
	 */
	@SuppressWarnings("unchecked")
	public List<Purchaseorder> findAll(
		) {
					EntityManagerHelper.log("finding all Purchaseorder instances", Level.INFO, null);
			try {
			final String queryString = "select model from Purchaseorder model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
package my.group.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Orderdetail;
import my.group.entity.OrderdetailId;

/**
 	* A data access object (DAO) providing persistence and search support for Orderdetail entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Orderdetail
  * @author MyEclipse Persistence Tools 
 */
public class OrderdetailDAO  {
	//property constants
	public static final String QUANTITYORDERED = "quantityordered";
	public static final String PRICEEACH = "priceeach";
	public static final String ORDERLINENUMBER = "orderlinenumber";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Orderdetail entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   OrderdetailDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Orderdetail entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Orderdetail entity) {
    				EntityManagerHelper.log("saving Orderdetail instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Orderdetail entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   OrderdetailDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Orderdetail entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Orderdetail entity) {
    				EntityManagerHelper.log("deleting Orderdetail instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Orderdetail.class, entity.getId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Orderdetail entity and return it or a copy of it to the sender. 
	 A copy of the Orderdetail entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = OrderdetailDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Orderdetail entity to update
	 @return Orderdetail the persisted Orderdetail entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Orderdetail update(Orderdetail entity) {
    				EntityManagerHelper.log("updating Orderdetail instance", Level.INFO, null);
	        try {
            Orderdetail result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Orderdetail findById( OrderdetailId id) {
    				EntityManagerHelper.log("finding Orderdetail instance with id: " + id, Level.INFO, null);
	        try {
            Orderdetail instance = getEntityManager().find(Orderdetail.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Orderdetail entities with a specific property value.  
	 
	  @param propertyName the name of the Orderdetail property to query
	  @param value the property value to match
	  	  @return List<Orderdetail> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Orderdetail> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Orderdetail instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Orderdetail model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Orderdetail> findByQuantityordered(Object quantityordered
	) {
		return findByProperty(QUANTITYORDERED, quantityordered
		);
	}
	
	public List<Orderdetail> findByPriceeach(Object priceeach
	) {
		return findByProperty(PRICEEACH, priceeach
		);
	}
	
	public List<Orderdetail> findByOrderlinenumber(Object orderlinenumber
	) {
		return findByProperty(ORDERLINENUMBER, orderlinenumber
		);
	}
	
	
	/**
	 * Find all Orderdetail entities.
	  	  @return List<Orderdetail> all Orderdetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<Orderdetail> findAll(
		) {
					EntityManagerHelper.log("finding all Orderdetail instances", Level.INFO, null);
			try {
			final String queryString = "select model from Orderdetail model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
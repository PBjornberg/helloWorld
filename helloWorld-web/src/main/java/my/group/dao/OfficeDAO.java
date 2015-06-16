package my.group.dao;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Office;

/**
 	* A data access object (DAO) providing persistence and search support for Office entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Office
  * @author MyEclipse Persistence Tools 
 */
public class OfficeDAO  {
	//property constants
	public static final String CITY = "city";
	public static final String PHONE = "phone";
	public static final String ADDRESSLINE1 = "addressline1";
	public static final String ADDRESSLINE2 = "addressline2";
	public static final String STATE = "state";
	public static final String COUNTRY = "country";
	public static final String POSTALCODE = "postalcode";
	public static final String TERRITORY = "territory";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Office entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   OfficeDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Office entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Office entity) {
    				EntityManagerHelper.log("saving Office instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Office entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   OfficeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Office entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Office entity) {
    				EntityManagerHelper.log("deleting Office instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Office.class, entity.getOfficecode());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Office entity and return it or a copy of it to the sender. 
	 A copy of the Office entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = OfficeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Office entity to update
	 @return Office the persisted Office entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Office update(Office entity) {
    				EntityManagerHelper.log("updating Office instance", Level.INFO, null);
	        try {
            Office result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Office findById( String id) {
    				EntityManagerHelper.log("finding Office instance with id: " + id, Level.INFO, null);
	        try {
            Office instance = getEntityManager().find(Office.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Office entities with a specific property value.  
	 
	  @param propertyName the name of the Office property to query
	  @param value the property value to match
	  	  @return List<Office> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Office> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Office instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Office model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Office> findByCity(Object city
	) {
		return findByProperty(CITY, city
		);
	}
	
	public List<Office> findByPhone(Object phone
	) {
		return findByProperty(PHONE, phone
		);
	}
	
	public List<Office> findByAddressline1(Object addressline1
	) {
		return findByProperty(ADDRESSLINE1, addressline1
		);
	}
	
	public List<Office> findByAddressline2(Object addressline2
	) {
		return findByProperty(ADDRESSLINE2, addressline2
		);
	}
	
	public List<Office> findByState(Object state
	) {
		return findByProperty(STATE, state
		);
	}
	
	public List<Office> findByCountry(Object country
	) {
		return findByProperty(COUNTRY, country
		);
	}
	
	public List<Office> findByPostalcode(Object postalcode
	) {
		return findByProperty(POSTALCODE, postalcode
		);
	}
	
	public List<Office> findByTerritory(Object territory
	) {
		return findByProperty(TERRITORY, territory
		);
	}
	
	
	/**
	 * Find all Office entities.
	  	  @return List<Office> all Office entities
	 */
	@SuppressWarnings("unchecked")
	public List<Office> findAll(
		) {
					EntityManagerHelper.log("finding all Office instances", Level.INFO, null);
			try {
			final String queryString = "select model from Office model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
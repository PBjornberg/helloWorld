package my.group.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Employee;

/**
 	* A data access object (DAO) providing persistence and search support for Employee entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Employee
  * @author MyEclipse Persistence Tools 
 */
public class EmployeeDAO  {
	//property constants
	public static final String LASTNAME = "lastname";
	public static final String FIRSTNAME = "firstname";
	public static final String EXTENSION = "extension";
	public static final String EMAIL = "email";
	public static final String REPORTSTO = "reportsto";
	public static final String JOBTITLE = "jobtitle";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Employee entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   EmployeeDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Employee entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Employee entity) {
    				EntityManagerHelper.log("saving Employee instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Employee entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   EmployeeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Employee entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Employee entity) {
    				EntityManagerHelper.log("deleting Employee instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Employee.class, entity.getEmployeenumber());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Employee entity and return it or a copy of it to the sender. 
	 A copy of the Employee entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = EmployeeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Employee entity to update
	 @return Employee the persisted Employee entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Employee update(Employee entity) {
    				EntityManagerHelper.log("updating Employee instance", Level.INFO, null);
	        try {
            Employee result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Employee findById( Integer id) {
    				EntityManagerHelper.log("finding Employee instance with id: " + id, Level.INFO, null);
	        try {
            Employee instance = getEntityManager().find(Employee.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Employee entities with a specific property value.  
	 
	  @param propertyName the name of the Employee property to query
	  @param value the property value to match
	  	  @return List<Employee> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Employee> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Employee instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Employee model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Employee> findByLastname(Object lastname
	) {
		return findByProperty(LASTNAME, lastname
		);
	}
	
	public List<Employee> findByFirstname(Object firstname
	) {
		return findByProperty(FIRSTNAME, firstname
		);
	}
	
	public List<Employee> findByExtension(Object extension
	) {
		return findByProperty(EXTENSION, extension
		);
	}
	
	public List<Employee> findByEmail(Object email
	) {
		return findByProperty(EMAIL, email
		);
	}
	
	public List<Employee> findByReportsto(Object reportsto
	) {
		return findByProperty(REPORTSTO, reportsto
		);
	}
	
	public List<Employee> findByJobtitle(Object jobtitle
	) {
		return findByProperty(JOBTITLE, jobtitle
		);
	}
	
	
	/**
	 * Find all Employee entities.
	  	  @return List<Employee> all Employee entities
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findAll(
		) {
					EntityManagerHelper.log("finding all Employee instances", Level.INFO, null);
			try {
			final String queryString = "select model from Employee model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
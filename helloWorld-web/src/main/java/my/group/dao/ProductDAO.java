package my.group.dao;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import my.group.entity.Product;

/**
 	* A data access object (DAO) providing persistence and search support for Product entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see my.group.entity.Product
  * @author MyEclipse Persistence Tools 
 */
public class ProductDAO  {
	//property constants
	public static final String PRODUCTNAME = "productname";
	public static final String PRODUCTLINE = "productline";
	public static final String PRODUCTSCALE = "productscale";
	public static final String PRODUCTVENDOR = "productvendor";
	public static final String PRODUCTDESCRIPTION = "productdescription";
	public static final String QUANTITYINSTOCK = "quantityinstock";
	public static final String BUYPRICE = "buyprice";
	public static final String MSRP = "msrp";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved Product entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   ProductDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Product entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Product entity) {
    				EntityManagerHelper.log("saving Product instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent Product entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   ProductDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Product entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Product entity) {
    				EntityManagerHelper.log("deleting Product instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(Product.class, entity.getProductcode());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved Product entity and return it or a copy of it to the sender. 
	 A copy of the Product entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = ProductDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Product entity to update
	 @return Product the persisted Product entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public Product update(Product entity) {
    				EntityManagerHelper.log("updating Product instance", Level.INFO, null);
	        try {
            Product result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public Product findById( String id) {
    				EntityManagerHelper.log("finding Product instance with id: " + id, Level.INFO, null);
	        try {
            Product instance = getEntityManager().find(Product.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all Product entities with a specific property value.  
	 
	  @param propertyName the name of the Product property to query
	  @param value the property value to match
	  	  @return List<Product> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<Product> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding Product instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from Product model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<Product> findByProductname(Object productname
	) {
		return findByProperty(PRODUCTNAME, productname
		);
	}
	
	public List<Product> findByProductline(Object productline
	) {
		return findByProperty(PRODUCTLINE, productline
		);
	}
	
	public List<Product> findByProductscale(Object productscale
	) {
		return findByProperty(PRODUCTSCALE, productscale
		);
	}
	
	public List<Product> findByProductvendor(Object productvendor
	) {
		return findByProperty(PRODUCTVENDOR, productvendor
		);
	}
	
	public List<Product> findByProductdescription(Object productdescription
	) {
		return findByProperty(PRODUCTDESCRIPTION, productdescription
		);
	}
	
	public List<Product> findByQuantityinstock(Object quantityinstock
	) {
		return findByProperty(QUANTITYINSTOCK, quantityinstock
		);
	}
	
	public List<Product> findByBuyprice(Object buyprice
	) {
		return findByProperty(BUYPRICE, buyprice
		);
	}
	
	public List<Product> findByMsrp(Object msrp
	) {
		return findByProperty(MSRP, msrp
		);
	}
	
	
	/**
	 * Find all Product entities.
	  	  @return List<Product> all Product entities
	 */
	@SuppressWarnings("unchecked")
	public List<Product> findAll(
		) {
					EntityManagerHelper.log("finding all Product instances", Level.INFO, null);
			try {
			final String queryString = "select model from Product model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}
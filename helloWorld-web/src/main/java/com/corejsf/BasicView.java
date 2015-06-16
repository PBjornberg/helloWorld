package com.corejsf;
 
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import my.group.dao.CustomerDAO;
import my.group.entity.Customer;
 
@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

	/*
    @ManagedProperty("#{customerService}")
    private CustomerService service;
 	*/
 	
    @PostConstruct
    public void init() {
    	System.out.println(">>> BasicView.init");
    	customerDAO = new CustomerDAO();
    }
     
    public List<Customer> getCustomers() {
		
		List<Customer> findAll = customerDAO.findAll();
		return findAll;
    }
 
}
 
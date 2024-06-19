package com.ilp04.service;
 
import java.sql.Connection;
import java.util.ArrayList;
 
import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;
 
public class CustomerServiceImpl implements CustomerService {
 
	@Override
	public ArrayList<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerList=customerDAO.getAllCustomers(connection);
		return customerList;
	}
 
	@Override
	public int insertIntoCustomer(Customer customer) {
		CustomerDAO customerDAO = new CustomerDAO();
		Connection connection = customerDAO.getConnection();
		int rowsInserted = customerDAO.insertIntoCustomer(customer, connection);
//		System.out.println(customer.getCustomerFirstname());
		customerDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Customer inserted successfully!");
		} else {
			System.out.println("Failed to insert customer.");
		}
		return rowsInserted;
 
	}
 
	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		Connection connection = customerDAO.getConnection();
		int rowsInserted = customerDAO.updateIntoCustomer(customer, connection);
		customerDAO.closeConnection(connection);
		if (rowsInserted > 0) {
			System.out.println("Customer updated successfully!");
		} else {
			System.out.println("Failed to update customer.");
		}
		return rowsInserted;
	}
 
}
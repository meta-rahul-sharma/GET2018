package jdbc;

import java.util.Date;

/**
 * Pojo to store order details
 * @author RAHUL SHARMA
 * CREATION DATE: 21/08/2018
 */
public class Order {
	private int id;
	private Date orderDate;
	private int orderTotal;
	
	public Order(int id, Date orderDate, int orderTotal) {
		this.id = id;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
}

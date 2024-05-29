package com.rd.intern.app.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private String orderID;

    private Date dateOfCreation;

    private String content;

    public Order() {}
    
	public Order(String orderID, Date dateOfCreation, String content) {
		super();
		this.orderID = orderID;
		this.dateOfCreation = dateOfCreation;
		this.content = content;
	}

}

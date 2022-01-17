package com.customer.jpa.tutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "addr_sequence", sequenceName = "addr_sequence", allocationSize = 1)
	private Long addressId;
	private String addressLine;
	private String state;
	private String zipcode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customerId"/* ,nullable = false */)
	private Customer customer;

}


package com.customer.jpa.tutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

@Table(name = "customerName")
public class CustomerName {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "custName_sequence", sequenceName = "custName_sequence", allocationSize = 1)
	@Column(name = "customerNameId")
	private Long customerNameId;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "customer_Id", referencedColumnName = "customerId")
	 * private Customer customer;
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customerId"/* , nullable = false */)
	private Customer customer;

	private String firstName;
	private String lastName;
	private char middleInitial;

}

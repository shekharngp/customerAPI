package com.customer.jpa.tutorial.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://www.baeldung.com/hibernate-unsaved-transient-instance-error
//https://www.baeldung.com/hibernate-inheritance
//https://www.baeldung.com/jpa-mapping-single-entity-to-multiple-tables

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cust_sequence", sequenceName = "cust_sequence", allocationSize = 1)
	Long customerId;
	private Boolean active;
	private String mode;

	@OneToOne(cascade = CascadeType.ALL , mappedBy = "customer")
	private CustomerName customerName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id", referencedColumnName = "customerId")
	private List<Address> addresses;
}

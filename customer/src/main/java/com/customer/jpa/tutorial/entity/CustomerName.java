
package com.customer.jpa.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "id")
	private Long id;

	@OneToOne(mappedBy = "customerName")
	Customer customer;

	private String firstName;
	private String lastName;
	private char middleInitial;

}

package com.central.stores.employees.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.central.stores.employees.constants.Conf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String rg;
	@Column(nullable = false)
	private String role;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private Boolean active;
	@Column(nullable = false)
	@DateTimeFormat(pattern = Conf.dateFormat)
	private Date created;
	@DateTimeFormat(pattern = Conf.dateFormat)
	private Date changed;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contactId")
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
}
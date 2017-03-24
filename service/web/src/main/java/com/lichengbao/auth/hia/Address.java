/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.sun.istack.internal.NotNull;

/**
 * @author jwang
 *
 */
@Embeddable
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7004087354339384005L;
	
//	@Id
//	@GeneratedValue(generator = "addressKeyGenerator")
//	@GenericGenerator(
//			name = "addressKeyGenerator", 
//			strategy = "foreign", 
//			parameters = @Parameter(name = "property", value = "user"))
//	private Long id;

	@NotNull
	@Column(nullable = false)
	private String street;
	
	@NotNull
	@Column(nullable = false)
	private String zipcode;
	
	@NotNull
	@Column(nullable = false)
	private String city;
	
//	@ElementCollection
//	@CollectionTable(name = "contact", joinColumns = @JoinColumn(name = "user_id"))
//	@Column(name = "name", nullable = false)
//	private Set<String> contacts = new HashSet<>();
	
	@OneToMany
	@JoinColumn(name = "delivery_address_user_id", nullable = false)
	private Set<Shipment> deliveries = new HashSet<>();
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}

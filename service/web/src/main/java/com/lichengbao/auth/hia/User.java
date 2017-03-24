/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author jwang
 *
 */
@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6778644648115180874L;
	
	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	private Long id;

	private String username;
	
	private String firstname;
	
	private String lastname;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "home_address_id")
//	private Address home;
//	
//	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "billing_address_id")
//	private Address billing;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "shipping_address_id")
	private Address shipping;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private BillingDetails defaultBilling;
	
	@OneToMany(mappedBy = "user")
	private Set<BillingDetails> billingDetails = new HashSet<>();
	
	@OneToMany(mappedBy = "buyer")
	private Set<Item> boughtItems = new HashSet<>();
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
//	/**
//	 * @return the home
//	 */
//	public Address getHome() {
//		return home;
//	}
//	
//	/**
//	 * @param home the home to set
//	 */
//	public void setHome(Address home) {
//		this.home = home;
//	}
	
//	/**
//	 * @return the billing
//	 */
//	public Address getBilling() {
//		return billing;
//	}
//	
//	/**
//	 * @param billing the billing to set
//	 */
//	public void setBilling(Address billing) {
//		this.billing = billing;
//	}
	
	/**
	 * @return the shipping
	 */
	public Address getShipping() {
		return shipping;
	}
	
	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	
	public String getName() {
        return firstname + ' ' + lastname;
	}
	
    public void setName(String name) {
        StringTokenizer t = new StringTokenizer(name);
        firstname = t.nextToken();
        lastname = t.nextToken();
    }
	
	public BigDecimal calcShippingCosts(Address fromLocation) {
        // Empty implementation of business method
        return null;
	}
	
	/**
	 * @return the defaultBilling
	 */
	public BillingDetails getDefaultBilling() {
		return defaultBilling;
	}
	
	/**
	 * @param defaultBilling the defaultBilling to set
	 */
	public void setDefaultBilling(BillingDetails defaultBilling) {
		this.defaultBilling = defaultBilling;
	}

}

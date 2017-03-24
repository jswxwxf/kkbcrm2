/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 * @author jwang
 *
 */
@Entity
public class Shipment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5490035748830935329L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(
		name="item_shipment",
		joinColumns = @JoinColumn(name = "shipment_id"),
		inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false, unique = true))
	private Item auction;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the auction
	 */
	public Item getAuction() {
		return auction;
	}

	/**
	 * @param auction the auction to set
	 */
	public void setAuction(Item auction) {
		this.auction = auction;
	}
	
}

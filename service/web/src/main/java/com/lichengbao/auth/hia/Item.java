/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


/**
 * @author jwang
 *
 */
@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 179059075059295831L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(insertable = false)
	@ColumnDefault("1.00")
	@Generated(GenerationTime.INSERT)
	private BigDecimal initialPrice;
	
	@Temporal(TemporalType.DATE)
	private Calendar auctionEnd;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	@Generated(GenerationTime.ALWAYS)
	private Calendar lastModified;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Calendar createdAt;
	
	@NotNull
//	@Convert(converter = MonetaryAmountConverter.class, disableConversion = false)
	@Column(name = "price", length = 63)
	private BigDecimal buyNowPrice;
	
	private Dimensions dimensions;
	
	private Weight weight;
	
	@ElementCollection
	@CollectionTable(name = "image", joinColumns = @JoinColumn(name = "item_id"))
//	@AttributeOverride(name = "filename", column = @Column(name = "fname", nullable = false))
//	@CollectionId(columns = @Column(name = "image_id") , type = @Type(type = "long") , generator = "ID_GENERATOR")
//	@Column(name = "file_name", nullable = false)
//	@OrderBy(clause = "file_name desc")
	private Set<Image> images = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item_id", nullable = false)
	@OrderColumn(name = "bid_position", nullable = false)
	private List<Bid> bids = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
		name="item_buyer",
		joinColumns = @JoinColumn(name = "item_id"),
		inverseJoinColumns = @JoinColumn(name = "buyer_id", nullable = false) )
	private User buyer;
	
	@OneToMany(mappedBy = "item")
	private Set<CategorizedItem> categorizedItems = new HashSet<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the initialPrice
	 */
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	/**
	 * @param initialPrice the initialPrice to set
	 */
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	/**
	 * @return the auctionEnd
	 */
	public Calendar getAuctionEnd() {
		return auctionEnd;
	}

	/**
	 * @param auctionEnd the auctionEnd to set
	 */
	public void setAuctionEnd(Calendar auctionEnd) {
		this.auctionEnd = auctionEnd;
	}

	/**
	 * @return the lastModified
	 */
	public Calendar getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the buyNowPrice
	 */
	public BigDecimal getBuyNowPrice() {
		return buyNowPrice;
	}

	/**
	 * @param buyNowPrice the buyNowPrice to set
	 */
	public void setBuyNowPrice(BigDecimal buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}

	/**
	 * @return the dimensions
	 */
	public Dimensions getDimensions() {
		return dimensions;
	}

	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	/**
	 * @return the weight
	 */
	public Weight getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	/**
	 * @return the images
	 */
	public Set<Image> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(Set<Image> images) {
		this.images = images;
	}

	/**
	 * @return the bids
	 */
	public List<Bid> getBids() {
		return bids;
	}

	/**
	 * @param bids the bids to set
	 */
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	/**
	 * @return the buyer
	 */
	public User getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return the categorizedItems
	 */
	public Set<CategorizedItem> getCategorizedItems() {
		return categorizedItems;
	}

	/**
	 * @param categorizedItems the categorizedItems to set
	 */
	public void setCategorizedItems(Set<CategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}
	
}

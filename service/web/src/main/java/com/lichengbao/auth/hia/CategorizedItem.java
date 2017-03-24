/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Immutable;

/**
 * @author jwang
 *
 */
@Entity
@Immutable
public class CategorizedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7818814758594549436L;
	
	@Embeddable
	public static class Id implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5877326494194114544L;
		
		@Column(name = "category_id")
		private Long categoryId;
		
		@Column(name = "item_id")
		private Long itemId;
		
		/**
		 * 
		 */
		public Id() { }

		/**
		 * @param categoryId
		 * @param itemId
		 */
		public Id(Long categoryId, Long itemId) {
			this.categoryId = categoryId;
			this.itemId = itemId;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
			result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (categoryId == null) {
				if (other.categoryId != null)
					return false;
			} else if (!categoryId.equals(other.categoryId))
				return false;
			if (itemId == null) {
				if (other.itemId != null)
					return false;
			} else if (!itemId.equals(other.itemId))
				return false;
			return true;
		}
		
	}
	
	@EmbeddedId
	private Id id = new Id();
	
	@Column(updatable = false)
	@NotNull
	private String addedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@NotNull
	private Calendar addedAt = Calendar.getInstance();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private Item item;

	/**
	 * @param addedByUserName
	 * @param category
	 * @param item
	 */
	public CategorizedItem(String addedByUserName, Category category, Item item) {
		
		this.addedBy = addedByUserName;
		this.category = category;
		this.item = item;
		
		this.id.categoryId = this.category.getId();
		this.id.itemId = this.item.getId();
		
		category.getCategorizedItems().add(this);
		item.getCategorizedItems().add(this);
		
	}

	/**
	 * @return the id
	 */
	public Id getId() {
		return id;
	}

	/**
	 * @return the addedBy
	 */
	public String getAddedBy() {
		return addedBy;
	}

	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	/**
	 * @return the addedAt
	 */
	public Calendar getAddedAt() {
		return addedAt;
	}

	/**
	 * @param addedAt the addedAt to set
	 */
	public void setAddedAt(Calendar addedAt) {
		this.addedAt = addedAt;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
}

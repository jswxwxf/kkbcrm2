/**
 * 
 */
package com.lichengbao.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "regions")
public class Region implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3067981417164602084L;

	@Id
	@Column(name = "code")
	private Long id;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "parent_code")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private Region parent;
	
	@Column(name = "parent_code")
	private Long pid;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
//	private Set<Region> children;
	
	private String nameCn;
	
	private String nameShort;
	
	private String nameEn;
	
	private Boolean available = true;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}
	
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

//	/**
//	 * @return the parent
//	 */
//	public Region getParent() {
//		return parent;
//	}
//
//	/**
//	 * @param parent the parent to set
//	 */
//	public void setParent(Region parent) {
//		this.parent = parent;
//	}

//	/**
//	 * @return the children
//	 */
//	public Set<Region> getChildren() {
//		return children;
//	}
//
//	/**
//	 * @param children the children to set
//	 */
//	public void setChildren(Set<Region> children) {
//		this.children = children;
//	}

	/**
	 * @return the nameCn
	 */
	public String getNameCn() {
		return nameCn;
	}

	/**
	 * @param nameCn the nameCn to set
	 */
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	/**
	 * @return the nameShort
	 */
	public String getNameShort() {
		return nameShort;
	}

	/**
	 * @param nameShort the nameShort to set
	 */
	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}

	/**
	 * @return the nameEn
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @param nameEn the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * @return the available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}

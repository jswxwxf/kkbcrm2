/**
 * 
 */
package com.lichengbao.domain.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "vehicle_models")
public class VehicleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2181057720520202292L;
	
	@Id
	@GeneratedValue
	private Long id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "pid")
//	@NotFound(action = NotFoundAction.IGNORE)
//	private VehicleModel parent;
	
	private Long pid;
	
	private String py;
	
	private String nameCn;
	
	private String nameEn;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
//	public VehicleModel getParent() {
//		return parent;
//	}
//
//	/**
//	 * @param parent the parent to set
//	 */
//	public void setParent(VehicleModel parent) {
//		this.parent = parent;
//	}

	/**
	 * @return the py
	 */
	public String getPy() {
		return py;
	}

	/**
	 * @param py the py to set
	 */
	public void setPy(String py) {
		this.py = py;
	}

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
	
}

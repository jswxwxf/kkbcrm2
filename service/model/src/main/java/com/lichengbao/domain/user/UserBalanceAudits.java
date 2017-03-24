/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jwang
 *
 */
@Entity
public class UserBalanceAudits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -153205296767208002L;
	
	@Id
	@GeneratedValue
	private Long id;

}

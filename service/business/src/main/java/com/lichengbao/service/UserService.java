/**
 * 
 */
package com.lichengbao.service;

import com.lichengbao.domain.user.User;

/**
 * @author jwang
 *
 */
public interface UserService {

	/**
	 * @param username
	 * @return
	 */
	User loadUserByUsername(String username);

}

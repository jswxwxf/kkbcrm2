/**
 * 
 */
package com.lichengbao.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lichengbao.domain.user.User;
import com.lichengbao.service.UserService;

/**
 * @author jwang
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.lichengbao.service.UserService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public User loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}

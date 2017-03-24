/**
 * 
 */
package com.lichengbao.repository;

import org.springframework.stereotype.Repository;

import com.lichengbao.domain.user.User;


/**
 * @author jwang
 *
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
	
	User findByUsername(String username);

}

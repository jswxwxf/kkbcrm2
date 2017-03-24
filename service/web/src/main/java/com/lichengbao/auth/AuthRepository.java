/**
 * 
 */
package com.lichengbao.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jwang
 *
 */
@Repository
public interface AuthRepository extends JpaRepository<AuthUser, Integer> {

	AuthUser findByUsername(String username);
	
}

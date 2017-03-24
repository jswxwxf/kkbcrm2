/**
 * 
 */
package com.lichengbao.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jwang
 *
 */
@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AuthUser login(@RequestBody @Valid AuthUser loginUser) {
		return authService.createTokenForUser(loginUser);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		SecurityContextHolder.clearContext();;
	}

}

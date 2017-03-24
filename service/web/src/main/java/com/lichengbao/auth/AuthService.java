/**
 * 
 */
package com.lichengbao.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author jwang
 *
 */
@Service
public class AuthService implements UserDetailsService {
	
	private static final String SECRET = "tooManySecret";
	
    private static final String AUTH_HEADER_NAME = "Authorization";
    
	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
	private AccountStatusUserDetailsChecker detailsChecker;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthUser user = this.checkUser(username);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		org.springframework.security.core.userdetails.User userDetails = 
				new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		detailsChecker.check(userDetails);
		return userDetails;
		
	}
	
	public AuthUser parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return authRepository.findByUsername(username);
    }
	
	private AuthUser checkUser(String username) {
		AuthUser user = authRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		return user;
	}

    public AuthUser createTokenForUser(AuthUser loginUser) {
    	AuthUser user = this.checkUser(loginUser.getUsername());
    	// 1天后过期
        user.setToken(Jwts.builder()
        		.setHeaderParam("typ", "JWT")
                .setSubject(user.getUsername())
                .setExpiration(DateUtils.addDays(new Date(), 1))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact());
        user.setPassword(null);
        return user;
    }
    
    public Authentication getAuthentication(HttpServletRequest request) {
    	String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
        	token = token.substring(7);
            final AuthUser user = parseUserFromToken(token);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;

    }

}

class UserAuthentication implements Authentication {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5573069777746455297L;

	private AuthUser user;
	
	private boolean authenticated = true;
	
	/**
	 * 
	 */
	public UserAuthentication(AuthUser user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		return user.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return user.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getDetails()
	 */
	@Override
	public Object getDetails() {
		return user;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return user.getUsername();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#isAuthenticated()
	 */
	@Override
	public boolean isAuthenticated() {
		return this.authenticated;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.Authentication#setAuthenticated(boolean)
	 */
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;
	}

}

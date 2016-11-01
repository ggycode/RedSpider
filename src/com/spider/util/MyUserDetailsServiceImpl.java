package com.spider.util;


import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spider.user.dao.UserDao;
import com.spider.user.model.User;

@Service("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao; 

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException, DataAccessException {
		logger.info("attempt to login username is "+arg0);
		User user = userDao.getUserInfoByName(arg0);
		if(user != null){
			boolean enables = false;
			if("enabled".equals(user.getState())){
				enables = true;
			}
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
			authSet.add(new GrantedAuthorityImpl(user.getRole()));
			org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.getUserName(),
					user.getPassword(),enables,accountNonExpired,credentialsNonExpired,accountNonLocked,authSet);
			return userDetail;
		}
		return null;
	}

}

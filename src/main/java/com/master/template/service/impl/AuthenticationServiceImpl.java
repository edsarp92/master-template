package com.master.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.master.template.domain.User;
import com.master.template.domain.UserDetail;
import com.master.template.domain.UserExample;
import com.master.template.mapper.UserMapper;
import com.master.template.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userId);
		User user = userMapper.selectOneByExample(example);
		if (user != null) {
			UserDetail details = new UserDetail();
			details.setUser(user);
			return details;
		}else{
			throw new BadCredentialsException("User Not Found");
		}
	}

}

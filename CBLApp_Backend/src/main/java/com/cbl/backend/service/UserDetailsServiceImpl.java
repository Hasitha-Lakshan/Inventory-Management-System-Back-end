package com.cbl.backend.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cbl.backend.model.Employee;
import com.cbl.backend.repository.EmployeeRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("No user found" + username));
		
		return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), true, true, true, true, getAuthorities("ROLE_USER"));		
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}
}

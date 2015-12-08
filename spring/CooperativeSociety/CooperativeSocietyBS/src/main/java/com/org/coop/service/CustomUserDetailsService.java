/**
 * This class is used in order to lookup the username, password and GrantedAuthorities for any given user. 
 * This interface provide only one method which implementing class need to implement.
 */
package com.org.coop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.coop.customer.service.LoginService;
import com.org.coop.society.data.customer.repositories.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	private static final Logger log = Logger.getLogger(CustomUserDetailsService.class); 

    @Autowired
    private UserRepository userRepository;
     
    @Autowired
    private LoginService loginService;
    
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        com.org.coop.society.data.customer.entities.User user = userRepository.findByUserName(ssoId);
        log.debug("Requested User for authentication: "+user);
        if(user==null){
            log.info("User not found: " + ssoId);
            throw new UsernameNotFoundException("Username not found");
        }
        boolean isUserActive = (user.getEndDate() == null) ? true : false;
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserCredential().getPassword(), 
                 isUserActive, true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(com.org.coop.society.data.customer.entities.User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<String> roleList = loginService.getRole(user.getUserName());
        for(String role : roleList){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        log.debug("GrantedAuthority= :" + authorities);
        return authorities;
    }
     
}
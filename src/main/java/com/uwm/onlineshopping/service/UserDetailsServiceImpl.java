package com.uwm.onlineshopping.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.model.UserEntity;
import com.uwm.onlineshopping.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user=userRepository.findByUserName(userName);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),true, true,true,true, getAuthorities(user.getRole().getRoleName()));
        }
        throw new UsernameNotFoundException(userName);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String roleName){
        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }
}

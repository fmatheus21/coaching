package com.firecode.app.controller.security;

import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.service.UserService;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optional = userService.findByUser(username);
        UserEntity user = optional.orElseThrow(() -> new UsernameNotFoundException(null));
        return new AppUser(user, this.authorities(user));
    }

    private Collection<? extends GrantedAuthority> authorities(UserEntity user) {
        Set<SimpleGrantedAuthority> authoritys = new HashSet<>();
        user.getPermissions().forEach(p -> authoritys.add(new SimpleGrantedAuthority(p.getName().toUpperCase())));
        return authoritys;
    }

}

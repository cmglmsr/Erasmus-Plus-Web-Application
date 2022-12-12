package com.crackware.erasmus.data.services.security;

import com.crackware.erasmus.data.model.security.User;
import com.crackware.erasmus.data.repositories.security.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with mail: " + mail));

        return UserDetailsImpl.build(user);
    }
}

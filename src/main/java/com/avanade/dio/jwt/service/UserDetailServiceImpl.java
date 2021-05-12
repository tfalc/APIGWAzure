package com.avanade.dio.jwt.service;

import com.avanade.dio.jwt.data.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static java.util.Collections.emptyList;

public class UserDetailServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserData user = new UserData();
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        return new User(user.getUserName(), user.getPassword(), emptyList());
    }

    private UserData findUser(Stringi userName) {
        UserData user = new UserData();
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("nimda"));

        return user;
    }
}

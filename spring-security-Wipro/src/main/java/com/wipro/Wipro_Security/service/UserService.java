package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.Userinfo;
import com.wipro.Wipro_Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    public Userinfo createUser(Userinfo user) {
//        return userRepository.save(user) ;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Userinfo> user=userRepository.findByName(username);
        if(user.isPresent()){
            var userobj=user.get();
            return User.builder()
                    .username(userobj.getName())
                    .password(userobj.getPassword())
                    .roles(userobj.getRoles())
                    .build();
        }else{
            throw new UsernameNotFoundException(username+" not found");
        }
    }
    public String[] getRoles(Userinfo user){
        if(user.getRoles()==null){
            return new String[]{"USER"};
        }
        return user.getRoles().split(",");
    }
}

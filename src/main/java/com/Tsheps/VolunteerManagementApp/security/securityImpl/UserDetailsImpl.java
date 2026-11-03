package com.Tsheps.VolunteerManagementApp.security.securityImpl;

import com.Tsheps.VolunteerManagementApp.exception.UserNotFoundException;
import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.hibernate.internal.util.Optional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UsersRepo usersRepo;
    private final UserCredentialsRepo userCredentialsRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Load UserDetails and build UserDetails.User
        Users user  = usersRepo.findByEmail(email);

        if (user==null){
            System.out.println("Username not found");
            throw new UsernameNotFoundException("Username not found");
        }
        UserCredentials usersCredentials = userCredentialsRepo.findByUser_UserId(user.getUserId());

        return org.springframework.security.core.userdetails.User.builder()
                                    .username(user.getEmail())
                                    .password(usersCredentials.getPassword())
                                    .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                                    .build();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}

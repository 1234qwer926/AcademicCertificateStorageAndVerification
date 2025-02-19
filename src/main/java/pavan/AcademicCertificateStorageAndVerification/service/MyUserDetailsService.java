package pavan.AcademicCertificateStorageAndVerification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pavan.AcademicCertificateStorageAndVerification.model.Customer;
import pavan.AcademicCertificateStorageAndVerification.repository.CustomerRepo;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepo crepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer c = crepo.findByUname(username);
        if (c == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(c.getUname(), c.getPwd(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + c.getRole())));
    }

}
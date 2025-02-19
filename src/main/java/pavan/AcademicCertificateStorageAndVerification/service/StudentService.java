package pavan.AcademicCertificateStorageAndVerification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavan.AcademicCertificateStorageAndVerification.filter.AppFilter;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;
import pavan.AcademicCertificateStorageAndVerification.model.Customer;
import pavan.AcademicCertificateStorageAndVerification.model.Profile;
import pavan.AcademicCertificateStorageAndVerification.repository.CustomerRepo;

@Service
public class StudentService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private AppFilter filter;
    public Profile geprofile() {
        Profile details=new Profile();
        Customer userdetails=repo.findByUname(filter.getUsername());
        details.setUsername(userdetails.getUname());
        details.setEmailId(userdetails.getEmail());
        details.setPhoneNo(userdetails.getPhno());

        return details;
    }

}

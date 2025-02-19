package pavan.AcademicCertificateStorageAndVerification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavan.AcademicCertificateStorageAndVerification.Role;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;
import pavan.AcademicCertificateStorageAndVerification.model.Customer;
import pavan.AcademicCertificateStorageAndVerification.repository.CertificateRepo;
import pavan.AcademicCertificateStorageAndVerification.repository.CustomerRepo;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private CertificateRepo certificateRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public String uploadCertifi(Certificates certificate) {
        certificateRepo.save(certificate);
        return "Saved";
    }

    public List<Certificates> getCertificatesByUsername(String username) {
        List<Certificates> certificates= certificateRepo.findAllByCustomerUsername(username);
        for(Certificates c:certificates){
            Customer student=c.getCustomer();
            student.setPwd("");
            student.setUname("");
        }
        return certificates;
    }

    public List<Certificates> getCertificatesByRollNo(String rollNo) {
        return certificateRepo.findAllByCustomerRollNo(rollNo);
    }

    public String verify(String username) {
        Customer user=customerRepo.findByUname(username);
        user.setRole(Role.VERIFIER);
        customerRepo.save(user);
        return "verified";
    }


}

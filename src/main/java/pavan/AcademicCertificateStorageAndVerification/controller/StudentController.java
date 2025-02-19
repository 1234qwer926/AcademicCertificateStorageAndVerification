package pavan.AcademicCertificateStorageAndVerification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pavan.AcademicCertificateStorageAndVerification.filter.AppFilter;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;
import pavan.AcademicCertificateStorageAndVerification.model.Customer;
import pavan.AcademicCertificateStorageAndVerification.model.Profile;
import pavan.AcademicCertificateStorageAndVerification.service.AdminService;
import pavan.AcademicCertificateStorageAndVerification.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private AppFilter filter;

    @Autowired
    private AdminService adminService;

    @Autowired
     private  StudentService service;

    @GetMapping("/hello")
    public String greet() {
        return "Hello user";
    }

    @GetMapping("/profile")
    public Profile getprofile() {
        return service.geprofile();
    }

    @GetMapping("/certificates")
    public List<Certificates> getCertificates(){
        return adminService.getCertificatesByUsername(filter.getUsername());
    }
    //make a request to be a verifier

}

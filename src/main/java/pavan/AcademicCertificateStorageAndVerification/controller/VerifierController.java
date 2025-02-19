package pavan.AcademicCertificateStorageAndVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;
import pavan.AcademicCertificateStorageAndVerification.model.Profile;
import pavan.AcademicCertificateStorageAndVerification.service.AdminService;
import pavan.AcademicCertificateStorageAndVerification.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/verifier")
public class VerifierController {
    @Autowired
    private StudentService service;

    @Autowired
    private AdminService adminService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello verifier";
    }
    @GetMapping("/profile")
    public Profile getprofile() {
        return service.geprofile();
    }

    @GetMapping("/certificates")
    public List<Certificates> getCertificates(@RequestBody String rollNo){
        return adminService.getCertificatesByRollNo(rollNo);
    }


}

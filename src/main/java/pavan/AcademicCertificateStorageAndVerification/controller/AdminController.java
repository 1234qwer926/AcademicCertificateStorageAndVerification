package pavan.AcademicCertificateStorageAndVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;
import pavan.AcademicCertificateStorageAndVerification.model.Profile;
import pavan.AcademicCertificateStorageAndVerification.model.University;
import pavan.AcademicCertificateStorageAndVerification.service.AdminService;
import pavan.AcademicCertificateStorageAndVerification.service.StudentService;
import pavan.AcademicCertificateStorageAndVerification.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private StudentService service;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UniversityService universityService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello admin";
    }
    @GetMapping("/profile")
    public Profile getprofile() {
        return service.geprofile();
    }
    @PostMapping("/addUniversity")
    public String addUniversity(@RequestBody University university){
        return universityService.addUniversity(university);
    }
    @PostMapping("/certificate")
    public String uploadCertificate(@RequestBody Certificates certificate){
        return adminService.uploadCertifi(certificate);
    }
    @GetMapping("/certificates")
    public List<Certificates> getCertificates(@RequestBody String username){
        return adminService.getCertificatesByUsername(username);
    }
    //validate the verifer and give the authorization
    @PostMapping("/verify")
    public String verified(@RequestBody String username){
        return adminService.verify(username);
    }
}

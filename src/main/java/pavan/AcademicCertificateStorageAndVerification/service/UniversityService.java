package pavan.AcademicCertificateStorageAndVerification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavan.AcademicCertificateStorageAndVerification.model.University;
import pavan.AcademicCertificateStorageAndVerification.repository.UniversityRepo;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepo universityRepo;

    public String addUniversity(University university) {
        universityRepo.save(university);
        return "Saved";

    }
}

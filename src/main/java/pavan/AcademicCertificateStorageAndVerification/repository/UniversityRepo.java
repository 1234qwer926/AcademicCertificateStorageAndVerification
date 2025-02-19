package pavan.AcademicCertificateStorageAndVerification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavan.AcademicCertificateStorageAndVerification.model.University;

public interface UniversityRepo extends JpaRepository<University,Integer> {
}

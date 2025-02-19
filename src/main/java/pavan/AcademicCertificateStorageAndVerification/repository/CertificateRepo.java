package pavan.AcademicCertificateStorageAndVerification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pavan.AcademicCertificateStorageAndVerification.model.Certificates;

import java.util.List;

public interface CertificateRepo extends JpaRepository<Certificates, Integer> {

    @Query("SELECT c FROM Certificates c WHERE c.customer.uname = :username")
    List<Certificates> findAllByCustomerUsername(@Param("username") String username);

    @Query("SELECT c FROM Certificates c WHERE c.customer.rollNo = :rollNo")
    List<Certificates> findAllByCustomerRollNo(@Param("rollNo") String rollNo);
}

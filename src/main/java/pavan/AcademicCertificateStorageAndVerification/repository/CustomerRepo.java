package pavan.AcademicCertificateStorageAndVerification.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pavan.AcademicCertificateStorageAndVerification.model.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    public Customer findByUname(String cuname);

}
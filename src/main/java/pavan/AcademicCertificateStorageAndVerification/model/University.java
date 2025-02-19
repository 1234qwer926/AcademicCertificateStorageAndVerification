package pavan.AcademicCertificateStorageAndVerification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityId;
    private String universityName;
    private String Location;

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }


    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getLocation() {
        return Location;
    }
}

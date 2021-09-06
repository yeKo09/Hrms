package kodlamaio.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPostingStaffValidation;

public interface JobPostingStaffValidationDao extends JpaRepository<JobPostingStaffValidation, Integer>{

	
	List<JobPostingStaffValidation> getByIsVerified(String isVerified);
	
	@Modifying
	@Query("Update JobPostingStaffValidation Set isVerified='yes',verifiedAt=:verifiedAt Where id=:id")
	void verifyJobPosting(int id, Date verifiedAt);

	
}

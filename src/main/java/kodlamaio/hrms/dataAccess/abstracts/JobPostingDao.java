package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	@Query("From JobPosting Where isActive = 'yes'")
	List<JobPosting> getAllActiveJobPostings();
	
	List<JobPosting> getByIsActive(String isActive, Sort sort);
	
	List<JobPosting> getByEmployer_CompanyNameAndIsActive(String companyName,String isActive);
	
	@Modifying
	@Query("Update JobPosting Set isActive = 'no' Where id=:id")
	void deactiveJobPosting(int id);
	
}

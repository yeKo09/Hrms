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
	
	/* If i want to use JobPostingWithEmployerAndJobTitleDao, i will use the Query(ies) below:
	 * @Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive = 'yes'")
	List<JobPosting> getAllActiveJobPostings();*/
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive=:isActive")*/
	List<JobPosting> getByIsActive(String isActive, Sort sort);
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive=:isActive"
			+ " and e.companyName=:companyName")*/
	List<JobPosting> getByEmployer_CompanyNameAndIsActive(String companyName,String isActive);
	
	@Modifying
	@Query("Update JobPosting Set isActive = 'no' Where id=:id")
	void deactiveJobPosting(int id);
	
}

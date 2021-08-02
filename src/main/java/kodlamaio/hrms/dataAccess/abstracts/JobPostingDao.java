package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	/*@Query("From JobPosting Where isActive = 'yes'")
	List<JobPosting> getAllActiveJobPostings();*/
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive = 'yes'")
	List<JobPostingWithEmployerAndJobTitleDto> getAllActiveJobPostings();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive=:isActive")
	List<JobPostingWithEmployerAndJobTitleDto> getByIsActive(String isActive, Sort sort);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(e.companyName,j.jobTitle,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Where jp.isActive=:isActive"
			+ " and e.companyName=:companyName")
	List<JobPostingWithEmployerAndJobTitleDto> getByEmployer_CompanyNameAndIsActive(String companyName,String isActive);
	
	@Modifying
	@Query("Update JobPosting Set isActive = 'no' Where id=:id")
	void deactiveJobPosting(int id);
	
}

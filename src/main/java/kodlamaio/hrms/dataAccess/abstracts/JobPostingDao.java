package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

	
	List<JobPosting> getByIsActiveAndJobPostingStaffValidation_IsVerified(String isActive, String isVerified);
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(jp.id,e.companyName,j.jobTitle,c.cityName,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Inner join jp.jobPostingStaffValidation jpsv Inner join jp.city c "
			+ "Where jp.isActive = 'yes' and jpsv.isVerified='yes'")
	List<JobPostingWithEmployerAndJobTitleDto> getAllActiveJobPostingsDto();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(jp.id,e.companyName,j.jobTitle,c.cityName,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Inner join jp.jobPostingStaffValidation jpsv Inner join jp.city c "
			+ "Where jp.isActive=:isActive and jpsv.isVerified='yes'")
	List<JobPostingWithEmployerAndJobTitleDto> getAllSortedByDateDto(String isActive, Sort sort);
	
	
	List<JobPosting> getByIsActiveAndJobPostingStaffValidation_IsVerified(String isActive, String isVerified, Sort sort);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto"
			+ "(jp.id,e.companyName,j.jobTitle,c.cityName,jp.numberOfOpenPositions,jp.createdAt,jp.deadlineDate) "
			+ "From JobPosting jp Inner join jp.employer e Inner join jp.jobPosition j Inner join jp.jobPostingStaffValidation jpsv Inner join jp.city c "
			+ "Where jp.isActive=:isActive"
			+ " and e.companyName=:companyName and jpsv.isVerified='yes'")
	List<JobPostingWithEmployerAndJobTitleDto> getByCompanyNameDto(String companyName, String isActive);
	
	
	List<JobPosting> getByEmployer_CompanyNameAndIsActiveAndJobPostingStaffValidation_IsVerified(String companyName,String isActive, String isVerified);
	
	JobPosting getByIdAndIsActive(int id,String isActive);
	
	@Modifying
	@Query("Update JobPosting Set isActive = 'no' Where id=:id")
	void deactiveJobPosting(int id);
	
	@Modifying
	void deleteById(int id);
	
}

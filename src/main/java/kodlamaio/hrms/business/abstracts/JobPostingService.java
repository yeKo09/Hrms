package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

public interface JobPostingService {

	Result addJobPosting(JobPosting jobPosting);
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostings();
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getByEmployer_CompanyNameAndIsActive(String companyName);
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateASC();
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDESC();
	
	Result deactivateJobPosting(int id);
}

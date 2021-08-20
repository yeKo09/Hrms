package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	Result addJobPosting(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getAllActiveJobPostings();
	
	DataResult<List<JobPosting>> getByEmployer_CompanyNameAndIsActive(String companyName);
	
	DataResult<List<JobPosting>> getAllSortedByDateASC();
	
	DataResult<List<JobPosting>> getAllSortedByDateDESC();
	
	Result deactivateJobPosting(int id);
}

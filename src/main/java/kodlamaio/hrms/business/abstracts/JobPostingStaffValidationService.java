package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingStaffValidation;

public interface JobPostingStaffValidationService {

	DataResult<List<JobPostingStaffValidation>> getAll();
	
	Result add(JobPostingStaffValidation jobPostingStaffValidation);
	
	Result verifyJobPosting(int id);
	
	Result deleteJobPosting(int id);
	
}

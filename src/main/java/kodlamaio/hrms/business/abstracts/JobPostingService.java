package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

public interface JobPostingService {

	Result addJobPosting(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getAllActiveJobPostings();
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingsWithDto();
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getByCompanyNameDto(String companyName);
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDtoASC();
	
	DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDtoDESC();
	
	DataResult<JobPosting> getById(int id);
	
	Result deactivateJobPosting(int id);
}

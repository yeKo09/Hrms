package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceService {

	Result add(JobSeekerExperience jobSeekerExperience);
	
	DataResult<List<JobSeekerExperience>> getAll();
	
	DataResult<List<JobSeekerExperience>> getByCvIdOrderByQuittedAtDesc(int id);
}

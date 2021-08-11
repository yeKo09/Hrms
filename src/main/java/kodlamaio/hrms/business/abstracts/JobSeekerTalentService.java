package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

public interface JobSeekerTalentService {

	Result add(JobSeekerTalent jobSeekerTalent);

	DataResult<List<JobSeekerTalent>> getAll();
	
	DataResult<List<JobSeekerTalent>> getTalentsByCvId(int id);
	
}

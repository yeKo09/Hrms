package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerTalentService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTalentDao;
import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

@Service
public class JobSeekerTalentManager implements JobSeekerTalentService{

	private JobSeekerTalentDao jobSeekerTalentDao;
	
	@Autowired
	public JobSeekerTalentManager(JobSeekerTalentDao jobSeekerTalentDao) {
		this.jobSeekerTalentDao = jobSeekerTalentDao;
	}

	@Override
	public Result add(JobSeekerTalent jobSeekerTalent) {
		this.jobSeekerTalentDao.save(jobSeekerTalent);
		return new SuccessResult("Yetenek eklendi.");
	}

}

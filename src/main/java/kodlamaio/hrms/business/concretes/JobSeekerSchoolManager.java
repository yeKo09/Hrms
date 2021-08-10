package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerSchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerSchoolDao;
import kodlamaio.hrms.entities.concretes.JobSeekerSchool;

@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService{
	
	private JobSeekerSchoolDao jobSeekerSchoolDao;
	
	@Autowired
	public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao) {
		this.jobSeekerSchoolDao = jobSeekerSchoolDao;
	}

	@Override
	public Result add(JobSeekerSchool jobSeekerSchool) {
		this.jobSeekerSchoolDao.save(jobSeekerSchool);
		return new SuccessResult("Okul eklendi.");
	}
	
}
